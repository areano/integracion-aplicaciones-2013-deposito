package servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import parsers.ParserException;
import view.SolicitudArticulosView;
import dao.ArticuloDAO;
import dao.DespachoDAO;
import dao.SolicitudArticulosDAO;
import dto.SolicitudArticuloItemDTO;
import dto.SolicitudArticulosDTO;
import entities.Articulo;
import entities.SolicitudArticulos;
import entities.SolicitudArticulosItem;
import excepctions.BackEndException;

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
	private static final Logger logger = Logger.getLogger(AdministradorSolicitudArticulosBean.class);
	public AdministradorSolicitudArticulosBean() {
	}

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) throws ParserException, BackEndException {

		// TODO AR: Validar que los articulos existan en la base, de lo
		// contrario error? Tener en cuenta otro tipo de validaciones
		SolicitudArticulos sa = getEntity(solicitud);
		sa.setCumplida(false);
		solicitudArticulosDao.persist(sa);
	}

	private SolicitudArticulos getEntity(SolicitudArticulosDTO solicitud) throws ParserException, BackEndException {

		try {
			SolicitudArticulos solicitudEntity = new SolicitudArticulos();
			solicitudEntity.setModuloId(solicitud.getIdSolicitud());

			for (SolicitudArticuloItemDTO item : solicitud.getLista()) {

				SolicitudArticulosItem itemEntity = new SolicitudArticulosItem();
				itemEntity.setArticulo(articuloDao.find(Long.parseLong(item.getCodigo())));
				itemEntity.setCantidad(item.getCantidad());
				solicitudEntity.getItems().add(itemEntity);
			}

			return solicitudEntity;
		} catch (NumberFormatException e) {			
			logger.error("Error en el codigo de articulo, no vino un numero válido", e);
			throw (new ParserException("Error en el codigo de articulo, no vino un numero válido",e));
		}
	}

	// envia los articulos a despacho
	public void enviarArticulos(List<SolicitudArticulosView> solicitudes) throws BackEndException {
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
			logger.error("Error enviando Articulos a Despacho", e);
			throw new BackEndException (e);
		}
	}

	public List<SolicitudArticulos> getSolicitudesArticulos() throws BackEndException {
		return solicitudArticulosDao.getSolicitudes();
	}

}
