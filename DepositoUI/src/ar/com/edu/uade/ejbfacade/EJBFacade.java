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
import sessionBeans.DespachoSolicitudesFacade;
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
	static DespachoSolicitudesFacade despachoSolicitudesFacade;
	private EJBFacade() throws NamingException{
		getDepositoFacade();
		getDespachoFacade();
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
		
		return despachoSolicitudesFacade.getSolicitudes();
		//return systemFacade.getSolicitudesArticulos();
	}
	public ArrayList<SolicitudCompraView> getSolicitudesDeCompra(){			
		return null;
	}
	
	public void crearSolicitudCompra(SolicitudCompraView compra){
		systemFacade.crearSolicitudCompra(compra);
	}
	
	
	public SolicitudCompraView getRecomendacionCompra(){
		return systemFacade.getRecomendacionCompra();
	}
	
	
	public Collection<? extends ArticuloView> getAllArticulos() {
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
	 public void getDespachoFacade() throws NamingException{
		   try {
				InitialContext ic = new InitialContext();
				despachoSolicitudesFacade = (DespachoSolicitudesFacade) ic.lookup("java:global/Depostio_EAR/Deposito_EJB/DespachoSolicitudesFacadebean");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	public ArrayList<SolicitudArticulosView> markSolicitud(SolicitudArticulosView solicitud) {
		return despachoSolicitudesFacade.markSolicitud(solicitud);
		
	}
	public ArrayList<SolicitudArticulosView> unMarkSolicitud(SolicitudArticulosView solicitud) {
		return despachoSolicitudesFacade.unmarkSolicitud(solicitud);
		
	} 

}
