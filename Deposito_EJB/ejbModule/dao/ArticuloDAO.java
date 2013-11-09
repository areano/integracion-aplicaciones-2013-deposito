package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Articulo;

@Stateless
@LocalBean
public class ArticuloDAO {
	
	@PersistenceContext
	EntityManager em;

	private ArticuloDAO(){}
	
	public void guardarArticulo(Articulo a){
		em.persist(a);
	}
	
	public void actualizarArticulo(Articulo a){
		em.merge(a);
	}
}
