package dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;

import clientes.GenericQueueClient;
import parsers.LogParser;
import parsers.ParserException;
import dao.logistica.webservice.LogisticaMonitoreoBeanService;
import dao.logistica.webservice.LogisticaMonitoreoWS;
import dto.LogDTO;
import entities.MonitoreoConexion;


/**
 * Session Bean implementation class LogSincronico
 */
@Stateless
@LocalBean
public class LogLogisticaDAO {

	@EJB
	ConnectionDAO cDAO;
	private List<MonitoreoConexion> conexiones;
	
	public LogLogisticaDAO() {
		
	}

	public void log(LogDTO entrada){
		conexiones = cDAO.getMonitoreos();
		
		try {
			String xml=LogParser.obtenerInstancia().toString(entrada);
			for (MonitoreoConexion p : conexiones) {
				if (p.isSyncronico()){
					
					URL url = new URL(p.getIp()+":"+p.getPuerto() + p.getQueueName());
					LogisticaMonitoreoBeanService ws = new LogisticaMonitoreoBeanService(url);
					LogisticaMonitoreoWS puerto = ws.getLogisticaMonitoreoWSPort();
					puerto.informarLog(xml);
					
				} else {
					
					GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(), "user", "pass");
					cliente.enviar(xml);
					cliente.cerrarConexion();
					
				}
			}
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
