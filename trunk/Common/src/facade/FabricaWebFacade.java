package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import excepctions.BackEndException;
import view.SolicitudCompraView;

@Remote
public interface FabricaWebFacade {

	public List<SolicitudCompraView> getSolicitudesDeCompra()  throws BackEndException;

	public void entregarCompras(List<Long> lista) throws BackEndException;

}