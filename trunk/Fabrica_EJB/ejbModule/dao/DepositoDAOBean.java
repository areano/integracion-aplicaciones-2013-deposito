package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;

import org.apache.log4j.Logger;

import parsers.ParserException;
import parsers.SolicitudCompraXMLParserBean;
import clientes.GenericQueueClient;
import dto.SolicitudCompraDTO;


/**
 * Session Bean implementation class DepositoDAOBean
 */
@Stateless
@LocalBean
public class DepositoDAOBean  {
	@EJB
	SolicitudCompraXMLParserBean parser;
	
	private static final Logger logger = Logger.getLogger(DepositoDAOBean.class);

	
	public DepositoDAOBean() {
	}


	public void entregarCompra(SolicitudCompraDTO compra) {

		// TODO AR: create xml y enviar a la cola de Deposito
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
//		GenericQueueClient cliente = new GenericQueueClient("java:jboss/exported/jms/queue/recepcionCompra", "127.0.0.1" , "1099", "deposito", "deposito123");
//		try {
//			cliente.enviar(xml);
//			cliente.cerrarConexion();
//		} catch (JMSException e) {
//			errorMessage = "*** Error enviando xml a jms de DEPOSITO ***";
//			logger.error(errorMessage, e);
//			e.printStackTrace();
//		}
	}
}
