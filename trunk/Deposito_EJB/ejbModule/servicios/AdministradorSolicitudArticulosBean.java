package servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import view.SolicitudArticulosView;
import dao.ArticuloDAO;
import dao.DespachoDAO;
import dao.SolicitudArticulosDAO;
import dto.SolicitudArticuloItemDTO;
import dto.SolicitudArticulosDTO;
import dto.SolicitudCompraDTO;
import entities.Articulo;
import entities.SolicitudArticulos;
import entities.SolicitudArticulosItem;

/**
 * Session Bean implementation class AdministradorSolicitudArticulosBean
 */
@Stateless
@LocalBean
public class AdministradorSolicitudArticulosBean {

	@EJB
	private SolicitudArticulosDAO solicitudArticulosDao;

	@EJB
	private ArticuloDAO articuloDao;

	@EJB
	private DespachoDAO despachoDao;

	public AdministradorSolicitudArticulosBean() {
	}

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) {

		// TODO AR: Validar que los articulos existan en la base, de lo
		// contrario error? Tener en cuenta otro tipo de validaciones

		SolicitudArticulos sa = getEntity(solicitud);

		sa.setCumplida(false);
		solicitudArticulosDao.persist(sa);
	}

	private SolicitudArticulos getEntity(SolicitudArticulosDTO solicitud) {

		SolicitudArticulos solicitudEntity = new SolicitudArticulos();
		solicitudEntity.setModuloId(solicitud.getIdSolicitud());

		for (SolicitudArticuloItemDTO item : solicitud.getLista()) {

			SolicitudArticulosItem itemEntity = new SolicitudArticulosItem();
			itemEntity.setArticulo(articuloDao.find(Long.parseLong(item.getCodigo())));
			itemEntity.setCantidad(item.getCantidad());
			solicitudEntity.getItems().add(itemEntity);
		}

		return solicitudEntity;
	}

	// envia los articulos a despacho
	public void enviarArticulos(List<SolicitudArticulosView> solicitudes) {
		try {

			for (SolicitudArticulosView view : solicitudes) {

				SolicitudArticulos solicitud = solicitudArticulosDao.find(view.getCodigoSolicitud());

				// por cada articulo descuento el stock de lo enviado
				for (SolicitudArticulosItem item : solicitud.getItems()) {

					Articulo articulo = item.getArticulo();

					articulo.setStock(articulo.getStock() - item.getCantidad());
				}

				solicitud.setCumplida(true);

				// TODO AR: Validar entity

				despachoDao.enviar(solicitud);

				// TODO AR: recepcion de respuesta?
			}

		} catch (Exception e) {
			// TODO AR: log de errores y rollback de todo
			e.printStackTrace();
		}
	}

	public List<SolicitudArticulos> getSolicitudesArticulos() {
		return solicitudArticulosDao.getSolicitudes();
	}

}
