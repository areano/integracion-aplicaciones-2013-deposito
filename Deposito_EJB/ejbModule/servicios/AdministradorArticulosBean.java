package servicios;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import transformer.Transfomer;
import dao.ArticuloDAO;
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
	
	private Transfomer transformer;

	public AdministradorArticulosBean() {
		transformer=Transfomer.obtenerInstancia();
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
		Electrodomestico e = transformer.converToClass(dto);
		articuloDAO.guardarArticulo(e);
		portalDAO.enviar(e);
	}
	
	public void guardarInfantil(InfantilDTO dto){
		Infantil i = transformer.converToClass(dto);
		articuloDAO.guardarArticulo(i);
	}
	
	public void guardarModa(ModaDTO dto){
		Moda m = transformer.converToClass(dto);
		articuloDAO.guardarArticulo(m);
	}
	
	public void guardarMueble(MuebleDTO dto){
		Mueble m = transformer.converToClass(dto);
		articuloDAO.guardarArticulo(m);
	}

	@Override
	public void actualizarStock(ArticuloDTO dto, long stock) {
		Articulo a = transformer.converToClass(dto);
		a.setStock(stock);
		articuloDAO.actualizarArticulo(a);
	}
}
