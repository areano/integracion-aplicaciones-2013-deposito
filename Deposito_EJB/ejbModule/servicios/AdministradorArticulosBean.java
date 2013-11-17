package servicios;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import transformer.Transformer;
import dao.ArticuloDAO;
import dao.DespachoDAO;
import dao.PortalDAO;
import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
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
	
	private Transformer transformer;
	private static final Logger logger = 
			   Logger.getLogger(AdministradorArticulosBean.class);
	public AdministradorArticulosBean() {
		transformer=Transformer.obtenerInstancia();
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
	
	public void guardarElectrodomestico(ElectrodomesticoDTO dto){
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
	
	public void guardarInfantil(InfantilDTO dto){
		try{
			Infantil i = transformer.converToClass(dto);
			articuloDAO.guardarArticulo(i);
			portalDAO.enviar(i);
			despachoDAO.enviar(i);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}
	
	public void guardarModa(ModaDTO dto){
		try{
			Moda m = transformer.converToClass(dto);
			articuloDAO.guardarArticulo(m);
			portalDAO.enviar(m);
			despachoDAO.enviar(m);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}
	
	public void guardarMueble(MuebleDTO dto){
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
	public void actualizarStock(ArticuloDTO dto, long stock) {
		try{
			Articulo a = transformer.converToClass(dto);
			a.setStock(stock);
			articuloDAO.actualizarArticulo(a);
		}catch(Exception e ){
			 logger.error("Error",e);
		}
	}
}
