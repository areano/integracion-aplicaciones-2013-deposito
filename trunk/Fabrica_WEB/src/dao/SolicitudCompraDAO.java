package dao;

import javax.ejb.Local;

import entities.SolicitudCompra;

@Local
public interface SolicitudCompraDAO {

	void persist(SolicitudCompra entity);

}
