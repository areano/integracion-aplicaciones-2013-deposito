package ar.com.edu.uade.view;


import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NamingException;






import view.ArticuloView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
import ar.com.edu.uade.ejbfacade.EJBFacade;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.Runo;

import excepctions.BackEndException;



public class EnviarPedidosADespachoView extends VerticalLayout implements View {
	private ArrayList<SolicitudArticulosView> solicitudes;
	
	private HashMap<SolicitudArticulosView, CheckBox> map = new HashMap<SolicitudArticulosView, CheckBox>();
	private static final long serialVersionUID = 4883440977426352624L;
	private EJBFacade facade;
//	private HashMap<Long, SolicitudArticulosView> solicitudesMap = new HashMap<Long, SolicitudArticulosView>();
	private enum Articulos{ELECTRODOMESTICO, MODA, MUEBLE, INFANTIL}

	
	private class CheckValueEventListener implements ValueChangeListener{

		private static final long serialVersionUID = -8730741657837733349L;
		SolicitudArticulosView solicitud;
		public CheckValueEventListener(SolicitudArticulosView s){
			solicitud = s;
		}
		@Override
		public void valueChange(ValueChangeEvent event) {
			solicitudValueChange(solicitud);
		}
	}	
	private class ConfirmSend implements Button.ClickListener{
		private static final long serialVersionUID = -115242109272197249L;
		private ArrayList<SolicitudArticulosView> solicitudesToSend = new ArrayList<SolicitudArticulosView>();

		@Override
		public void buttonClick(ClickEvent event) {
			for (SolicitudArticulosView s : map.keySet()) {
				if (map.get(s).getValue()) {
					solicitudesToSend.add(s);
					System.out.println(s.getCodigoSolicitud());
				}
			}
			try {
				facade.enviarArticulos(solicitudesToSend);
				UI.getCurrent().getNavigator().navigateTo("/creararticulo");
			} catch (BackEndException e) {
				// TODO Auto-generated catch block
				Notification.show("Erorr Enviando La solicitud A despacho", Type.ERROR_MESSAGE);
			}
		}
	}
	private class DetailedRequest extends Window {
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

	@Override
	public void enter(ViewChangeEvent event) {
		
			
			addStyleName("runo");
			try {
				solicitudes =  facade.getSolicitudesDeArticulos();
			} catch (BackEndException e) {
				Notification.show("Error Recuperando Las Solicitudes existentes", Type.ERROR_MESSAGE);
				return;
			}
			OptionGroup selectSolitudes =  new OptionGroup("Solicitudes Pendientes");
			FormLayout form ;

			Table items = new Table ("Pedido");


			CheckBox solicitudSelected = new CheckBox();
			PopupView popUpView;


			VerticalLayout base = new VerticalLayout();
			base.addStyleName(Reindeer.THEME_NAME);
			base.setStyleName(Reindeer.THEME_NAME);
			items.addStyleName(Runo.TABLE_SMALL);
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
				popUpView = new PopupView("Despacho: " + solicitudArticulosView.getIdModulo() +" fecha:  "+ solicitudArticulosView.getDate(), 
						items);
				popUpView.addStyleName(Reindeer.THEME_NAME);
				popUpView.setStyleName(Reindeer.THEME_NAME);
				solicitudSelected = new CheckBox("CB");
				solicitudSelected.addValueChangeListener(new CheckValueEventListener(solicitudArticulosView));
				
				if (!solicitudArticulosView.isSelectable()) {
					solicitudSelected.setEnabled(false);
				}

				map.put(solicitudArticulosView,solicitudSelected);
				base.addComponent(new VerticalLayout(solicitudSelected,popUpView));
				addComponent(base);
			}
			Button confirm =  new Button("Confirm");
			confirm.addClickListener(new ConfirmSend());
			addComponent(confirm);
	}

	private void solicitudValueChange(SolicitudArticulosView solicitud) {

		ArrayList<SolicitudArticulosView> toChange;

		try{
			if (map.get(solicitud).getValue())
				toChange = facade.markSolicitud(solicitud);
			else
				toChange = facade.unMarkSolicitud(solicitud);
			
			for (SolicitudArticulosView s : toChange) {
				CheckBox cb = map.get(s);
				cb.setEnabled(s.isSelectable());
			}
		}catch(BackEndException e){
			Notification.show("Error Durante la actualizacion de Solicitudes", Type.ERROR_MESSAGE);
		}
	}

	public  EnviarPedidosADespachoView(){
        try {
			facade = EJBFacade.getIntance();
		} catch (NamingException e) {
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

}

