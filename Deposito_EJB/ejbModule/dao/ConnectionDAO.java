package dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

import entities.DespachoConexion;
import entities.MonitoreoConexion;
import entities.PortalConexion;
import excepctions.BackEndException;

/**
 * Session Bean implementation class Connection DAO
 */
@Stateless
@LocalBean
public class ConnectionDAO {

	@PersistenceContext
	EntityManager em;
	@Resource
	UserTransaction utx;

	private static final Logger logger = Logger.getLogger(ConnectionDAO.class);

	public ConnectionDAO() {
		
	}
	public void guardarPortal(PortalConexion p) throws BackEndException{
		try{
			
			em.persist(p);
			logger.info("Conexion ip ["+p.getIp()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Conexion codigo ["+p.getIp()+"]");
			logger.error(e);
			throw new BackEndException(e);
		}
	}
	public void guardarDespacho(DespachoConexion d) throws BackEndException{
		try{
			
			em.persist(d);
			logger.info("Conexion ip ["+d.getIp()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Conexion codigo ["+d.getIp()+"]");
			logger.error(e);
			throw new BackEndException(e);
		}
	}
	public void guardarMonitoreo(MonitoreoConexion d) throws BackEndException{
		try{
			
			em.persist(d);
			logger.info("Conexion ip ["+d.getIp()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Conexion codigo ["+d.getIp()+"]");
			logger.error(e);
			throw new BackEndException(e);
		}
	}
	public void borrarDespachos() throws BackEndException{

		try{
			em.createQuery("Delete from DespachoConexion").executeUpdate();
		}catch  (Exception e)
		{
			logger.error(e);
			throw new BackEndException(e);
		}
	}

	public void borrarPortales() throws BackEndException{
		try{
			em.createQuery("Delete from PortalConexion").executeUpdate();
		}catch  (Exception e)
		{
			logger.error(e);
			throw new BackEndException(e);
		}
		
	}
	public void borrarMonitoreos() throws BackEndException{
		try{
			em.createQuery("Delete from MonitoreoConexion").executeUpdate();
		}catch  (Exception e)
		{
			logger.error(e);
			throw new BackEndException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public List<PortalConexion> getPortales() throws BackEndException {
		try{
		Query q = em.createQuery("from PortalConexion where active = TRUE");
			return  (List<PortalConexion>) q.getResultList();	
	}catch  (Exception e)
			{
				logger.error(e);
				throw new BackEndException(e);
			}
	}
	@SuppressWarnings("unchecked")
	public List<DespachoConexion> getDespachos() throws BackEndException {
		
		try{
			Query q = em.createQuery("from DespachoConexion where active = TRUE");
		 	return  (List<DespachoConexion>) q.getResultList();	
		}
		catch  (Exception e)
		{
			logger.error(e);
			throw new BackEndException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public List<MonitoreoConexion> getMonitoreos() throws BackEndException {
		try{
			Query q = em.createQuery("from MonitoreoConexion where active = TRUE");
			return  (List<MonitoreoConexion>) q.getResultList();
		}catch  (Exception e)
		{
			logger.error(e);
			throw new BackEndException(e);
		}
	}
}
