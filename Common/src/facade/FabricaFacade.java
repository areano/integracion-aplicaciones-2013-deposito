package facade;

import javax.ejb.Remote;

import dto.SolicitudCompraDTO;

@Remote
public interface FabricaFacade {

	public void recibirSolicitudCompra(SolicitudCompraDTO compra);

	public void entregarCompra(SolicitudCompraDTO compra);

}
