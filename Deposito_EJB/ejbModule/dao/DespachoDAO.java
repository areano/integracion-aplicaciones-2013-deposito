package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import parsers.ArticuloParser;
import parsers.SolicitudArticulosParser;
import clientes.GenericQueueClient;
import entities.Articulo;
import entities.DespachoConexion;
import entities.PortalConexion;
import entities.SolicitudArticulos;

/**
 * Session Bean implementation class DespachoDAO
 */
@Stateless
@LocalBean
public class DespachoDAO {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;

	private List<DespachoConexion> conexiones;
	private DespachoConexion conexion;
    public DespachoDAO() {
        // TODO Auto-generated constructor stub
    }
	@SuppressWarnings("unchecked")
	private void obtenerConexiones() {
		Query q = em.createQuery("select from DespachoConexion where active = TRUE");
		conexiones = (List<DespachoConexion>) q.getResultList();
	}
	private DespachoConexion obtenerConexion(final long despachoId) {
		Query q = em.createQuery("select from DespachoConexion where id =:despachoId and active = TRUE");
		q.setParameter("despachoId", despachoId);
		conexion =  (DespachoConexion) q.getSingleResult();
		return conexion;
	}
	public void enviar(Articulo a) {
		this.obtenerConexiones();
		ArticuloParser parser = new ArticuloParser();
		String xml = parser.articuloToXML(a);

		for (DespachoConexion p : conexiones) {
			GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(), "user", "pass");
			try {
				cliente.enviar(xml);
				cliente.cerrarConexion();
			} catch (JMSException e) {
				// TODO AR: log de errores
				e.printStackTrace();
			}
		}
	}
	public void enviar(SolicitudArticulos a){
		DespachoConexion p =  obtenerConexion(a.getModuloId());	
		SolicitudArticulosParser  parser = new SolicitudArticulosParser();
		String xml = parser.toXML(a);
		GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(), "user", "pass"); 
		try {
			cliente.enviar(xml);
			cliente.cerrarConexion();
		} catch (JMSException e) {
			// TODO AR: log de errores
			e.printStackTrace();
		}
	}
	

}
