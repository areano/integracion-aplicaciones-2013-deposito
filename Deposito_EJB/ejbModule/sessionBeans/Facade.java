package sessionBeans;

import javax.ejb.Remote;

import view.SolicitudCompraView;
import dto.SolicitudCompraDTO;
import dto.SolicitudArticulosDTO;
import excepctions.BackEndException;

@Remote
public interface Facade {

	/**
	 * Recibe una solicitud de articulos
	 * @throws BackEndException 
	 */
	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud) throws BackEndException;

	/**
	 * Recibe una compra de articulos
	 * @throws BackEndException 
	 */
	public void recibirSolicitudCompra(SolicitudCompraDTO compra) throws BackEndException;

	/**
	 * Crea una nueva solicitud de compra y la envia a Fabrica
	 * @throws BackEndException 
	 */
	public void crearSolicitudCompra(SolicitudCompraView compra) throws BackEndException;
}
