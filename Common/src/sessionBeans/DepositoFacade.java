package sessionBeans;

import java.util.ArrayList;

import javax.ejb.Remote;

import excepctions.BackEndException;
import view.*;


@Remote
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoView dto) throws BackEndException;
	
	public void altaModa(ModaView dto) throws BackEndException;
	
	public void altaMueble(MuebleView dto) throws BackEndException;
	
	public void altaInfatil(InfantilView dto) throws BackEndException;
	
	public void actualizarStock(ArticuloView dto, long stock) throws BackEndException;
	public ArrayList<SolicitudCompraView> getSolicitudesCompra() throws BackEndException;
	// this method is now at the Stateful ejb facade
	//public ArrayList<SolicitudArticulosView> getSolicitudesArticulos();
	public ArrayList<ArticuloView>  getArticulos() throws BackEndException;
	public ArrayList<ConnectionView>  getFabricasConnection() throws BackEndException;
	public ArrayList<ConnectionView>  getMonitoreosConnection() throws BackEndException;
	public ArrayList<ConnectionView>  getDespachosConnection() throws BackEndException;
	public ConnectionView  getDespachoConnection(int idModulo) throws BackEndException;
	public ArrayList<ConnectionView>  getPortalesConnection() throws BackEndException;	
	public void savePortalesConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public void saveDespachosConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public void saveFabricasConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas) throws BackEndException;
	public void crearSolicitudCompra(SolicitudCompraView compra) throws BackEndException;
	public SolicitudCompraView getRecomendacionCompra() throws BackEndException;
}
