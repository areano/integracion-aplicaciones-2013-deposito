package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import dto.CompraDTO;
import sessionBeans.Facade;

/**
 * Message-Driven Bean implementation class for: RecepcionCompras
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "compras")
		}, 
		mappedName = "compras")
public class RecepcionCompras implements MessageListener {

	@EJB
	Facade facade;
	
    /**
     * Default constructor. 
     */
    public RecepcionCompras() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	
    	
    	CompraDTO compra = new CompraDTO();
    	facade.recibirCompra(compra);
    }

}
