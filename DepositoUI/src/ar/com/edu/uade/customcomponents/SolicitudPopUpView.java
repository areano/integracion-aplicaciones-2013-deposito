package ar.com.edu.uade.customcomponents;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class SolicitudPopUpView  extends CustomComponent {
	private VerticalLayout mainLayout = new VerticalLayout();
	public SolicitudPopUpView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}
	private VerticalLayout buildMainLayout() {
		
		
		return mainLayout;
		
	}
}
