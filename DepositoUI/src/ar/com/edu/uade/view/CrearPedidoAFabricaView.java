package ar.com.edu.uade.view;

import java.util.Date;

import javax.naming.NamingException;

import view.SolicitudArticulosItemView;
import view.SolicitudCompraView;
import ar.com.edu.uade.ejbfacade.EJBFacade;
import ar.com.edu.uade.view.solicitudcompra.SolicitudCompraFormView;
import ar.com.edu.uade.view.solicitudcompra.TestItemAsTable;
import ar.com.edu.uade.view.solicitudcompra.TestNestedBeanToTable;
import ar.com.edu.uade.view.solicitudcompra.WithCheckbox;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Layout;
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
		
		TestItemAsTable t;
		try {
			t = new TestItemAsTable();
			addComponent(t);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
