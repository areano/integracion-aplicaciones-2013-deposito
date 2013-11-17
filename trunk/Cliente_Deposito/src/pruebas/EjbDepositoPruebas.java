package pruebas;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dto.ModaDTO;
import sessionBeans.DepositoFacade;

public class EjbDepositoPruebas {

	public static void main(String args[]) throws Exception {
		DepositoFacade remote = (DepositoFacade) getRemote("Depostio_EAR", "Deposito_EJB", "DepositoFacadeBean", DepositoFacade.class.getName(), "deposito", "deposito123");
		ModaDTO dto = new ModaDTO();
		remote.altaModa(dto);
		
	}

	public static Object getRemote(String appName, String moduleName, String sessionBeanName, String viewClassName, Object user, Object pass) throws Exception {

		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProps.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447");
		jndiProps.put(Context.SECURITY_PRINCIPAL, user);
		jndiProps.put(Context.SECURITY_CREDENTIALS, pass);
		jndiProps.put("jboss.naming.client.ejb.context", true);
		Context context = new InitialContext(jndiProps);

		return context.lookup(appName + "/" + moduleName + "/" + sessionBeanName + "!" + viewClassName);

	}

}
