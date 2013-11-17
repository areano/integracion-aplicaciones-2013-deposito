package ar.com.edu.uade.view;

import java.util.HashMap;

import javax.naming.NamingException;

import ar.com.edu.uade.customcomponents.IPConfiguratorPanel;
import ar.com.edu.uade.customcomponents.IpConfigurator;
import ar.com.edu.uade.ejbfacade.EJBFacade;
import view.ConnectionView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

public class CrearConfiguracionView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8923865045603639957L;

	@Override
	public void enter(ViewChangeEvent event) {
		addStyleName("reindeer");
		Label caption = new Label("Configuracion de IP's <span>Seleccione para Desactivar</span>", ContentMode.HTML);
		caption.addStyleName(ChameleonTheme.LABEL_H1);
		addComponent(caption);
		
		try {
			HashMap<Integer, ConnectionView> portales = new HashMap<Integer, ConnectionView>();
			for (ConnectionView conn : EJBFacade.getIntance().getDespachoConnection()) {
				portales.put(conn.getModuleId(), conn);
			}
			HashMap<Integer, ConnectionView> despachos = new HashMap<Integer, ConnectionView>();
			for (ConnectionView conn : EJBFacade.getIntance().getDespachoConnection()) {
				despachos.put(conn.getModuleId(), conn);
			} 
			HashMap<Integer, ConnectionView> fabricas = new HashMap<Integer, ConnectionView>();
			for (ConnectionView conn : EJBFacade.getIntance().getDespachoConnection()) {
				fabricas.put(conn.getModuleId(), conn);
			} 
			HashMap<Integer, ConnectionView> monitoreos = new HashMap<Integer, ConnectionView>();
			for (ConnectionView conn : EJBFacade.getIntance().getDespachoConnection()) {
				monitoreos.put(conn.getModuleId(), conn);
			} 
			IPConfiguratorPanel ipConfigurator =  new IPConfiguratorPanel(portales,despachos, monitoreos, fabricas);
			addComponent(ipConfigurator);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		
	}


}
