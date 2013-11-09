package servicios;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import transformer.Transfomer;
import dao.ArticuloDAO;
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
	ArticuloDAO dao;
	
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
		dao.guardarArticulo(e);
	}
	
	public void guardarInfantil(InfantilDTO dto){
		Infantil i = transformer.converToClass(dto);
		dao.guardarArticulo(i);
	}
	
	public void guardarModa(ModaDTO dto){
		Moda m = transformer.converToClass(dto);
		dao.guardarArticulo(m);
	}
	
	public void guardarMueble(MuebleDTO dto){
		Mueble m = transformer.converToClass(dto);
		dao.guardarArticulo(m);
	}
}
