package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.apache.log4j.Logger;

import entities.SolicitudArticulos;
import excepctions.BackEndException;

/**
 * Session Bean implementation class SolicitudArticulosDAO
 */
@Stateless
@LocalBean
public class SolicitudArticulosDAO {

	@PersistenceContext
	EntityManager em;
	private static final Logger logger = Logger.getLogger(SolicitudArticulosDAO.class);
	public SolicitudArticulosDAO() {
	}

	public void persist(SolicitudArticulos solicitud) throws BackEndException {
		try{
				em.persist(solicitud);
				em.flush();
		} catch (Exception e) {
			logger.error("Error guardando Solicitud",e);
		}

	}

	public SolicitudArticulos buscarSolicitud(long codigo) throws BackEndException {
		try{
			return em.find(SolicitudArticulos.class, codigo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Buscando Solicitud",e);
			throw new BackEndException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<SolicitudArticulos> getSolicitudes() throws BackEndException {
		try {
			Query q = em.createQuery("from SolicitudArticulos");
			return (List<SolicitudArticulos>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Buscando Solicitudes de Despacho",e);
			throw new BackEndException(e);
		}	
	}

	public SolicitudArticulos find(long codigoSolicitud) throws BackEndException {
		try{
			return em.find(SolicitudArticulos.class, codigoSolicitud);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Buscando Solicitud",e);
			throw new BackEndException(e);
		}
	}
}
