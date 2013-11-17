package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dto.SolicitudCompraDTO;

/**
 * Session Bean implementation class DepositoDAOBean
 */
@Stateless
@LocalBean
public class DepositoDAOBean implements DepositoDAO {

	public DepositoDAOBean() {
	}

	@Override
	public void entregarCompra(SolicitudCompraDTO compra) {
		// TODO AR: create xml y enviar a la cola de Deposito

	}

}
