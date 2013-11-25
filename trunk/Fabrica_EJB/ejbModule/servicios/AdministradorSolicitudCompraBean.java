package servicios;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DepositoDAOBean;
import dao.SolicitudCompraDAOBean;
import dto.ItemSolicitudCompraDTO;
import dto.SolicitudCompraDTO;
import entities.ItemSolicitudCompra;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class AdministradorSolicitudCompraBean
 */
@Stateless
public class AdministradorSolicitudCompraBean {

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
			entregarCompra(compra); //TODO: sacar la respuesta automática de la fabrica cuando se implemente la UI.
		} catch (Exception e) {
			// TODO AR: log de errores y rollback de
			e.printStackTrace();
		}

	}

	public void entregarCompra(SolicitudCompraDTO compra) {
		try {
			// TODO AR: Validar entity
			SolicitudCompra entity = solicitudCompraDao.find(compra.getCodigo());

			entity.setEstado(SolicitudCompra.COMPLETA);
			
			depositoDao.entregarCompra(compra);

		} catch (Exception e) {
			// TODO AR: log de errores y rollback de las operaciones
			e.printStackTrace();
		}
	}

	private SolicitudCompra getEntity(SolicitudCompraDTO compra) {

		SolicitudCompra entity = new SolicitudCompra();

		entity.setCodigo(compra.getCodigo());

		for (ItemSolicitudCompraDTO item : compra.getArticulos()) {

			ItemSolicitudCompra itemEntity = new ItemSolicitudCompra();

			itemEntity.setCodArticulo(item.getCodArticulo());
			itemEntity.setCantidad(item.getCantidad());

			entity.getItemArticulos().add(itemEntity);

		}

		return entity;
	}
}
