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
import transformer.Transformer;
import clientes.GenericQueueClient;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import entities.Articulo;
import entities.DespachoConexion;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;
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
	
	public void enviar (Mueble m){
		ArticuloParser parser = new ArticuloParser();
		MuebleDTO mDTO = Transformer.obtenerInstancia().toDTO(m);
		String xml=parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar (Infantil i){
		ArticuloParser parser = new ArticuloParser();
		InfantilDTO mDTO = Transformer.obtenerInstancia().toDTO(i);
		String xml=parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar (Moda m){
		ArticuloParser parser = new ArticuloParser();
		ModaDTO mDTO = Transformer.obtenerInstancia().toDTO(m);
		String xml=parser.toXML(mDTO);
		enviar(xml);
	}

	
	public void enviar(String xml) {
		this.obtenerConexiones();

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
