//package ar.com.edu.uade.depositoui;
//package ar.com.edu.uade.depositoui;
//
//import javax.servlet.annotation.WebServlet;
//
//import com.vaadin.annotations.Theme;
//import com.vaadin.annotations.VaadinServletConfiguration;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.server.VaadinServlet;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.Button.ClickEvent;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.MenuBar;
//import com.vaadin.ui.MenuBar.MenuItem;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
//
//@SuppressWarnings("serial")
//@Theme("depositoui")
//public class DepositouiUI extends UI {
//
//	@WebServlet(value = "/*", asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = DepositouiUI.class)
//	public static class QuickTicketsDashboard extends VaadinServlet {
//	}	
//
//	@Override
//	protected void init(VaadinRequest request) {
//		final VerticalLayout layout = new VerticalLayout();
//		layout.setMargin(true);
//		setContent(layout);
//		MenuBar barmenu = new MenuBar();
//		layout.addComponent(barmenu);
//		        
//		// A feedback component
//		final Label selection = new Label("-");
//		layout.addComponent(selection);
//
//		// Define a common menu command for all the menu items.
//		MenuBar.Command mycommand = new MenuBar.Command() {
//			@Override
//		    public void menuSelected(MenuItem selectedItem) {
//		        selection.setValue("Ordered a " +
//		                selectedItem.getText() +
//		                " from menu.");
//		    }
//		};
//		
//		// Put some items in the menu hierarchically
//		MenuBar.MenuItem articuloMenu =
//		    barmenu.addItem("Articulos", null, null);
//		MenuBar.MenuItem crearArticuloMenu =
//		    articuloMenu.addItem("Crear", null, mycommand);
//
//		MenuBar.MenuItem buscarArticulomenu =
//		    articuloMenu.addItem("Buscar", null, mycommand);
//
//		        
//		// Another top-level item
//		MenuBar.MenuItem configuracion =
//		    barmenu.addItem("Snacks", null, null);
//		configuracion.addItem("Portales", null, mycommand);
//		configuracion.addItem("Despachos", null, mycommand);
//		configuracion.addItem("Monitoreo&Contro", null, mycommand);
//		        
//		// Yet another top-level item
//		MenuBar.MenuItem ordenes =
//		    barmenu.addItem("Solicitudes de Despacho", null, null);
//		ordenes.addItem("Ver", null, mycommand); 
//		
//		// Yet another top-level item
//		MenuBar.MenuItem Fabrica =
//		    barmenu.addItem("Pedido de Compra a Fabrica", null, null);
//		ordenes.addItem("Generar", null, mycommand); 		
//		
//	}
//
//}