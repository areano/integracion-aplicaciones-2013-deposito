package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import entities.Articulo;

@Stateless
@LocalBean
public class ArticuloDAO {
	
	@PersistenceContext
	EntityManager em;
	private static final Logger logger = 
			   Logger.getLogger(ArticuloDAO.class);
	private ArticuloDAO(){}
	
	public void guardarArticulo(Articulo a){
		try{
			
			em.persist(a);
			logger.info("Articuo codigo ["+a.getCodigo()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Articulo codigo ["+a.getCodigo()+"]");
			logger.error(e);
		}
	}
	
	public void actualizarArticulo(Articulo a){
		try{
			
			em.merge(a);
			logger.info("Articuo codigo ["+a.getCodigo()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Articulo codigo ["+a.getCodigo()+"]");
			logger.error(e);
		}
	}
}
