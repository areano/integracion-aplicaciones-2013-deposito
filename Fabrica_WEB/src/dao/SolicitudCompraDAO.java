package dao;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;
import entities.SolicitudCompra;

@Local
public interface SolicitudCompraDAO {

	void persist(SolicitudCompra entity);

}
