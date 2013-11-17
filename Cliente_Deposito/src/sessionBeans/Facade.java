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
	public void recibirSolicitudCompra(SolicitudCompraDTO compra);

	/**
	 * Crea una nueva solicitud de compra y la envia
	 */
	public void crearSolicitudCompra(SolicitudCompraDTO compra);

	/**
	 * Envia los articulos de la solicitud compra
	 */
	public void enviarArticulos(SolicitudCompraDTO compra);

}
