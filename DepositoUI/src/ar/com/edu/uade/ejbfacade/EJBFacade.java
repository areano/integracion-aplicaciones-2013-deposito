package ar.com.edu.uade.ejbfacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;



import sessionBeans.DepositoFacade;
//import ar.com.edu.uade.beans.DepositoFacade;
import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudCompraView;



public class EJBFacade {

	private static final Logger logger = 
			   Logger.getLogger(EJBFacade.class);
	
	
	static EJBFacade instance =null;
	
	static DepositoFacade systemFacade ;
	
	private EJBFacade() throws NamingException{
		getDepositoFacade();
	}
	public static EJBFacade getIntance() throws NamingException{
		if(instance==null){
			instance= new EJBFacade();
		}
		return instance;
	}
	public ArrayList<ConnectionView> getPortalConections(){
		
		return systemFacade.getPortalesConnection();

		
	}
	public ArrayList<ConnectionView> getDespachoConnection(){
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		ConnectionView dto = new ConnectionView();

		return systemFacade.getDespachosConnection();
	}
	public ArrayList<ConnectionView> getMonitoreoConnection(){
		return systemFacade.getMonitoreosConnection();
	}
	public ArrayList<ConnectionView> getFabricaConnection(){
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		return retorno;
	}
	public ArrayList<SolicitudArticulosView> getSolicitudesDeArticulos(){
		
		ElectrodomesticoView electro =new ElectrodomesticoView();
		ModaView moda =  new ModaView();
		electro.setCodigo(Long.valueOf(1));
		electro.setDescripcion("Un electro");
		electro.setFichaTecnica("una url");
		electro.setMarca("Modila");
		electro.setNombre("Supercalifragitisticoespiralidoso");
		electro.setOrigen("Tierra cdel fuego");
		electro.setPrecio( Float.parseFloat("12.5"));
		
		moda.setCodigo(Long.valueOf(1));
		moda.setDescripcion("una remera");
		moda.setTalle("XL");
		moda.setMarca("Mota");
		moda.setNombre("Motta inside");
		moda.setOrigen("El Salvador");
		moda.setPrecio( Float.parseFloat("12.5"));
		moda.setColor("Azul");
		
		ArrayList<SolicitudArticulosView> solicitudes =  new ArrayList<SolicitudArticulosView>();
		SolicitudArticulosView dto = new SolicitudArticulosView();
		
		dto.setIdModulo(1);
		SolicitudArticulosItemView item = new SolicitudArticulosItemView(electro, 2);
		dto.addItemSolicitudArticulos(item);

		dto.setDate(new java.util.Date());
		dto.setCodigoSolicitud(1);
		solicitudes.add(dto);
		
		dto = new SolicitudArticulosView();
		dto.setIdModulo(2);
		dto.setDate(new java.util.Date());
		dto.addItemSolicitudArticulos(new SolicitudArticulosItemView(electro, 5));
		dto.addItemSolicitudArticulos(new SolicitudArticulosItemView(moda, 5));
		dto.setCodigoSolicitud(2);
		solicitudes.add(dto);
		return solicitudes;
	}
	public ArrayList<SolicitudCompraView> getSolicitudesDeCompra(){		
	
		return null;

	}
	public Collection<? extends ArticuloView> getAllArticulos() {
//		ArrayList<ArticuloView> articulos =  new ArrayList<ArticuloView>();
//		ElectrodomesticoView electro =new ElectrodomesticoView();
//		ModaView moda =  new ModaView();
//		electro.setCodigo(Long.valueOf(1));
//		electro.setDescripcion("Un electro");
//		electro.setFichaTecnica("una url");
//		electro.setMarca("Modila");
//		electro.setNombre("Supercalifragitisticoespiralidoso");
//		electro.setOrigen("Tierra cdel fuego");
//		electro.setPrecio(Float.parseFloat("12.5"));
//		electro.setFoto("una Foto");
//		
//		moda.setCodigo(Long.valueOf(1));
//		moda.setDescripcion("una remera");
//		moda.setTalle("XL");
//		moda.setMarca("Mota");
//		moda.setNombre("Motta inside");
//		moda.setOrigen("El Salvador");
//		moda.setPrecio(Float.parseFloat("12.5"));
//		moda.setColor("Azul");
//		moda.setFoto("otra Foto");
//			
//		articulos.add(electro);
//		articulos.add(moda);
//		return articulos;
		return systemFacade.getArticulos();
		
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
	 public void getDepositoFacade() throws NamingException{
		   try {
				InitialContext ic = new InitialContext();
				systemFacade = (DepositoFacade) ic.lookup("java:global/Depostio_EAR/Deposito_EJB/DepositoFacadeBean");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	public static Object getRemote(String appName, String moduleName, String sessionBeanName, String viewClassName, Object user, Object pass) throws Exception {

			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL, "remote://localhots:4447");
			jndiProps.put(Context.SECURITY_PRINCIPAL, user);
			jndiProps.put(Context.SECURITY_CREDENTIALS, pass);
			jndiProps.put("jboss.naming.client.ejb.context", true);
			Context context = new InitialContext(jndiProps);

			return context.lookup(appName + "/" + moduleName + "/" + sessionBeanName + "!" + viewClassName);

	}
}
