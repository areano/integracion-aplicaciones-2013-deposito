package ar.com.edu.uade.ejbfacade;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;



import excepctions.BackEndException;
import sessionBeans.DepositoFacade;
import sessionBeans.DespachoSolicitudesFacade;
import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.SolicitudArticulosView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudCompraView;

public class EJBFacade {


	static EJBFacade instance = null;

	static DepositoFacade systemFacade;
	static DespachoSolicitudesFacade despachoSolicitudesFacade;

	private EJBFacade() throws NamingException {
		getDepositoFacade();
		getDespachoFacade();
	}

	public static EJBFacade getIntance() throws NamingException {
		if (instance == null)  {
			instance = new EJBFacade();
		}
		return instance;
	}

	public ArrayList<ConnectionView> getPortalConections() throws BackEndException {

			return systemFacade.getPortalesConnection();

	}

	public ArrayList<ConnectionView> getDespachoConnection() throws BackEndException {

			return systemFacade.getDespachosConnection();


	}

	public ArrayList<ConnectionView> getMonitoreoConnection() throws BackEndException {

			return systemFacade.getMonitoreosConnection();

	}

	public ArrayList<ConnectionView> getFabricaConnection() throws BackEndException {
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		return retorno;
	}

	public ArrayList<SolicitudArticulosView> getSolicitudesDeArticulos() throws BackEndException {

			return despachoSolicitudesFacade.getSolicitudes();

	}

	public ArrayList<SolicitudCompraView> getSolicitudesDeCompra() throws BackEndException {
		return null;
	}

	public void crearSolicitudCompra(SolicitudCompraView compra) throws BackEndException {

			systemFacade.crearSolicitudCompra(compra);

	}

	public SolicitudCompraView getRecomendacionCompra() throws BackEndException {

			return systemFacade.getRecomendacionCompra();

	}

	public Collection<? extends ArticuloView> getAllArticulos() throws BackEndException {

			return systemFacade.getArticulos();

	}

	public void altaElectrodomestico(ElectrodomesticoView e) throws BackEndException {

			systemFacade.altaElectrodomestico(e);

	}

	public void altaModa(ModaView m) throws BackEndException {

			systemFacade.altaModa(m);

	}

	public void altaMueble(MuebleView m) throws BackEndException {

			systemFacade.altaMueble(m);

	}

	public void altaInfatil(InfantilView i) throws BackEndException {

			systemFacade.altaInfatil(i);

	}

	public void savePortalesConnection(ArrayList<ConnectionView> activas) throws BackEndException {

			systemFacade.savePortalesConnection(activas);

	}

	public void saveMonitoreosConnection(ArrayList<ConnectionView> activas) throws BackEndException {

			systemFacade.saveMonitoreoConnection(activas);

	}

	public void saveDespachosConnection(ArrayList<ConnectionView> activas) throws BackEndException {

			systemFacade.saveDespachosConnection(activas);

	}

	public void saveFabricaConnection(ArrayList<ConnectionView> activas) throws BackEndException {

			systemFacade.savePortalesConnection(activas);

	}

	public void getDepositoFacade() throws NamingException {

			InitialContext ic = new InitialContext();
			systemFacade = (DepositoFacade) ic.lookup("java:global/Depostio_EAR/Deposito_EJB/DepositoFacadeBean");

	}

	public void getDespachoFacade() throws NamingException {

			InitialContext ic = new InitialContext();
			despachoSolicitudesFacade = (DespachoSolicitudesFacade) ic.lookup("java:global/Depostio_EAR/Deposito_EJB/DespachoSolicitudesFacadebean");

	}

	public ArrayList<SolicitudArticulosView> markSolicitud(SolicitudArticulosView solicitud) throws BackEndException {

			return despachoSolicitudesFacade.markSolicitud(solicitud);

	}

	public ArrayList<SolicitudArticulosView> unMarkSolicitud(SolicitudArticulosView solicitud) throws BackEndException {

			return despachoSolicitudesFacade.unmarkSolicitud(solicitud);

	}

	public void enviarArticulos(ArrayList<SolicitudArticulosView> solicitudes) throws BackEndException {

			despachoSolicitudesFacade.enviarArticulos(solicitudes);

	}
	public void updateStock(ArticuloView view) throws BackEndException{
		systemFacade.actualizarStock(view, view.getStock());
	}
	
}
