package servicios;

import java.util.ArrayList;

import view.*;

public interface AdministradorConecctions {

	public void savePortalesConnection(ArrayList<ConnectionView> activas);
	public void saveDespachosConnection(ArrayList<ConnectionView> activas);
	public void saveFabricasConnection(ArrayList<ConnectionView> activas);
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas);
	public ArrayList<ConnectionView> getPortales();
	public ArrayList<ConnectionView> getDespachos();
	public ArrayList<ConnectionView> getMonitoreos();
	public ConnectionView getDespacho(int depachoID );

}
