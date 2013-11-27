package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import parsers.ArticuloParser;
import parsers.SolicitudArticulosParser;
import transformer.Transformer;
import clientes.GenericQueueClient;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import entities.DespachoConexion;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;
import entities.SolicitudArticulos;

/**
 * Session Bean implementation class DespachoDAO
 */
@Stateless
@LocalBean
public class DespachoDAO {

	@EJB
	Transformer t;
	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;
	private static final Logger logger = Logger.getLogger(DespachoDAO.class);
	private List<DespachoConexion> conexiones;
	private DespachoConexion conexion;

	public DespachoDAO() {
	}

	@SuppressWarnings("unchecked")
	private void obtenerConexiones() {
		Query q = em.createQuery("from DespachoConexion where active = TRUE");
		conexiones = (List<DespachoConexion>) q.getResultList();
	}

	private DespachoConexion obtenerConexion(final long despachoId) {
		Query q = em.createQuery("from DespachoConexion where id =:despachoId and active = TRUE");
		q.setParameter("despachoId", despachoId);
		conexion = (DespachoConexion) q.getSingleResult();
		return conexion;
	}

	public void enviar(Mueble m) {
		ArticuloParser parser = new ArticuloParser();
		MuebleDTO mDTO = t.toDTO(m);
		String xml = parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar(Infantil i) {
		ArticuloParser parser = new ArticuloParser();
		InfantilDTO mDTO = t.toDTO(i);
		String xml = parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar(Electrodomestico e) {
		ArticuloParser parser = new ArticuloParser();
		ElectrodomesticoDTO eDTO = t.toDTO(e);
		String xml = parser.toXML(eDTO);
		enviar(xml);
	}

	public void enviar(Moda m) {
		ArticuloParser parser = new ArticuloParser();
		ModaDTO mDTO = t.toDTO(m);
		String xml = parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar(String xml) {
		String errorMessage = new String();
		this.obtenerConexiones();

		for (DespachoConexion p : conexiones) {
			GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(), p.getUsuario(), p.getPassword());
			try {
				cliente.enviar(xml);
				cliente.cerrarConexion();
			} catch (JMSException e) {
				errorMessage = "*** Error enviando xml a jms de Despacho IP[" + p.getIp() + "] Grupo [" + p.getDespachoId() + "]***";
				logger.error(errorMessage, e);
				e.printStackTrace();
			}
		}
	}

	public void enviar(SolicitudArticulos a) {
		String errorMessage = new String();
		DespachoConexion p = obtenerConexion(a.getModuloId());
		SolicitudArticulosParser parser = new SolicitudArticulosParser();
		String xml = parser.toXML(a);
		GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(),p.getUsuario(), p.getPassword());
		try {
			cliente.enviar(xml);
			cliente.cerrarConexion();
		} catch (JMSException e) {
			errorMessage = "*** Error enviando xml a jms de Despacho IP[" + p.getIp() + "] Grupo [" + p.getDespachoId() + "]***";
			logger.error(errorMessage, e);
			e.printStackTrace();
		}
	}

}
