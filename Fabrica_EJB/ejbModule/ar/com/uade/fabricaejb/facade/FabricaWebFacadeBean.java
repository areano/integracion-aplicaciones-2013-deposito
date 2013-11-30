package ar.com.uade.fabricaejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import facade.FabricaWebFacade;
import ar.com.uade.fabricaejb.entities.SolicitudCompra;
import ar.com.uade.fabricaejb.servicios.AdministradorSolicitudCompraBean;
import ar.com.uade.fabricaejb.transformer.ViewTransformer;
import view.SolicitudCompraView;
@Stateless
public class FabricaWebFacadeBean implements FabricaWebFacade {

	@EJB 
	AdministradorSolicitudCompraBean adm;
	
	@EJB
	ViewTransformer vt;
	
	@Override
	public List<SolicitudCompraView> getSolicitudesDeCompra() {
		List<SolicitudCompra> lista=adm.getSolicitudesDeCompra();
		
		List<SolicitudCompraView> listaView=vt.toView(lista);
		
		return listaView;
	}

	@Override
	public void entregarCompras(List<Long> lista) {
		for (Long codigoSolicitud : lista){
			adm.entregarCompra(codigoSolicitud);
		}
		//TODO tirar la excepcion para mostrar error en la pantalla si falla
	}

}
