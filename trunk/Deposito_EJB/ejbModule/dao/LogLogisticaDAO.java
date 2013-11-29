package dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import clientes.GenericQueueClient;
import parsers.LogParser;
import parsers.ParserException;
import dao.webservice.LogisticaMonitoreoBeanService;
import dao.webservice.LogisticaMonitoreoWS;
import dto.LogDTO;
import entities.MonitoreoConexion;


/**
 * Session Bean implementation class LogSincronico
 */
@Stateless
@LocalBean
public class LogLogisticaDAO {

	private static final Logger logger = Logger.getLogger(LogLogisticaDAO.class);
	
	@EJB
	ConnectionDAO cDAO;
	private List<MonitoreoConexion> conexiones;
	
	public LogLogisticaDAO() {
		
	}

	public void log(LogDTO entrada){
		conexiones = cDAO.getMonitoreos();
		String xml="";
		try{
			xml=LogParser.obtenerInstancia().toString(entrada);
		} catch (ParserException e) {
			String errorMessage = "*** Error parseando un DTO para log ***";
			logger.error(errorMessage, e);
		}
		
		for (MonitoreoConexion p : conexiones) {
			try {			
				if (p.isSyncronico()){
					
					URL url = new URL("http://" + p.getIp()+":"+p.getWsPuerto() + p.getWsPath() + "?wsdl");
					//TODO: AGREGAR TIMEOUT a la conexion al webservice
					LogisticaMonitoreoBeanService ws = new LogisticaMonitoreoBeanService(url);
					LogisticaMonitoreoWS puerto = ws.getLogisticaMonitoreoWSPort();
					puerto.informarLog(xml);
					logger.info("*** Enviado al Webservice de Monitoreo [" +p.getIp()+":"+p.getWsPuerto() + p.getWsPath() + "] Grupo [" + p.getMonitoreoId() + "]***");
				} else {
					
					GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(),p.getUsuario(), p.getPassword());
					cliente.enviar(xml);
					cliente.cerrarConexion();
					logger.info("*** Enviado al JMS de Monitoreo IP[" + p.getIp() + "] Grupo [" + p.getMonitoreoId() + "]***");
					
				}
			} catch (JMSException e) {
				String errorMessage = "*** Error enviando xml a jms de Monitoreo IP[" + p.getIp() + "] Grupo [" + p.getMonitoreoId() + "]***";
				logger.error(errorMessage, e);
			} catch (MalformedURLException e) {
				String errorMessage = "*** Error conectando al Webservice de Monitoreo [" +p.getIp()+":"+p.getWsPuerto() + p.getWsPath() + "]***";
				logger.error(errorMessage, e);
			} catch (NamingException e) {
				String errorMessage = "*** Error conectando a cola jms de Monitoreo IP[" + p.getIp() + "] Grupo [" + p.getMonitoreoId() + "]***";
				logger.error(errorMessage, e);
			}
		}
	}

}
