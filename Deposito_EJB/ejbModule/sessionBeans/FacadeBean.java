package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.AdministradorSolicitudArticulosBean;
import servicios.AdministradorSolicitudCompraBean;
import view.SolicitudCompraView;
import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;

/**
 * Session Bean implementation class FacadeBean
 */
@Stateless
@LocalBean
public class FacadeBean implements Facade {

	@EJB
	private AdministradorSolicitudArticulosBean admArticulos;

	@EJB
	private AdministradorSolicitudCompraBean admSolicitudCompra;

	/**
	 * Default constructor.
	 */
	public FacadeBean() {
	}

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) {
		admArticulos.recibirSolicitudArticulos(solicitud);
	}

	public void recibirSolicitudCompra(SolicitudCompraDTO compra) {
		admSolicitudCompra.recibir(compra);
	}

	@Override
	public void crearSolicitudCompra(SolicitudCompraView compra) {
		admSolicitudCompra.crear(compra);
	}
}
