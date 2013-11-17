package ar.com.edu.uade.view;


import ar.com.edu.uade.data.ArticuloContainer;
import ar.com.edu.uade.searcher.ArticuloForm;
import ar.com.edu.uade.searcher.ArticuloList;
import ar.com.edu.uade.searcher.ListView;
import ar.com.edu.uade.searcher.SearchFilter;
import ar.com.edu.uade.view.articulo.ElectrodomesticoFormView;
import ar.com.edu.uade.view.articulo.InfantilFormView;
import ar.com.edu.uade.view.articulo.ModaFormView;
import ar.com.edu.uade.view.articulo.MuebleFormView;
import view.*;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ChameleonTheme;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class SearchArticuloView extends VerticalLayout implements View  {
	private class PerformSearhButton implements ClickListener{

		@Override
		public void buttonClick(ClickEvent event) {
			performSearch();
			
		}
		
	}
    private TextField tf;
    private NativeSelect fieldToSearch;
    private CheckBox saveSearch;
    private TextField searchCode;
    private ListView articuloView = null;
    private VerticalLayout test;
    private ArticuloContainer  container =  ArticuloContainer.init();
    ArticuloList articuloList ;
    ArticuloForm articuloForm;
    Window editWindow;
    private enum Articulos{ELECTRODOMESTICO, MODA, MUEBLE, INFANTIL}
    public SearchArticuloView() {
    	editWindow =  new Window();	
        setCaption("Search contacts");
        setSizeFull();

        /* Use a FormLayout as main layout for this Panel */
        FormLayout formLayout = new FormLayout();
        addComponent(formLayout);

        /* Create UI components */
        tf = new TextField("Search term");
        fieldToSearch = new NativeSelect("Field to search");
        saveSearch = new CheckBox("Save search");
        searchCode = new TextField("Search name");
        Button search = new Button("Search");
        test = new VerticalLayout();
        /* Initialize fieldToSearch */
        for (int i = 0; i < container.NATURAL_COL_ORDER.length; i++) {
            fieldToSearch.addItem(container.NATURAL_COL_ORDER[i]);
            fieldToSearch.setItemCaption(container.NATURAL_COL_ORDER[i],
            		container.COL_HEADERS_ENGLISH[i]);
        }

        fieldToSearch.setValue("nombre");
        fieldToSearch.setNullSelectionAllowed(false);        
        search.addClickListener(new PerformSearhButton());
        /* Add all the created components to the form */
        addComponent(tf);
        addComponent(fieldToSearch);
        addComponent(saveSearch);
        addComponent(searchCode);
        addComponent(search);
        addComponent(test);
    }

    private void performSearch() {
        String searchTerm = (String) tf.getValue();
        if (searchTerm == null || searchTerm.equals("")) {
            Notification.show("La busqueda no puede estar vacia",Notification.Type.WARNING_MESSAGE);
            return;
        }
        SearchFilter searchFilter = new SearchFilter(fieldToSearch.getValue(),
                searchTerm, (String) searchCode.getValue());
        search(searchFilter);
       

    }
    public void search(SearchFilter searchFilter) {
        // clear previous filters
        container.removeAllContainerFilters();
        // filter contacts with given filter
        container.addContainerFilter(searchFilter.getPropertyId(),
                searchFilter.getTerm(), true, false);
        test.removeAllComponents();
        articuloList = new ArticuloList(container);
        test.addComponent(articuloList);
        articuloList.setVisible(true);
        articuloList.setSelectable(true);
        articuloList.setImmediate(true);
        articuloList.addItemClickListener(new ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
				// TODO Auto-generated method stub
				if (!event.isDoubleClick())
					 return;
				ArticuloView selected =  (ArticuloView) articuloList.getValue();
				viewEditableForm(selected);
			}
		});

    }
    private void viewEditableForm(ArticuloView selected){
    	final VerticalLayout content = new VerticalLayout();
		Articulos item =  Articulos.valueOf(selected.getTipo().toUpperCase());		
		switch (item) {
			case ELECTRODOMESTICO:					
				content.removeAllComponents();
				content.addComponent( new ElectrodomesticoFormView((ElectrodomesticoView) selected));					
				break;
			case MODA:
				content.removeAllComponents();
				content.addComponent( new ModaFormView( (ModaView)selected ));
				break;
			case MUEBLE:
				content.removeAllComponents();
				content.addComponent( new MuebleFormView((MuebleView)selected));
				break;
			case INFANTIL:	
				content.removeAllComponents();
				content.addComponent( new InfantilFormView((InfantilView)selected));
				break;	
			default:
				break;
			}
		editWindow.setClosable(true);
		editWindow.setModal(true);
		editWindow.setResizable(false);
		editWindow.setDraggable(true);
        editWindow.setStyleName("chameleon");
        Button ok = new Button("Cerrar",new Button.ClickListener() {
			private static final long serialVersionUID = 3216294094902350962L;
			public void buttonClick(ClickEvent event) {
                editWindow.close(); // Close the sub-window
            }
        });
        content.addComponent(ok);
		editWindow.setContent(content);
		UI.getCurrent().addWindow(editWindow);
		
    }
    
    /*
     * View getters exist so we can lazily generate the views, resulting in
     * faster application startup time.
     */
    private ListView getListView() {
        articuloList = new ArticuloList(container);
        articuloList.setVisible(true);
        articuloForm = new ArticuloForm();
        articuloView = new ListView(articuloList, articuloForm);
        return articuloView;
    }

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}