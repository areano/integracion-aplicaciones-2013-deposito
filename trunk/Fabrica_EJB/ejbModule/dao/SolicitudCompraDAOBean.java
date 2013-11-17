package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.SolicitudCompra;

/**
 * Session Bean implementation class SolicitudCompraDAOBean
 */
@Stateless
@LocalBean
public class SolicitudCompraDAOBean implements SolicitudCompraDAO {

	/**
	 * Default constructor.
	 */
	public SolicitudCompraDAOBean() {
	}

	@Override
	public void persist(SolicitudCompra entity) {
		// TODO Auto-generated method stub

	}

}
