package ar.com.edu.uade.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.naming.NamingException;

import org.vaadin.hene.flexibleoptiongroup.FlexibleOptionGroup;

import ar.com.edu.uade.ejbfacade.EJBFacade;
import view.*;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Runo;



public class EnviarPedidosADespachoView extends VerticalLayout implements View {
	
	public class MyButton implements Button.ClickListener{
		Table items;
		public MyButton(Table items){
			this.items = items;
		}
		@Override
		public void buttonClick(ClickEvent event) {
			DetailedRequest window =  new DetailedRequest(items);
			window.setStyleName(Runo.WINDOW_DIALOG);
			UI.getCurrent().addWindow(window);
			
		}
		
	}
	public class ConfirmSend implements Button.ClickListener{
		private ArrayList<OptionGroup> checks;
		public ConfirmSend(ArrayList<OptionGroup> checks){
			this.checks = checks;
		}
		@Override
		public void buttonClick(ClickEvent event) {
			Set selection;
			for (OptionGroup option : checks) {
				selection = (Set)option.getValue();
				for (Object object : selection) {
					System.out.println(((Long)object).toString());
				}
				
			}
			
		}
		
	}
	public class DetailedRequest extends Window {
		private static final long serialVersionUID = -1867392910754863989L;
		public DetailedRequest(Table items) {
			super("Pedido"); // Set window caption
	        center();
        
	        // Some basic content for the window
	        VerticalLayout content = new VerticalLayout();

	        content.setMargin(true);
	        setContent(content);
	        setClosable(true);
	        setResizable(false);
	        setDraggable(true);
	        setModal(true);
	        setStyleName(Runo.WINDOW_DIALOG);
	        content.addComponent(items);
	        
	        // Trivial logic for closing the sub-window
	        Button ok = new Button("OK",new Button.ClickListener() {
				private static final long serialVersionUID = 3216294094902350962L;
				public void buttonClick(ClickEvent event) {
	                close(); // Close the sub-window
	                
	            }
	        });
	        content.addComponent(ok);
	    }
	}
	
	
	private static final long serialVersionUID = 4883440977426352624L;
	private enum Articulos{ELECTRODOMESTICO, MODA, MUEBLE, INFANTIL}
	EJBFacade facade;
	public EnviarPedidosADespachoView(){
        try {
			facade = EJBFacade.getIntance();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	private FormLayout  convertFromDTO(ArticuloView articulo){
		FormLayout form = new FormLayout();
		PropertysetItem item = new PropertysetItem();
		FieldGroup binder =  new FieldGroup();
		item.addItemProperty("Codigo", new ObjectProperty<Long>(articulo.getCodigo()));
		TextField codigo = new TextField("Codigo");
		codigo.setEnabled(false);
		item.addItemProperty("Descripcion", new ObjectProperty<String>(articulo.getDescripcion()));
		TextField descripcion = new TextField("Descripcion");
		item.addItemProperty("Marca", new ObjectProperty<String>(articulo.getMarca()));
		TextField marca = new TextField("Marca");
		item.addItemProperty("Nombre", new ObjectProperty<String>(articulo.getNombre()));
		TextField nombre = new TextField("Nombre");
		item.addItemProperty("Precio", new ObjectProperty<Float>(articulo.getPrecio()));
		TextField precio = new TextField("Precio");
		item.addItemProperty("Origen", new ObjectProperty<String>(articulo.getOrigen()));
		TextField origen = new TextField("Origen");
		Articulos tipo =  Articulos.valueOf(articulo.getTipo().toUpperCase());	
		form.addComponent(codigo);
		form.addComponent(descripcion);
		form.addComponent(marca);
		form.addComponent(nombre);
		form.addComponent(precio);
		form.addComponent(origen);
		
		switch (tipo) {
			case ELECTRODOMESTICO:	
				item.addItemProperty("Ficha Tecnica", 
						new ObjectProperty<String>(articulo.getFichaTecnica()));
				TextField ficha = new TextField("Ficha Tecnica");
				binder.setItemDataSource(item);
				binder.bind(ficha, "Ficha Tecnica");
				form.addComponent(ficha);
				break;
			case MODA:
				item.addItemProperty("Talle", 
						new ObjectProperty<String>(articulo.getTalle()));
				item.addItemProperty("Color", 
						new ObjectProperty<String>(articulo.getColor()));
				TextField talle = new TextField("Talle");
				TextField color = new TextField("Color");
				binder.setItemDataSource(item);
				binder.bind(talle, "Talle");
				binder.bind(color, "Color");
				form.addComponent(talle);
				form.addComponent(color);
				break;
			case MUEBLE:
				item.addItemProperty("Material", 
						new ObjectProperty<String>(articulo.getMaterial()));
				TextField material = new TextField("Material");
				binder.setItemDataSource(item);
				binder.bind(material, "Material");
				form.addComponent(material);
				break;
			case INFANTIL:	
				item.addItemProperty("Edad recomendada", 
						new ObjectProperty<String>(articulo.getEdadRecomendada()));
				TextField edad = new TextField("Edad recomendada");
				binder.setItemDataSource(item);
				binder.bind(edad, "Edad recomendada");
				form.addComponent(edad);
				break;	
			default:
				break;
			}
		binder.bind(codigo,"Codigo");
		binder.bind(descripcion,"Descripcion");
		binder.bind(marca,"Marca");
		binder.bind(nombre,"Nombre");
		binder.bind(precio,"Precio");
		binder.bind(origen,"Origen");
		binder.setReadOnly(true);
		form.setReadOnly(true);		
		form.setStyleName(Runo.CSSLAYOUT_SHADOW);
		return form;
		
	}
	@Override
	public void enter(ViewChangeEvent event) {
		addStyleName("chameleon");
		//EJBFacade facade;
//		try {
			//facade = EJBFacade.getIntance();
		
			ArrayList<SolicitudArticulosView> solicitudes =  facade.getSolicitudesDeArticulos();
			OptionGroup selectSolitudes =  new OptionGroup("Solicitudes Pendientes");
			FormLayout form ;
			HashMap<Object, Long> mappedSolicitudes =  new HashMap<Object, Long>();
			Table items = new Table ("Pedido");
			FlexibleOptionGroup fop = new FlexibleOptionGroup();
			OptionGroup helper = new OptionGroup();
			PopupView popUpView;
			fop.setMultiSelect(true);
			//FlexibleOptionGroupItemComponent fopItem = new FlexibleOptionGroupItemComponent();
			ArrayList<OptionGroup> checks =  new ArrayList<OptionGroup>();
			VerticalLayout base = new VerticalLayout();
			
			
			items.setStyleName(Runo.TABLE_SMALL);
			items.addContainerProperty("articulo", PopupView.class, null);
			items.addContainerProperty("cantidad",  Integer.class, null);
			items.setColumnHeader("articulo", "Articulo");
			items.setColumnHeader("cantidad", "Cantidad");
			
			selectSolitudes.setMultiSelect(true);
		 	for (SolicitudArticulosView solicitudArticulosView : solicitudes) {
		 		items = new Table ("Pedido");
				items.setStyleName(Runo.TABLE_SMALL);
				items.addContainerProperty("articulo", PopupView.class, null);
				items.addContainerProperty("cantidad",  Integer.class, null);
				items.setColumnHeader("articulo", "Articulo");
				items.setColumnHeader("cantidad", "Cantidad");
				for (SolicitudArticulosItemView itemSolictud : solicitudArticulosView.getArticulos()) {
					//armar tabla popup
					form =  convertFromDTO(itemSolictud.getArticulo());				
					items.addItem(new Object[] {new PopupView(itemSolictud.getArticulo().getNombre(),form) , itemSolictud.getCantidad()}, null);
				}
				
	//			fop.addItem(selectSolitudes.addItem(new PopupView("Despacho: " + solicitudCompraDTO.getCodigoDespacho() +" fecha:  "+ solicitudCompraDTO.getDate(), 
	//					items)));
				popUpView = new PopupView("Despacho: " + solicitudArticulosView.getIdModulo() +" fecha:  "+ solicitudArticulosView.getDate(), 
						items);
				popUpView.addStyleName("chameleon");
	//			mappedSolicitudes.put(new PopupView("Despacho: " + solicitudCompraDTO.getCodigoDespacho() +" fecha:  "+ solicitudCompraDTO.getDate(), 
	//					items),solicitudCompraDTO.getCodigoSolicitud());
				helper = new OptionGroup();
				helper.setMultiSelect(true);
				helper.addItem(solicitudArticulosView.getCodigoSolicitud());
				helper.setCaption("");
				checks.add(helper);
				
				base.addComponent(new VerticalLayout(helper,popUpView));
				addComponent(base);
	
				
	//			addComponent(new PopupView("Despacho: " + solicitudCompraDTO.getCodigoDespacho() +" fecha:  "+ solicitudCompraDTO.getDate(), 
	//					items));
					
			}
			Button confirm =  new Button("Confirm");
			confirm.addClickListener(new ConfirmSend(checks));
			addComponent(confirm);
	//	 	//addComponent(selectSolitudes);
	//	 	for (Iterator<FlexibleOptionGroupItemComponent> iter = fop
	//                .getItemComponentIterator(); iter.hasNext();) {
	//        FlexibleOptionGroupItemComponent comp = iter.next();
	//        	addComponent(comp);
	//	 	}
		 	
		 	
	//	 	String caption;
	//		Table items2 = new Table ("Pedido");
	//		items2.addContainerProperty("Articulo", PopupView.class, null);
	//		items2.addContainerProperty("Cantidad",  Integer.class, null);
	//		items2.setStyleName(Runo.TABLE_SMALL);
	//	 	Table newItems;
	//	 	for (SolicitudCompraDTO solicitudCompraDTO : solicitudes) {
	//	 		
	//	 		
	//			for (ItemSolicitudCompra itemSolictud : solicitudCompraDTO.getItems()) {
	//				//armar tabla popup
	//				form =  convertFromDTO(itemSolictud.getArticulo());				
	//				items2.addItem(new Object[] {new PopupView(itemSolictud.getArticulo().getNombre(),form),itemSolictud.getCantidad()}, null);
	//			}
	//			
	//	 		caption =  "Despacho: " + solicitudCompraDTO.getCodigoDespacho() +" fecha:  "+ solicitudCompraDTO.getDate();	
	//	 		newItems =items2;
	//	 		addComponent(new Button(caption,new MyButton(newItems)));
	//	 	
	//	 	}
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
