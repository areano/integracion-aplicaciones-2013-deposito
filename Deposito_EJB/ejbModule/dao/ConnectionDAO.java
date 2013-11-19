package dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

import entities.DespachoConexion;
import entities.MonitoreoConexion;
import entities.PortalConexion;

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
	public void guardarPortal(PortalConexion p){
		try{
			
			em.persist(p);
			logger.info("Conexion ip ["+p.getIp()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Conexion codigo ["+p.getIp()+"]");
			logger.error(e);
		}
	}
	public void guardarDespacho(DespachoConexion d){
		try{
			
			em.persist(d);
			logger.info("Conexion ip ["+d.getIp()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Conexion codigo ["+d.getIp()+"]");
			logger.error(e);
		}
	}
	public void guardarMonitoreo(MonitoreoConexion d){
		try{
			
			em.persist(d);
			logger.info("Conexion ip ["+d.getIp()+"] persistido");
		}catch(Exception e)
		{
			logger.error("Error persistiendo Conexion codigo ["+d.getIp()+"]");
			logger.error(e);
		}
	}
	public void borrarDespachos(){

		Query q = em.createNativeQuery("Delete from DespachoConexion");
		q.executeUpdate();
		
	}

	public void borrarPortales(){
		Query q = em.createNativeQuery("Delete from PortalConexion");
		q.executeUpdate();
		
	}
	public void borrarMonitoreos(){
		Query q = em.createNativeQuery("Delete from MonitoreoConexion");
		q.executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<PortalConexion> getPortales() {
			Query q = em.createQuery("from PortalConexion where active = TRUE");
			return  (List<PortalConexion>) q.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<DespachoConexion> getDespachos() {
		Query q = em.createQuery("from DespachoConexion where active = TRUE");
		return  (List<DespachoConexion>) q.getResultList();	
	}
	@SuppressWarnings("unchecked")
	public List<MonitoreoConexion> getMonitoreos() {
		Query q = em.createQuery("from MonitoreoConexion where active = TRUE");
		return  (List<MonitoreoConexion>) q.getResultList();	
	}
}
