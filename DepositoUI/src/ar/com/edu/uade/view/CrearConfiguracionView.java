package ar.com.edu.uade.view;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NamingException;

import view.ConnectionView;
import ar.com.edu.uade.customcomponents.IPConfiguratorPanel;
import ar.com.edu.uade.ejbfacade.EJBFacade;

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
		Label caption = new Label("Configuracion de IP's <span>Seleccione para Activar</span>", ContentMode.HTML);
		caption.addStyleName(ChameleonTheme.LABEL_H1);
		addComponent(caption);
		
		try {
			HashMap<Integer, ConnectionView> portales = new HashMap<Integer, ConnectionView>();
			
			ArrayList<ConnectionView> connections =  EJBFacade.getIntance().getPortalConections();
			if (connections!=null){
				for (ConnectionView conn : connections) {
					portales.put(conn.getModuleId(), conn);
				}
			}
			HashMap<Integer, ConnectionView> despachos = new HashMap<Integer, ConnectionView>();
			connections =  EJBFacade.getIntance().getDespachoConnection();
			if (connections!=null){
				for (ConnectionView conn : connections) {
					despachos.put(conn.getModuleId(), conn);
				}
			}
			HashMap<Integer, ConnectionView> fabricas = new HashMap<Integer, ConnectionView>();
			connections =  EJBFacade.getIntance().getFabricaConnection();
			if (connections!=null){
				for (ConnectionView conn : connections) {
					fabricas.put(conn.getModuleId(), conn);
				}
			} 
			HashMap<Integer, ConnectionView> monitoreos = new HashMap<Integer, ConnectionView>();
			connections =  EJBFacade.getIntance().getMonitoreoConnection();
			if (connections!=null){
				for (ConnectionView conn : connections) {
					monitoreos.put(conn.getModuleId(), conn);
				}
			}
			
			IPConfiguratorPanel ipConfigurator =  new IPConfiguratorPanel(portales,despachos, monitoreos, fabricas);
			addComponent(ipConfigurator);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		
	}


}
