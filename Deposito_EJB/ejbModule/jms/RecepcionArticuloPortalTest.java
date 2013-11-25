package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: RecepcionArticuloPortalTest
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms/queue/deposito")
		}, 
		mappedName = "jms/queue/deposito")
public class RecepcionArticuloPortalTest implements MessageListener {

    /**
     * Default constructor. 
     */
    public RecepcionArticuloPortalTest() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
        	
        	TextMessage txtMessage = (TextMessage) message;
        	System.out.println("Llega un articulo a la cola de Portal");
			System.out.println(txtMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
