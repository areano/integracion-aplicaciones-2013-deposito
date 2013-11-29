package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import parsers.ParserException;
import servicios.AdministradorSolicitudArticulosBean;
import servicios.AdministradorSolicitudCompraBean;
import view.SolicitudCompraView;
import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;
import excepctions.BackEndException;

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

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) throws BackEndException {
			try {
				admArticulos.recibirSolicitudArticulos(solicitud);
			} catch (ParserException e) {
				throw new BackEndException(e);
			}
	}

	public void recibirSolicitudCompra(SolicitudCompraDTO compra) throws BackEndException {
		admSolicitudCompra.recibir(compra);
	}

	@Override
	public void crearSolicitudCompra(SolicitudCompraView compra) throws BackEndException {
		admSolicitudCompra.crear(compra);
	}
}
