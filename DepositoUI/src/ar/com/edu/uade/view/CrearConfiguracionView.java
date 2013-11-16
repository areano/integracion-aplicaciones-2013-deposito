package ar.com.edu.uade.view;

import java.util.HashMap;

import ar.com.edu.uade.customcomponents.IPConfiguratorPanel;
import ar.com.edu.uade.customcomponents.IpConfigurator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class CrearConfiguracionView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8923865045603639957L;

	@Override
	public void enter(ViewChangeEvent event) {
		addStyleName("articulos");
		String planets[] = {"192.168.0.1", "192.168.0.2", "192.168.0.3", "192.168.0.4",
		        "192.168.0.5", "192.168.0.6", "192.168.0.7", "192.168.0.8"};
		HashMap<String, String> portales = new HashMap<String, String>();
		 for (int i=0; i<planets.length; i++)
	            portales.put(String.valueOf(i), planets[i]);
		 
		IPConfiguratorPanel ipConfigurator =  new IPConfiguratorPanel(portales, portales, portales, portales);
		addComponent(ipConfigurator);
		
		
	}


}
