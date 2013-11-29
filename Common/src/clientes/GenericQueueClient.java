package clientes;

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
	private String username;
	private String password;
	private MessageProducer producer;

	public GenericQueueClient(String queueName, String ip, String port, String username, String password) throws NamingException, JMSException {
		this.queueName = queueName;
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;

		this.establecerConexion();
	}

	private void establecerConexion() throws NamingException, JMSException   {

			// Set up the context for the JNDI lookup
			env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "remote://" + ip + ":" + port));
			env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", username));
			env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", password));
			
			Context context = new InitialContext(env);
			// Perform the JNDI lookups
			String connectionFactoryString = System.getProperty("connection.factory", "jms/RemoteConnectionFactory");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);

			String destinationString = System.getProperty("destination", queueName);
			this.destination = (Destination) context.lookup(destinationString);

			// Create the JMS connection, session, producer, and consumer
			this.connection = connectionFactory.createConnection(username, password);
			this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();

			producer = session.createProducer(destination);
	}

	public void enviar(String mensaje) throws JMSException {
			if (session!=null){
				// crear un mensaje de tipo text y setearle el contenido
				TextMessage message = session.createTextMessage();
				message.setText(mensaje);
				producer.send(message);
			} else throw new JMSException("Fallo el envio JMS, no está abierta la sesión");

	}

	public void cerrarConexion() throws JMSException {
		connection.close();
	}

}
