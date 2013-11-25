package ar.com.edu.uade.view;

import java.util.Date;

import javax.naming.NamingException;

import view.SolicitudArticulosItemView;
import view.SolicitudCompraView;
import ar.com.edu.uade.ejbfacade.EJBFacade;
import ar.com.edu.uade.view.solicitudcompra.SolicitudCompraFormView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class CrearPedidoAFabricaView extends VerticalLayout implements View {
	EJBFacade facade;
	public CrearPedidoAFabricaView() {
		try {
			facade =  EJBFacade.getIntance();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Esto es un hardcode de aquellos, se supone que manda pedido a fabrica que haga falta cuando se entra a esa pantalla.
		
//		SolicitudCompraView solicitud =  facade.getRecomendacionCompra();
//		facade.crearSolicitudCompra(facade.getRecomendacionCompra());
//		
		SolicitudCompraFormView s = new SolicitudCompraFormView();
		s.init();
		addComponent(s);
	}


}
