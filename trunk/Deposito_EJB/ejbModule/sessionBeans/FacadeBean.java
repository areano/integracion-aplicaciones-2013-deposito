package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.AdministradorSolicitudArticulos;
import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;

/**
 * Session Bean implementation class FacadeBean
 */
@Stateless
@LocalBean
public class FacadeBean implements Facade {

	@EJB
	private AdministradorSolicitudArticulos adm;

	/**
	 * Default constructor.
	 */
	public FacadeBean() {
	}

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) {
		adm.recibirSolicitudArticulos(solicitud);
	}

	public void recibirCompra(SolicitudCompraDTO compra) {
		// TODO AR - recepcion de compras desde fabrica
	}

}
