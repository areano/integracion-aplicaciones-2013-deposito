package facade;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;

@Local
public interface FabricaFacade {
	
	public void recibirSolicitudCompra(SolicitudCompraDTO compra);

}
