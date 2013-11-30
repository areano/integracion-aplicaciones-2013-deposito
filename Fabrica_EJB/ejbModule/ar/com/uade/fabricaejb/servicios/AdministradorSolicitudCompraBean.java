package ar.com.uade.fabricaejb.servicios;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ar.com.uade.fabricaejb.dao.DepositoDAOBean;
import ar.com.uade.fabricaejb.dao.SolicitudCompraDAOBean;
import ar.com.uade.fabricaejb.entities.ItemSolicitudCompra;
import ar.com.uade.fabricaejb.entities.SolicitudCompra;
import ar.com.uade.fabricaejb.transformer.Transformer;
import view.SolicitudCompraView;
import dto.ItemSolicitudCompraDTO;
import dto.SolicitudCompraDTO;

/**
 * Session Bean implementation class AdministradorSolicitudCompraBean
 */
@LocalBean
@Stateless
public class AdministradorSolicitudCompraBean {

	@EJB
	private SolicitudCompraDAOBean solicitudCompraDao;

	@EJB
	private DepositoDAOBean depositoDao;

	@EJB
	private Transformer trans;

	@EJB
	SolicitudCompraDAOBean scDAO;

	/**
	 * Default constructor.
	 */
	public AdministradorSolicitudCompraBean() {
	}

	public void recibirSolicitudCompra(SolicitudCompraDTO compra) {

		try {
			// TODO AR: Validar entity
			SolicitudCompra entity = trans.getEntity(compra);

			solicitudCompraDao.persist(entity);
			// entregarCompra(compra); //TODO: sacar la respuesta automática de
			// la fabrica cuando se implemente la UI.
		} catch (Exception e) {
			// TODO AR: log de errores y rollback de
			e.printStackTrace();
		}

	}

	public void entregarCompra(SolicitudCompraDTO compra) {
		entregarCompra(compra.getCodigo());
	}

	public void entregarCompra(Long codigo) {

		try {
			// TODO AR: Validar entity
			SolicitudCompra entity = solicitudCompraDao.find(codigo);

			entity.setEstado(SolicitudCompra.COMPLETA);

			SolicitudCompraDTO dto = trans.toDTO(entity);
			depositoDao.entregarCompra(dto);

		} catch (Exception e) {
			// TODO AR: log de errores y rollback de las operaciones
			e.printStackTrace();
		}

	}

	public List<SolicitudCompra> getSolicitudesDeCompra() {
		return scDAO.findAll();

	}

}
