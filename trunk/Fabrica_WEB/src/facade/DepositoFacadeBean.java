package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.AdministradorSolicitudCompra;
import dto.SolicitudCompraDTO;

/**
 * Session Bean implementation class DepositoFacadeBean
 */
@Stateless
@LocalBean
public class DepositoFacadeBean implements DepositoFacade {

	@EJB
	private AdministradorSolicitudCompra adminSolicitudCompra;

	/**
	 * Default constructor.
	 */
	public DepositoFacadeBean() {
	}

	@Override
	public void recibirSolicitudCompra(SolicitudCompraDTO compra) {
		adminSolicitudCompra.recibirSolicitudCompra(compra);
	}

}
