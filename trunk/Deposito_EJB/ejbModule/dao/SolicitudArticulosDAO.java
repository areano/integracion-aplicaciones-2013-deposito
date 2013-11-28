package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.SolicitudArticulos;

/**
 * Session Bean implementation class SolicitudArticulosDAO
 */
@Stateless
@LocalBean
public class SolicitudArticulosDAO {

	@PersistenceContext
	EntityManager em;

	public SolicitudArticulosDAO() {
	}

	public void persist(SolicitudArticulos solicitud) {
		// TODO AR - Persistir entidad, manejo de errores

	}

	public SolicitudArticulos buscarSolicitud(long codigo) {
		// TODO AR: Buscar el acticulo dado
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudArticulos> getSolicitudes() {
		Query q = em.createQuery("from SolicitudArticulos");
		return (List<SolicitudArticulos>) q.getResultList();
	}

	public SolicitudArticulos find(long codigoSolicitud) {
		return em.find(SolicitudArticulos.class, codigoSolicitud);
	}
}
