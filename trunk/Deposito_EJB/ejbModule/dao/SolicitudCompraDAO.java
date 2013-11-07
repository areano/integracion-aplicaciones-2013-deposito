package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.SolicitudCompra;

/**
 * Session Bean implementation class SolicitudCompraDAO
 */
@Stateless
@LocalBean
public class SolicitudCompraDAO {

	/**
	 * Default constructor.
	 */
	public SolicitudCompraDAO() {
	}

	public void persist(SolicitudCompra compra) {
		// TODO AR: Persistir compra
	}

	public void merge(SolicitudCompra compra) {
		// TODO AR: Merge con la solicitud de compra persistida
	}

}
