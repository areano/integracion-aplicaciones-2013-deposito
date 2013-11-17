package servicios;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;

@Local
public interface AdministradorSolicitudCompra {

	public void crear(SolicitudCompraDTO compra);

	public void recibir(SolicitudCompraDTO compra);
}
