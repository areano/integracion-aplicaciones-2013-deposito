package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.SolicitudCompra;

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

}
