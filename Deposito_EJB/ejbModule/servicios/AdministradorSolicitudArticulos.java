package servicios;

import javax.ejb.Local;

import dto.SolicitudArticulosDTO;
import dto.SolicitudCompraDTO;

@Local
public interface AdministradorSolicitudArticulos {

	public void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud);
	
	public void enviarArticulos(SolicitudCompraDTO compraDTO); 

}
