package servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DepositoDAO;
import dao.SolicitudCompraDAO;
import dto.SolicitudCompraDTO;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class AdministradorSolicitudCompraBean
 */
@Stateless
public class AdministradorSolicitudCompraBean implements
		AdministradorSolicitudCompra {

	@EJB
	private SolicitudCompraDAO solicitudCompraDao;

	@EJB
	private DepositoDAO depositoDao;

	/**
	 * Default constructor.
	 */
	public AdministradorSolicitudCompraBean() {
	}

	@Override
	public void recibirSolicitudCompra(SolicitudCompraDTO compra) {

		try {
			// TODO AR: Validar entity
			SolicitudCompra entity = getEntity(compra);

			solicitudCompraDao.persist(entity);

		} catch (Exception e) {
			// TODO AR: log de errores y rollback de
			e.printStackTrace();
		}

	}

	@Override
	public void entregarCompra(SolicitudCompraDTO compra) {
		try {
			// TODO AR: Validar entity
			SolicitudCompra entity = getEntity(compra);

			// TODO AR: actualizar estado
			solicitudCompraDao.persist(entity);

			depositoDao.entregarCompra(compra);

		} catch (Exception e) {
			// TODO AR: log de errores y rollback de las operaciones
			e.printStackTrace();
		}
	}

	private SolicitudCompra getEntity(SolicitudCompraDTO compra) {
		// TODO AR: Obtener entity desde dto
		return null;
	}

}
