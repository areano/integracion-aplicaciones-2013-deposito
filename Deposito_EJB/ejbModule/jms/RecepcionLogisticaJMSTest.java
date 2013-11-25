package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: RecepcionLogisticaJMSTest
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms/queue/log")
		}, 
		mappedName = "jms/queue/log")
public class RecepcionLogisticaJMSTest implements MessageListener {

    /**
     * Default constructor. 
     */
    public RecepcionLogisticaJMSTest() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        try {
        	TextMessage txtMessage = (TextMessage) message;
        	System.out.println("Llega un log a la cola de Monitoreo");
			System.out.println(txtMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
