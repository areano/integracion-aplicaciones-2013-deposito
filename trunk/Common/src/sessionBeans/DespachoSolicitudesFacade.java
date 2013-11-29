package sessionBeans;

import java.util.ArrayList;

import javax.ejb.Remote;

import excepctions.BackEndException;
import view.SolicitudArticulosView;

@Remote
public interface DespachoSolicitudesFacade {
	public ArrayList<SolicitudArticulosView> getSolicitudes() throws BackEndException;

	public ArrayList<SolicitudArticulosView> markSolicitud (SolicitudArticulosView s) throws BackEndException;
 
	public ArrayList<SolicitudArticulosView> unmarkSolicitud (SolicitudArticulosView s) throws BackEndException;

	public void enviarArticulos (ArrayList<SolicitudArticulosView> solicitudes) throws BackEndException;
}
