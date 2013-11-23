package sessionBeans;

import java.util.ArrayList;

import javax.ejb.Remote;

import view.SolicitudArticulosView;

@Remote
public interface DespachoSolicitudesFacade {
	public ArrayList<SolicitudArticulosView> getSolicitudes();
	public ArrayList<SolicitudArticulosView> markSolicitud(SolicitudArticulosView s);
	public ArrayList<SolicitudArticulosView> unmarkSolicitud(SolicitudArticulosView s);
	
}
