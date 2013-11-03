package servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Articulo;

/**
 * Session Bean implementation class AdministradorArticulos
 */
@Stateless
@LocalBean
public class AdministradorArticulosBean implements AdministradorArticulo{

	@PersistenceContext
	EntityManager em;
	
    public AdministradorArticulosBean() {}
    
    
    public void guardarArticulo(Articulo articulo){
    	em.persist(articulo);
    }
    
    public void actualizarArticulo(Articulo articulo){
    	em.merge(articulo);
    }
    
    public void eliminarArticulo(Articulo articulo){
    	em.remove(articulo);
    }

}
