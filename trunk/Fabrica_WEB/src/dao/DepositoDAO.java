package dao;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;

@Local
public interface DepositoDAO {

	void entregarCompra(SolicitudCompraDTO compra);

}
