package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;

/**
 * Session Bean implementation class FacadeBean
 */
@Stateless
@LocalBean
public class FacadeBean implements Facade {

	/**
	 * Default constructor.
	 */
	public FacadeBean() {
		// TODO Auto-generated constructor stub
	}

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) {

	}

	public void recibirCompra(SolicitudCompraDTO compra) {

	}

}
