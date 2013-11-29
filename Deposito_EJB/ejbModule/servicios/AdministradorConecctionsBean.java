package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import transformer.ViewTransformer;
import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import dao.ArticuloDAO;
import dao.ConnectionDAO;
import dao.DespachoDAO;
import dao.PortalDAO;
import entities.Articulo;
import entities.DespachoConexion;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.MonitoreoConexion;
import entities.Mueble;
import entities.PortalConexion;
import excepctions.BackEndException;

/**
 * Session Bean implementation class AdministradorArticulos
 */
@Stateless
@LocalBean
public class AdministradorConecctionsBean implements AdministradorConecctions {
	
	@EJB
	ArticuloDAO articuloDAO;
	
	@EJB
	PortalDAO portalDAO;
	
	@EJB
	DespachoDAO despachoDAO;
	
	@EJB 
	ConnectionDAO connectionDAO;
	
	@EJB
	private ViewTransformer transformer;
	private static final Logger logger = 
			   Logger.getLogger(AdministradorConecctionsBean.class);
	
	public AdministradorConecctionsBean() {
	}

	public void guardarElectrodomestico(ElectrodomesticoView dto){
		try{
			
			Electrodomestico e = transformer.converToClass(dto);
			articuloDAO.guardarArticulo(e);
			logger.info("Electrodomestico codigo ["+e.getCodigo()+"] creado");
			portalDAO.enviar(e);
			despachoDAO.enviar(e);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}
	
	public void guardarInfantil(InfantilView dto){
		try{
			Infantil i = transformer.converToClass(dto);
			articuloDAO.guardarArticulo(i);
			portalDAO.enviar(i);
			despachoDAO.enviar(i);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}
	
	public void guardarModa(ModaView dto){
		try{
			Moda m = transformer.converToClass(dto);
			articuloDAO.guardarArticulo(m);
			portalDAO.enviar(m);
			despachoDAO.enviar(m);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}
	
	public void guardarMueble(MuebleView dto){
		try{
			Mueble m = transformer.converToClass(dto);
			articuloDAO.guardarArticulo(m);
			portalDAO.enviar(m);
			despachoDAO.enviar(m);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}


	public void actualizarStock(ArticuloView dto, long stock) {
		try{
			Articulo a = transformer.converToClass(dto);
			a.setStock(stock);
			articuloDAO.actualizarArticulo(a);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}

	@Override
	public void savePortalesConnection(ArrayList<ConnectionView> activas) throws BackEndException {
		connectionDAO.borrarPortales();
		for (ConnectionView connectionView : activas) {
			
			try{
				connectionDAO.guardarPortal(transformer.portalToClass(connectionView));
			}catch(Exception e){
				 logger.error("Error",e);
			}
		}
		
		
	}

	@Override
	public void saveDespachosConnection(ArrayList<ConnectionView> activas) throws BackEndException {
		connectionDAO.borrarDespachos();
		for (ConnectionView connectionView : activas) {
			
			try{
				connectionDAO.guardarDespacho(transformer.despachoToClass(connectionView));
			}catch(Exception e){
				 logger.error("Error",e);
			}
		}
		
	}

	@Override
	public void saveFabricasConnection(ArrayList<ConnectionView> activas) {
		for (ConnectionView connectionView : activas) {
			
		}
		
	}

	@Override
	public void saveMonitoreoConnection(ArrayList<ConnectionView> activas) throws BackEndException {
		connectionDAO.borrarMonitoreos();
		for (ConnectionView connectionView : activas) {
			
			try{
				connectionDAO.guardarMonitoreo(transformer.monitoreoToClass(connectionView));
			}catch(Exception e){
				 logger.error("Error",e);
			}
		}		
	}


	@Override
	public ArrayList<ConnectionView> getPortales() throws BackEndException {
		List<PortalConexion> pc = connectionDAO.getPortales();
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		for (PortalConexion c : pc) {
				retorno.add(transformer.toView(c));
				
		}
		return retorno;
	}


	@Override
	public ArrayList<ConnectionView> getDespachos() throws BackEndException {
		List<DespachoConexion> pc = connectionDAO.getDespachos();
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		for (DespachoConexion c : pc) {
				retorno.add(transformer.toView(c));
				
		}
		return retorno;
	}


	@Override
	public ArrayList<ConnectionView> getMonitoreos() throws BackEndException {
		
		List<MonitoreoConexion> pc = connectionDAO.getMonitoreos();
		ArrayList<ConnectionView> retorno = new ArrayList<ConnectionView>();
		for (MonitoreoConexion c : pc) {
				retorno.add(transformer.toView(c));
				
		}
		return retorno;
	}


	@Override
	public ConnectionView getDespacho(int depachoID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


