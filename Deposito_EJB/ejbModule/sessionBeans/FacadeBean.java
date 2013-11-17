package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.AdministradorSolicitudArticulos;
import servicios.AdministradorSolicitudCompra;
import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;

/**
 * Session Bean implementation class FacadeBean
 */
@Stateless
@LocalBean
public class FacadeBean implements Facade {

	@EJB
	private AdministradorSolicitudArticulos admArticulos;

	@EJB
	private AdministradorSolicitudCompra admSolicitudCompra;

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
	public void crearSolicitudCompra(SolicitudCompraDTO compra) {
		admSolicitudCompra.crear(compra);
	}

	@Override
	public void enviarArticulos(SolicitudCompraDTO compra) {
		admArticulos.enviarArticulos(compra);
	}

}
