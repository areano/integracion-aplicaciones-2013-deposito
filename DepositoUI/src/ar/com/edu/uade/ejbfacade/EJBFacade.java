package ar.com.edu.uade.ejbfacade;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

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

	private static final Logger logger = Logger.getLogger(EJBFacade.class);

	static EJBFacade instance = null;

	static DepositoFacade systemFacade;
	static DespachoSolicitudesFacade despachoSolicitudesFacade;

	private EJBFacade() throws NamingException {
		getDepositoFacade();
		getDespachoFacade();
	}

	public static EJBFacade getIntance() throws NamingException {
		if (instance == null) {
			instance = new EJBFacade();
		}
		return instance;
	}

	public ArrayList<ConnectionView> getPortalConections() {
		try {
			return systemFacade.getPortalesConnection();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ConnectionView> getDespachoConnection() {
		try {
			return systemFacade.getDespachosConnection();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ConnectionView> getMonitoreoConnection() {
		try {
			return systemFacade.getMonitoreosConnection();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ConnectionView> getFabricaConnection() {
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		return retorno;
	}

	public ArrayList<SolicitudArticulosView> getSolicitudesDeArticulos() {
		try {
			return despachoSolicitudesFacade.getSolicitudes();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<SolicitudCompraView> getSolicitudesDeCompra() {
		return null;
	}

	public void crearSolicitudCompra(SolicitudCompraView compra) {
		try {
			systemFacade.crearSolicitudCompra(compra);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SolicitudCompraView getRecomendacionCompra() {
		try {
			return systemFacade.getRecomendacionCompra();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Collection<? extends ArticuloView> getAllArticulos() {
		try {
			return systemFacade.getArticulos();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void altaElectrodomestico(ElectrodomesticoView e) {
		try {
			systemFacade.altaElectrodomestico(e);
		} catch (BackEndException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void altaModa(ModaView m) {
		try {
			systemFacade.altaModa(m);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void altaMueble(MuebleView m) {
		try {
			systemFacade.altaMueble(m);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void altaInfatil(InfantilView i) {
		try {
			systemFacade.altaInfatil(i);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void savePortalesConnection(ArrayList<ConnectionView> activas) {
		try {
			systemFacade.savePortalesConnection(activas);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveMonitoreosConnection(ArrayList<ConnectionView> activas) {
		try {
			systemFacade.saveMonitoreoConnection(activas);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveDespachosConnection(ArrayList<ConnectionView> activas) {
		try {
			systemFacade.saveDespachosConnection(activas);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveFabricaConnection(ArrayList<ConnectionView> activas) {
		try {
			systemFacade.savePortalesConnection(activas);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getDepositoFacade() throws NamingException {
		try {
			InitialContext ic = new InitialContext();
			systemFacade = (DepositoFacade) ic.lookup("java:global/Depostio_EAR/Deposito_EJB/DepositoFacadeBean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getDespachoFacade() throws NamingException {
		try {
			InitialContext ic = new InitialContext();
			despachoSolicitudesFacade = (DespachoSolicitudesFacade) ic.lookup("java:global/Depostio_EAR/Deposito_EJB/DespachoSolicitudesFacadebean");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<SolicitudArticulosView> markSolicitud(SolicitudArticulosView solicitud) {
		try {
			return despachoSolicitudesFacade.markSolicitud(solicitud);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<SolicitudArticulosView> unMarkSolicitud(SolicitudArticulosView solicitud) {
		try {
			return despachoSolicitudesFacade.unmarkSolicitud(solicitud);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void enviarArticulos(ArrayList<SolicitudArticulosView> solicitudes) {
		try {
			despachoSolicitudesFacade.enviarArticulos(solicitudes);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
