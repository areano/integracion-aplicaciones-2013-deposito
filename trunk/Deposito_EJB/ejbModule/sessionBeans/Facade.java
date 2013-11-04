package sessionBeans;

import javax.ejb.Remote;

import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;

@Remote
public interface Facade {

	/**
	 * Recibe una solicitud de articulos
	 */
	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud);

	/**
	 * Recibe una compra de articulos
	 */
	public void recibirCompra(SolicitudCompraDTO compra);

}
