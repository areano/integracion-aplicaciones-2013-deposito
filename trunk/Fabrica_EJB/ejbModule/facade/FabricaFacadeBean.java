package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.AdministradorSolicitudCompraBean;
import dto.SolicitudCompraDTO;

/**
 * Session Bean implementation class DepositoFacadeBean
 */
@Stateless

public class FabricaFacadeBean implements FabricaFacade {

	@EJB
	private AdministradorSolicitudCompraBean adminSolicitudCompra;

	/**
	 * Default constructor.
	 */
	public FabricaFacadeBean() {
	}

	@Override
	public void recibirSolicitudCompra(SolicitudCompraDTO compra) {
		adminSolicitudCompra.recibirSolicitudCompra(compra);
	}

	@Override
	public void entregarCompra(SolicitudCompraDTO compra) {
		adminSolicitudCompra.entregarCompra(compra);
	}

}
