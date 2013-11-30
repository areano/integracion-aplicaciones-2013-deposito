package ar.com.uade.fabricaejb.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.com.uade.fabricaejb.servicios.AdministradorSolicitudCompraBean;
import dto.SolicitudCompraDTO;
import facade.FabricaFacade;

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
