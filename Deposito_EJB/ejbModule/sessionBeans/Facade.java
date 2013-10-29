package sessionBeans;

import javax.ejb.Remote;

import dto.CompraDTO;
import dto.SolicitudDTO;

@Remote
public interface Facade {

	/**
	 * Recibe una solicitud de articulos
	 */
	public void recibirSolicitudArticulos(SolicitudDTO solicitud);

	/**
	 * Recibe una compra de articulos
	 */
	public void recibirCompra(CompraDTO compra);

}
