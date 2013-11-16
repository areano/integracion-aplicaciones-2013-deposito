package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import parsers.ParserException;
import parsers.SolicitudArticulosParser;
import dto.SolicitudArticulosDTO;
import sessionBeans.Facade;

/**
 * Message-Driven Bean implementation class for: RecepcionSolicitudArticulos
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/solicitud") }, mappedName = "jms/queue/solicitud")
public class RecepcionSolicitudArticulos implements MessageListener {

	@EJB
	Facade facade;

	/**
	 * Default constructor.
	 */
	public RecepcionSolicitudArticulos() {
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {

		try {
			TextMessage txtMessage = (TextMessage) message;
			SolicitudArticulosParser parser = new SolicitudArticulosParser();
			SolicitudArticulosDTO solicitud = parser.toObject(txtMessage.getText());
			facade.recibirSolicitudArticulos(solicitud);
		} catch (JMSException e) {
			// TODO AR - log error
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO AR - log error
			e.printStackTrace();
		}
	}
}
