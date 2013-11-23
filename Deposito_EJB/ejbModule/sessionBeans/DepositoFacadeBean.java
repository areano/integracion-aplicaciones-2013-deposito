package sessionBeans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;








import servicios.AdministradorArticulosBean;
import servicios.AdministradorConecctionsBean;
import view.*;
@Stateless
public class DepositoFacadeBean implements DepositoFacade {

	@EJB
	AdministradorArticulosBean admin ;
	@EJB
	AdministradorConecctionsBean connAdmin ;
	private static final Logger logger = 
			   Logger.getLogger(DepositoFacadeBean.class.getName());
	public DepositoFacadeBean(){}

	@Override
	public void altaElectrodomestico(ElectrodomesticoView dto) {
		logger.info("*** Alta Electrodomestico  ***" );
		admin.guardarElectrodomestico(dto);
	}

	@Override
	public void altaModa(ModaView m) {
		logger.info("*** Alta Articulo de moda  ***" );
		admin.guardarModa(m);
	}

	@Override
	public void altaMueble(MuebleView m) {
		logger.info("*** Alta Mueble ***" );
		admin.guardarMueble(m);
	}

	@Override
	public void altaInfatil(InfantilView i) {
		logger.info("*** Alta Infantil  ***" );
		admin.guardarInfantil(i);
	}

	@Override
	public void actualizarStock(ArticuloView dto, long stock) {
		logger.info("*** Actualizar Stock  ***" );
		admin.actualizarStock(dto, stock);
	}
	
	@Override
	public ArrayList<SolicitudCompraView> getSolicitudesCompra() {
		return admin.getSolicitudesCompra();
	}
	
//	@Override
//	public ArrayList<SolicitudArticulosView> getSolicitudesArticulos() {

//	}
	
	@Override
	public ArrayList<ArticuloView> getArticulos() {
		return admin.getArticulos();
	}
	
	@Override
	public ArrayList<ConnectionView> getFabricasConnection() {
		return null;
	}
	@Override
	public ArrayList<ConnectionView> getMonitoreosConnection() {
		return connAdmin.getMonitoreos();
	}
	
	@Override
	public ArrayList<ConnectionView> getDespachosConnection() {
		return connAdmin.getDespachos();
	}
	
	@Override
	public ConnectionView getDespachoConnection(int idModulo) {
		return connAdmin.getDespacho(idModulo);
	}
	@Override
	public ArrayList<ConnectionView> getPortalesConnection() {
		
		return connAdmin.getPortales();
	}
	@Override
	public void savePortalesConnection(ArrayList<ConnectionView> activas) {
		connAdmin.savePortalesConnection(activas);
		
	}

	@Override
	public void saveDespachosConnection(ArrayList<ConnectionView> activas) {
		connAdmin.saveDespachosConnection(activas);
		
	}
	
	@Override
	public void saveFabricasConnection(ArrayList<ConnectionView> activas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas) {
		connAdmin.saveMonitoreoConnection(activas);
		
	}
}
