package facade;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;

@Local
public interface DepositoFacade {
	
	public void recibirSolicitudCompra(SolicitudCompraDTO compra);

}
