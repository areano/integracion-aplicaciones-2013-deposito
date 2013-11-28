package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;

import org.apache.log4j.Logger;

import clientes.GenericQueueClient;
import parsers.ParserException;
import parsers.SolicitudCompraXMLParser;
import dto.SolicitudCompraDTO;


/**
 * Session Bean implementation class DepositoDAOBean
 */
@Stateless
@LocalBean
public class DepositoDAOBean  {
	
	private static final Logger logger = Logger.getLogger(DepositoDAOBean.class);


	private SolicitudCompraXMLParser parser=SolicitudCompraXMLParser.obtenerInstancia();
	
	public void entregarCompra(SolicitudCompraDTO compra) {

		try {
			String xml=null;
			xml = parser.toString(compra);
			enviar(xml);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void enviar(String xml) {
		String errorMessage = new String();
		//TODO: Ajustar y habilitar esto
		java.net.InetAddress localMachine =null;
		try {
			
			localMachine=java.net.InetAddress.getLocalHost();
			
			}
			catch (java.net.UnknownHostException uhe) { // [beware typo in
				uhe.printStackTrace();
			}
		
		String ipStr=localMachine.getAddress()[0] + "."+ localMachine.getAddress()[1]+ "." + localMachine.getAddress()[2]+ "." + localMachine.getAddress()[3];
		
		GenericQueueClient cliente = new GenericQueueClient("jms/queue/recepcionCompra", ipStr , "4447", "deposito", "deposito123");
		try {
			cliente.enviar(xml);
			cliente.cerrarConexion();
		} catch (JMSException e) {
			errorMessage = "*** Error enviando xml a jms de DEPOSITO ***";
			logger.error(errorMessage, e);
			e.printStackTrace();
		}
	}
}