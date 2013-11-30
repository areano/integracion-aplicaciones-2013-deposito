package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import clientes.GenericQueueClient;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import parsers.ArticuloParser;
import transformer.Transformer;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;
import entities.PortalConexion;
import excepctions.BackEndException;

/**
 * Session Bean implementation class PortalDAO
 */
@Stateless
@LocalBean
public class PortalDAO {
	@EJB
	Transformer t;
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	ConnectionDAO cDAO;

	private List<PortalConexion> conexiones;
	private static final Logger logger = Logger.getLogger(PortalDAO.class);

	public PortalDAO() {
		conexiones = new ArrayList<PortalConexion>();
	}

	private void obtenerConexiones() throws BackEndException {
		conexiones = cDAO.getPortales();
	}

	public void enviar(Mueble m) throws BackEndException {
		ArticuloParser parser = new ArticuloParser();
		MuebleDTO mDTO = t.toDTO(m);
		String xml = parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar(Infantil i) throws BackEndException {
		ArticuloParser parser = new ArticuloParser();
		InfantilDTO mDTO = t.toDTO(i);
		String xml = parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar(Electrodomestico e) throws BackEndException {
		ArticuloParser parser = new ArticuloParser();
		ElectrodomesticoDTO eDTO = t.toDTO(e);
		String xml = parser.toXML(eDTO);
		enviar(xml);
	}

	public void enviar(Moda m) throws BackEndException {
		ArticuloParser parser = new ArticuloParser();
		ModaDTO mDTO = t.toDTO(m);
		String xml = parser.toXML(mDTO);
		enviar(xml);
	}

	public void enviar(String xml) throws BackEndException {
		this.obtenerConexiones();
		String errorMessage = new String();
		for (PortalConexion p : conexiones) {
			try {
				GenericQueueClient cliente = new GenericQueueClient(p.getQueueName(), p.getIp(), p.getPuerto(), p.getUsuario(), p.getPassword());
				cliente.enviar(xml);
				cliente.cerrarConexion();
				logger.info("*** Enviado xml a jms de Portal IP[" + p.getIp() + "] Grupo [" + p.getPortalId() + "]***");
			} catch (JMSException e) {
				errorMessage = "*** Error enviando xml a jms de Portal IP[" + p.getIp() + "] Grupo [" + p.getPortalId() + "]***";
				logger.error(errorMessage, e);
//				throw new BackEndException(e);
			} catch (NamingException e) {
				errorMessage = "*** Error conectando a cola jms de Portal IP[" + p.getIp() + "] Grupo [" + p.getPortalId() + "]***";
				logger.error(errorMessage, e);
//				throw new BackEndException(e);
			}
		}
	}
}
