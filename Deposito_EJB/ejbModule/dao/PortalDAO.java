package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jms.GenericQueueClient;
import parsers.ArticuloParser;
import entities.Articulo;
import entities.PortalConexion;

/**
 * Session Bean implementation class PortalDAO
 */
@Stateless
@LocalBean
public class PortalDAO {
	
	@PersistenceContext
	EntityManager em;
	
	private List<PortalConexion> conexiones;

    public PortalDAO() {
    	conexiones = new ArrayList<PortalConexion>();
    	this.obtenerConexiones();
    }
    
    @SuppressWarnings("unchecked")
	private void obtenerConexiones(){
    	Query q = em.createQuery("select from PortalConexion");
    	conexiones = (List<PortalConexion>)q.getResultList();
    }
    
    public void enviar(Articulo a){
    	this.obtenerConexiones();
    	ArticuloParser parser = new ArticuloParser();
    	String xml = parser.articuloToXML(a);
    	
    	for(PortalConexion p:conexiones){
    		GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto());
        	cliente.enviar(xml);
        	cliente.cerrarConexion();
    	}	
    }
}
