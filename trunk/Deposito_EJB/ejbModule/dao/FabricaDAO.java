package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.SolicitudCompra;

/**
 * Session Bean implementation class FabricaDAO
 */
@Stateless
@LocalBean
public class FabricaDAO {

    /**
     * Default constructor. 
     */
    public FabricaDAO() {
        // TODO AR: levantar parametros de comunicacion REST y crear el cliente
    }

	public void enviar(SolicitudCompra compra) {
		// TODO AR: enviar solicitud mediante REST
		
	}

}
