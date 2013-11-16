package servicios;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.SolicitudArticulosDAO;
import dto.SolicitudArticuloItemDTO;
import dto.SolicitudArticulosDTO;
import entities.SolicitudArticulos;
import entities.SolicitudArticulosItem;

/**
 * Session Bean implementation class AdministradorSolicitudArticulosBean
 */
@Stateless
@LocalBean
public class AdministradorSolicitudArticulosBean implements AdministradorSolicitudArticulos {

	@EJB
	private SolicitudArticulosDAO dao;

	/**
	 * Default constructor.
	 */
	public AdministradorSolicitudArticulosBean() {
	}

	@Override
	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) {

		// TODO AR: Validar que los articulos existan en la base, de lo
		// contrario error? Tener en cuenta otro tipo de validaciones

		SolicitudArticulos sa = getEntity(solicitud);

		sa.setCumplida(false);
		dao.persist(sa);
	}

	private SolicitudArticulos getEntity(SolicitudArticulosDTO solicitud) {
		// TODO AR - crear entity desde dto

		SolicitudArticulos solicitudEntity = new SolicitudArticulos();
		solicitudEntity.setModuloId(solicitud.getIdSolicitud());

		for (SolicitudArticuloItemDTO item : solicitud.getLista()) {

			SolicitudArticulosItem itemEntity = new SolicitudArticulosItem();
			itemEntity.setArticulo(dao.buscarArticulo(item.getCodigo()));
			itemEntity.setCantidad(item.getCantidad());

			solicitudEntity.getItems().add(itemEntity);
		}

		return solicitudEntity;
	}

}
