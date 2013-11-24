package servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DepositoDAOBean;
import dao.SolicitudCompraDAOBean;
import dto.SolicitudCompraDTO;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class AdministradorSolicitudCompraBean
 */
@Stateless
public class AdministradorSolicitudCompraBean  {

	@EJB
	private SolicitudCompraDAOBean solicitudCompraDao;

	@EJB
	private DepositoDAOBean depositoDao;

	/**
	 * Default constructor.
	 */
	public AdministradorSolicitudCompraBean() {
	}


	public void recibirSolicitudCompra(SolicitudCompraDTO compra) {

		try {
			// TODO AR: Validar entity
			SolicitudCompra entity = getEntity(compra);

			solicitudCompraDao.persist(entity);
			entregarCompra(compra); //TODO : sacar el automático
		} catch (Exception e) {
			// TODO AR: log de errores y rollback de
			e.printStackTrace();
		}

	}


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
