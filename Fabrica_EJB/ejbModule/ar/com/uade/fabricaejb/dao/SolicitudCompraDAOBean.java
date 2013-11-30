package ar.com.uade.fabricaejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ar.com.uade.fabricaejb.entities.SolicitudCompra;
import view.SolicitudCompraView;

/**
 * Session Bean implementation class SolicitudCompraDAOBean
 */
@Stateless
@LocalBean
public class SolicitudCompraDAOBean {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public SolicitudCompraDAOBean() {
	}

	public void persist(SolicitudCompra entity) {
		em.persist(entity);
		em.flush();
	}

	public SolicitudCompra find(long codigo) {
		return em.find(SolicitudCompra.class, codigo);
	}
	

	public List<SolicitudCompra> findAll() {
		List <SolicitudCompra> lista=null;
		TypedQuery<SolicitudCompra> q = em.createQuery("from SolicitudCompra", SolicitudCompra.class);
		lista = q.getResultList();
		return lista;
	}
	
	

}
