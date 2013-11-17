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
public class FabricaFacadeBean implements FabricaFacade {

	@EJB
	private AdministradorSolicitudCompra adminSolicitudCompra;

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
