package sessionBeans;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Remote;

import view.*;


@Remote
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoView dto);
	
	public void altaModa(ModaView dto);
	
	public void altaMueble(MuebleView dto);
	
	public void altaInfatil(InfantilView dto);
	
	public void actualizarStock(ArticuloView dto, long stock);
	public ArrayList<SolicitudCompraView> getSolicitudesCompra();
	public ArrayList<SolicitudArticulosView> getSolicitudesArticulos();
	public ArrayList<ArticuloView>  getArticulos();
	public ArrayList<ConnectionView>  getFabricasConnection();
	public ArrayList<ConnectionView>  getMonitoreosConnection();
	public ArrayList<ConnectionView>  getDespachosConnection();
	public ArrayList<ConnectionView>  getDespachoConnection(int idModulo);
	public ArrayList<ConnectionView>  getPortalesConnection();	
	public void savePortalesConnection(ArrayList<ConnectionView> activas);
	public void saveDespachosConnection(ArrayList<ConnectionView> activas);
	public void saveFabricasConnection(ArrayList<ConnectionView> activas);
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas);
	
}
