package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import parsers.ParserException;
import parsers.SolicitudCompraXMLParser;
import dto.SolicitudCompraDTO;
import excepctions.BackEndException;
import sessionBeans.Facade;

/**
 * Message-Driven Bean implementation class for: RecepcionCompras
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/recepcionCompra") }, mappedName = "jms/queue/recepcionCompra")
public class RecepcionCompras implements MessageListener {

	@EJB
	Facade facade;

	private static final Logger logger = Logger.getLogger(RecepcionCompras.class);
	SolicitudCompraXMLParser parser=SolicitudCompraXMLParser.obtenerInstancia();
	/**
	 * Default constructor.
	 */
	public RecepcionCompras() {
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {

		try {
			TextMessage txtMessage = (TextMessage) message;
			SolicitudCompraDTO compra = parser.toObject(txtMessage.getText());
			facade.recibirSolicitudCompra(compra);
		} catch (JMSException e) {
			// TODO AR - log error
			e.printStackTrace();
			logger.error("JMS Error", e);
		} catch (ParserException e) {
			// TODO AR - log error
			e.printStackTrace();
			logger.error("Error parseando XML de JMS", e);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error de Durante La recepcion", e);
		}

	}

}
