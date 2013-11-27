package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import view.SolicitudCompraView;

@Remote
public interface FabricaWebFacade {

	public List<SolicitudCompraView> getSolicitudesDeCompra();

	public void entregarCompras(List<Long> lista);

}