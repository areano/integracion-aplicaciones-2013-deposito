package servicios;

import java.util.ArrayList;

import excepctions.BackEndException;
import view.*;

public interface AdministradorConecctions {

	public void savePortalesConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public void saveDespachosConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public void saveFabricasConnection(ArrayList<ConnectionView> activas);
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public ArrayList<ConnectionView> getPortales() throws BackEndException;
	public ArrayList<ConnectionView> getDespachos() throws BackEndException;
	public ArrayList<ConnectionView> getMonitoreos() throws BackEndException;
	public ConnectionView getDespacho(int depachoID );

}
