package ar.com.edu.uade.ejbfacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import ar.com.edu.uade.beans.DepositoFacade;
import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudArticulosView;
import view.SolicitudCompraView;


public class EJBFacade {

	private static final Logger logger = 
			   Logger.getLogger(EJBFacade.class);
	
	DepositoFacade systemFacade ;//= new DepositoFacadeBean();
	public class Client {
		
		public DepositoFacade  getEJB() throws NamingException{
	        final String appName = "Depostio_EAR";
	        final String moduleName = "Depostio_EAR";
	        final String sessionBeanName = "DepositoFacadeBean";
	        final String viewClassName = DepositoFacade.class.getName();
			 Properties jndiProps = new Properties();
			 jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			 jndiProps.put(Context.PROVIDER_URL,"remote://127.0.0.1:4447");
			 // username
			 jndiProps.put(Context.SECURITY_PRINCIPAL, "user");
			 // password
			 jndiProps.put(Context.SECURITY_CREDENTIALS, "user123");
			 // This is an important property to set if you want to do EJB invocations via the remote-naming project
			 jndiProps.put("jboss.naming.client.ejb.context", true);
			 // create a context passing these properties
			 Context context = new InitialContext(jndiProps);
			 // lookup the bean     Foo
			 DepositoFacade administradorProductos =(DepositoFacade)context.lookup(appName+"/"+moduleName+"/"+sessionBeanName+"!"+viewClassName);	
			 return administradorProductos;
		}
		
	}
	public EJBFacade(){
			Client c = new Client();
			try {
				systemFacade = c.getEJB();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
