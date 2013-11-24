package servicios;

import java.util.List;

import javax.ejb.Local;

import dto.SolicitudCompraDTO;
import entities.SolicitudCompra;

@Local
public interface AdministradorSolicitudCompra {

	public void crear(SolicitudCompraDTO compra);

	public void recibir(SolicitudCompraDTO compra);
	
	public SolicitudCompra getRecomendacionCompra();
}
