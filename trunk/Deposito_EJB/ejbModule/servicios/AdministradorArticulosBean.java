package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import transformer.Transformer;
import transformer.ViewTransformer;
import view.ArticuloView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudArticulosView;
import view.SolicitudCompraView;
import dao.ArticuloDAO;
import dao.DespachoDAO;
import dao.PortalDAO;
import dto.*;
import entities.Articulo;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;

/**
 * Session Bean implementation class AdministradorArticulos
 */
@Stateless
@LocalBean
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	@EJB
	ArticuloDAO articuloDAO;
	
	@EJB
	PortalDAO portalDAO;
	
	@EJB
	DespachoDAO despachoDAO;
	
	@EJB
	private ViewTransformer transformer;
	
	private static final Logger logger = Logger.getLogger(AdministradorArticulosBean.class);

	public AdministradorArticulosBean() {
	}

	/*
	public void guardarArticulo(Articulo articulo) {
		em.persist(articulo);
	}

	public void actualizarArticulo(Articulo articulo) {
		em.merge(articulo);
	}

	public void eliminarArticulo(Articulo articulo) {
		em.remove(articulo);
	}
	*/

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

	@Override
	public void actualizarStock(ArticuloView dto, long stock) {
		try{
			Articulo a = transformer.converToClass(dto);
			a.setStock(stock);
			articuloDAO.actualizarArticulo(a);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}

	public ArrayList<SolicitudCompraView> getSolicitudesCompra() {
		
		return null;
	}

	public ArrayList<SolicitudArticulosView> getSolicitudesArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ArticuloView> getArticulos() {
		
		ArrayList<ArticuloView> retorno = new ArrayList<ArticuloView>(); 
		
		retorno.addAll(getModa());
		retorno.addAll(getElectroDomesticos());
		retorno.addAll(getInfantil());
		retorno.addAll(getMueble());
		return retorno;
	}
	public ArrayList<ElectrodomesticoView> getElectroDomesticos() {
		List<Electrodomestico> al = articuloDAO.findAllElectrodomesticos();
		ArrayList<ElectrodomesticoView> retorno = new ArrayList<ElectrodomesticoView>(); 
		for (Electrodomestico articulo : al) {
			retorno.add(transformer.toView(articulo));
		}
		return retorno;
	}
	public ArrayList<ModaView> getModa() {
		List<Moda> al =articuloDAO.findAllByModa();
		ArrayList<ModaView> retorno = new ArrayList<ModaView>(); 
		Moda articulo;
		for (int i = 0; i < al.size(); i++) {
			articulo = al.get(i); 
			retorno.add(transformer.toView(articulo));
		}
		return retorno;
	}
	public ArrayList<InfantilView> getInfantil() {
		List<Infantil> al = articuloDAO.findAllInfantil();
		ArrayList<InfantilView> retorno = new ArrayList<InfantilView>(); 
		for (Infantil articulo : al) {
			retorno.add(transformer.toView(articulo));
		}
		return retorno;
	}
	public ArrayList<MuebleView> getMueble() {
		List<Mueble> al = articuloDAO.findAllMuebles();
		ArrayList<MuebleView> retorno = new ArrayList<MuebleView>(); 
		for (Mueble articulo : al) {
			retorno.add(transformer.toView(articulo));
		}
		return retorno;
	}
	
	
	
}


