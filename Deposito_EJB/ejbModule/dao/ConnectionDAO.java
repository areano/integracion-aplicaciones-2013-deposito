package dao;

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
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query q = em.createNativeQuery("Delete from DespachoConexion");
		q.executeUpdate();
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrarPortales(){
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query q = em.createNativeQuery("Delete from PortalConexion");
		q.executeUpdate();
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrarMonitoreos(){
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query q = em.createNativeQuery("Delete from MonitoreoConexion");
		q.executeUpdate();
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
