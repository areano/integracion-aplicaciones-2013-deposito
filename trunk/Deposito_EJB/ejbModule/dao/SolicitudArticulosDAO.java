package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.SolicitudArticulos;

/**
 * Session Bean implementation class SolicitudArticulosDAO
 */
@Stateless
@LocalBean
public class SolicitudArticulosDAO {

    /**
     * Default constructor. 
     */
    public SolicitudArticulosDAO() {
    }

	public void persist(SolicitudArticulos solicitud) {
		// TODO AR - Persistir entidad, manejo de errores
		
	}

	public SolicitudArticulos buscarSolicitud(long codigo) {
		// TODO AR: Buscar el acticulo dado
		return null;
	}

}
