package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import entities.Articulo;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;
import excepctions.BackEndException;
import excepctions.ErrorDeJPAException;

@Stateless
@LocalBean
public class ArticuloDAO {
	
	@PersistenceContext
	EntityManager em;
	private static final Logger logger = 
			   Logger.getLogger(ArticuloDAO.class);

	public ArticuloDAO() {
	}
	
	public Articulo find(Long cod) throws BackEndException{
		Articulo a=null;
		try{
			
			a= em.find(Articulo.class, cod);
			logger.info("Find articulo persistido con código: ["+cod+"] ");
		}catch(Exception e)
		{
			logger.error("Error buscando Articulo codigo ["+cod+"]");
			logger.error(e);
			throw new BackEndException(e);
		}
		return a;
	}
	public List<Articulo> findAll() throws BackEndException{
		List<Articulo> al = new ArrayList<Articulo>();
		try{
			TypedQuery<Articulo> q = em.createQuery("from Articulo", Articulo.class);
			al = q.getResultList();
			logger.info("Get All Articulos ");
		}catch(Exception e)
		{
			logger.error("Error on Get All Articulos");
			logger.error(e);
			throw new BackEndException(e);
		}
		return al;
	}
	public void guardarArticulo(Articulo a) throws ErrorDeJPAException{
		try{
			System.out.println(a==null);
			System.out.println(em==null);
			em.persist(a);
			em.flush();
			logger.info("Articuo codigo ["+a.getCodigo()+"] persistido");
		}catch(Exception e)
		{
			throw(new ErrorDeJPAException("Error persistiendo Articulo codigo "+ a.getCodigo(),e));
		}
	}
	
	public void actualizarArticulo(Articulo a) throws BackEndException{
		try{
			
			em.merge(a);
			em.flush();
			logger.info("Articuo codigo ["+a.getCodigo()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Articulo codigo ["+a.getCodigo()+"]");
			logger.error(e);
			throw new BackEndException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<Articulo> findAllArticulos() throws BackEndException {
		
		try{
			Query q = em.createQuery("from Articulo ");
			
			logger.info("Get All Electrodomestico ");
			return (Collection<Articulo>) q.getResultList();
		}catch(Exception e)
		{
			logger.error("Error on Get All Electrodomestico");
			logger.error(e);
			throw new BackEndException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Electrodomestico> findAllElectrodomesticos() throws BackEndException {
		List<Electrodomestico> al = new ArrayList<Electrodomestico>();
		try{
			Query q = em.createQuery(" from Electrodomestico");
			al =(List<Electrodomestico> ) q.getResultList();
			logger.info("Get All Electrodomestico ");
		}catch(Exception e)
		{
			logger.error("Error on Get All Electrodomestico");
			logger.error(e);
			throw new BackEndException(e);
		}
		return al;
	}
	@SuppressWarnings("unchecked")
	public List<Moda> findAllByModa() throws BackEndException {
		List<Moda> al = new ArrayList<Moda>();
		try{
			Query q = em.createQuery("from Moda");
			al =(List<Moda> ) q.getResultList();
			logger.info("Get All Moda ");
		}catch(Exception e)
		{
			logger.error("Error on Get All Moda");
			logger.error(e);
			throw new BackEndException(e);
		}
		return al;
	}
	@SuppressWarnings("unchecked")
	public List<Infantil> findAllInfantil() throws BackEndException {
		List<Infantil> al = new ArrayList<Infantil>();
		try{
			Query q = em.createQuery("from Infantil");
			al =(List<Infantil> ) q.getResultList();
			logger.info("Get All Articulos ");
		}catch(Exception e)
		{
			logger.error("Error on Get All Infantil");
			logger.error(e);
			throw new BackEndException(e);
		}
		return al;
	}
	@SuppressWarnings("unchecked")
	public List<Mueble> findAllMuebles() throws BackEndException {
		List<Mueble> al = new ArrayList<Mueble>();
		try{
			Query q = em.createQuery("from Mueble");
			al =(List<Mueble> ) q.getResultList();
			logger.info("Get All Mueble ");
		}catch(Exception e)
		{
			logger.error("Error on Get All Mueble");
			logger.error(e);
			throw new BackEndException(e);
		}
		return al;
	}
}
