package jms;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GenericQueueClient {
	
	private Properties env;
	private String queueName;
	private String ip;
	private String port;
	private Connection connection;
	private Session session;
	private Destination destination;
	
	public GenericQueueClient(String queueName, String ip, String port){
		this.queueName = queueName;
		this.ip = ip;
		this.port = port;
		this.establecerConexion();
	}
	
	private void establecerConexion(){
        try {
        	// Set up the context for the JNDI lookup
    		env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "remote://"+ip+":"+port));
            env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", "usuario"));
            env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", "1234"));
            
        	
			Context context = new InitialContext(env);
			 // Perform the JNDI lookups
	        String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
	        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

	        String destinationString = System.getProperty("destination", queueName);
	        this.destination = (Destination) context.lookup(destinationString);

	        // Create the JMS connection, session, producer, and consumer
	        this.connection = connectionFactory.createConnection(System.getProperty("username", "usuario"), System.getProperty("password", "1234"));
	        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        connection.start();
	        MessageProducer producer = session.createProducer(destination);
	        
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void enviar(String mensaje){
		try {
				// crear un mensaje de tipo text y setearle el contenido
				TextMessage message = session.createTextMessage();
				message.setText(mensaje);
		} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	

}
