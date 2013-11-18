package ar.com.edu.uade.ejbfacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;



import sessionBeans.DepositoFacade;
import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudArticulosView;
import view.SolicitudCompraView;

@Stateless
public class EJBFacade {

	private static final Logger logger = 
			   Logger.getLogger(EJBFacade.class);
	@EJB
	DepositoFacade systemFacade ;//= new DepositoFacadeBean();
	public static Object getRemote(String appName, String moduleName, String sessionBeanName, String viewClassName, Object user, Object pass) throws Exception {

		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProps.put(Context.PROVIDER_URL, "remote://localhost:4447");
		jndiProps.put(Context.SECURITY_PRINCIPAL, user);
		jndiProps.put(Context.SECURITY_CREDENTIALS, pass);
		jndiProps.put("jboss.naming.client.ejb.context", true);
		Context context = new InitialContext(jndiProps);

		return context.lookup(appName + "/" + moduleName + "/" + sessionBeanName + "!" + viewClassName);

	}
	public EJBFacade(){
			

	}

	public ArrayList<ConnectionView> getPortalConections(){
		
		ArrayList<ConnectionView> retorno = systemFacade.getPortalesConnection();
		return retorno;
		
	}
	public ArrayList<ConnectionView> getDespachoConnection(){
		ArrayList<ConnectionView> retorno = systemFacade.getDespachosConnection();
		return retorno;
	}
	public ArrayList<ConnectionView> getMonitoreoConnection(){
		ArrayList<ConnectionView> retorno = systemFacade.getMonitoreosConnection();
		return retorno;
	}
	public ArrayList<ConnectionView> getFabricaConnection(){
		ArrayList<ConnectionView> retorno = systemFacade.getFabricasConnection();
		return retorno;
	}
	public ArrayList<SolicitudArticulosView> getSolicitudesDeArticulos(){
		return systemFacade.getSolicitudesArticulos();
	}
	public ArrayList<SolicitudCompraView> getSolicitudesDeCompra(){		
	return systemFacade.getSolicitudesCompra();
		
	}
	public Collection<? extends ArticuloView> getAllArticulos() {
		ArrayList<ArticuloView> articulos =  new ArrayList<ArticuloView>();
			return articulos;
	}
	public void altaElectrodomestico(ElectrodomesticoView e){
		systemFacade.altaElectrodomestico(e);
	}

	public void altaModa(ModaView m) {
		systemFacade.altaModa(m);
	}


	public void altaMueble(MuebleView m) {
		systemFacade.altaMueble(m);
	}


	public void altaInfatil(InfantilView i) {
		systemFacade.altaInfatil(i);
	}
	public void savePortalesConnection(ArrayList<ConnectionView> activas){
		systemFacade.savePortalesConnection(activas);
	}
	public void saveMonitoreosConnection(ArrayList<ConnectionView> activas){
		systemFacade.saveMonitoreoConnection(activas);
	}
	public void saveDespachosConnection(ArrayList<ConnectionView> activas){
		systemFacade.saveDespachosConnection(activas);
	}
	public void saveFabricaConnection(ArrayList<ConnectionView> activas){
		systemFacade.savePortalesConnection(activas);
	}

}
