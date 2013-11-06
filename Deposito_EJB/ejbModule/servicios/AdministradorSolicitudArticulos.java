package servicios;

import javax.ejb.Local;

import dto.SolicitudArticulosDTO;

@Local
public interface AdministradorSolicitudArticulos {

	void recibirSolicitudArticulos(SolicitudArticulosDTO solicitud);

}
