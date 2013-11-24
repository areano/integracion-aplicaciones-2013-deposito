package servicios;

import java.util.List;

import javax.ejb.Local;

import view.SolicitudCompraView;
import dto.SolicitudCompraDTO;
import entities.SolicitudCompra;

@Local
public interface AdministradorSolicitudCompra {

	public void crear(SolicitudCompraView compraView);

	public void recibir(SolicitudCompraDTO compra);
	
	public SolicitudCompra getRecomendacionCompra();
}
