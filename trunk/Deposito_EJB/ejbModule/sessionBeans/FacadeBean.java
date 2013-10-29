package sessionBeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.CompraDTO;
import dto.SolicitudDTO;

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

	public void recibirSolicitudArticulos(SolicitudDTO solicitud) {

	}

	public void recibirCompra(CompraDTO compra) {

	}

}
