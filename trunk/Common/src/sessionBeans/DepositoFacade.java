package sessionBeans;

import java.util.ArrayList;

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
	// this method is now at the Stateful ejb facade
	//public ArrayList<SolicitudArticulosView> getSolicitudesArticulos();
	public ArrayList<ArticuloView>  getArticulos();
	public ArrayList<ConnectionView>  getFabricasConnection();
	public ArrayList<ConnectionView>  getMonitoreosConnection();
	public ArrayList<ConnectionView>  getDespachosConnection();
	public ConnectionView  getDespachoConnection(int idModulo);
	public ArrayList<ConnectionView>  getPortalesConnection();	
	public void savePortalesConnection(ArrayList<ConnectionView> activas);
	public void saveDespachosConnection(ArrayList<ConnectionView> activas);
	public void saveFabricasConnection(ArrayList<ConnectionView> activas);
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas);
	public void crearSolicitudCompra(SolicitudCompraView compra);
	public SolicitudCompraView getRecomendacionCompra();
}
