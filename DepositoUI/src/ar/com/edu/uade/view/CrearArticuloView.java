package ar.com.edu.uade.view;

import ar.com.edu.uade.view.articulo.ElectrodomesticoFormView;
import ar.com.edu.uade.view.articulo.InfantilFormView;
import ar.com.edu.uade.view.articulo.ModaFormView;
import ar.com.edu.uade.view.articulo.MuebleFormView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.themes.Reindeer;

public class CrearArticuloView extends VerticalLayout implements View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2933925708772076134L;
	private enum Articulos{ELECTRODOMESTICO, MODA, MUEBLE, INFANTIL}
	private CssLayout root = new CssLayout();
	private CssLayout menu = new CssLayout();
    private CssLayout content = new CssLayout();
	@Override
	public void enter(ViewChangeEvent event) {
//		addStyleName("articulos");
//		setSizeFull();
//        root.addStyleName("articulos");
//        content.addStyleName("articulos");
//        menu.addStyleName("articulos");
		addStyleName("chameleon");
		setSizeFull();
        root.addStyleName("chameleon");
        content.addStyleName("chameleon");
        menu.addStyleName("chameleon");
        
        
        //root.setSizeFull();        
        root.addComponent(menu);
        root.addComponent(content);
        MenuBar menuBar = new MenuBar();
        menuBar.setStyleName("reindeer");

        
        menu.addComponent(menuBar);
        addComponent(root);        
		MenuBar.Command mycommand = new MenuBar.Command() {
			@Override
		    public void menuSelected(MenuItem selectedItem) {
				Articulos item =  Articulos.valueOf(selectedItem.getText().toUpperCase());	
				switch (item) {
					case ELECTRODOMESTICO:	
						content.removeAllComponents();
						ElectrodomesticoFormView eForm =  new ElectrodomesticoFormView();
						eForm.init();
						content.addComponent( eForm);
						
						break;
					case MODA:
						content.removeAllComponents();
						ModaFormView mForm =  new ModaFormView();
						mForm.init();
						content.addComponent( mForm);
						break;
					case MUEBLE:
						content.removeAllComponents();
						MuebleFormView uForm = new MuebleFormView();
						uForm.init();
						content.addComponent( uForm);
						break;
					case INFANTIL:	
						content.removeAllComponents();
						InfantilFormView iForm = new InfantilFormView();
						iForm.init();
						content.addComponent( iForm);

						break;	
					default:
						break;
					}
		    }
		};
		MenuBar.Command buscarCommand = new MenuBar.Command() {
			@Override
		    public void menuSelected(MenuItem selectedItem) {
				content.removeAllComponents();
				content.addComponent( new SearchArticuloView());
		    }
		};
		// Put some items in the menu hierarchically
		MenuBar.MenuItem articuloMenu = menuBar.addItem("Crear Articulo", null, null);
		MenuBar.MenuItem bucarArticuloMenu = menuBar.addItem("Buscar Articulo", null, buscarCommand);
		articuloMenu.setStyleName("articulos");
		MenuBar.MenuItem electrodomesticoArticuloMenu = articuloMenu.addItem("Electrodomestico", null, mycommand);
		MenuBar.MenuItem modaArticuloMenu = articuloMenu.addItem("Moda", null, mycommand);
		MenuBar.MenuItem muebleArticuloMenu = articuloMenu.addItem("Mueble", null, mycommand); 
		MenuBar.MenuItem infantilArticuloMenu = articuloMenu.addItem("Infantil", null, mycommand); 
		
        
		
	}


}
