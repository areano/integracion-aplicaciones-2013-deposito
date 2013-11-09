package servicios;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;

@Local
public interface AdministradorSolicitudCompra {

	void recibirSolicitudCompra(SolicitudCompraDTO compra);

}
