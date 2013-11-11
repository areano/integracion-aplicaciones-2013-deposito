package servicios;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;

@Local
public interface AdministradorSolicitudCompra {

	void crear(SolicitudCompraDTO compra);

	void recibir(SolicitudCompraDTO compra);

	void enviarArticulos(SolicitudCompraDTO compra);

}
