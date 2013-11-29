package ar.com.edu.uade.view.solicitudcompra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.naming.NamingException;

import org.apache.tools.ant.taskdefs.Sleep;

import view.SolicitudArticulosItemView;
import view.SolicitudCompraView;
import ar.com.edu.uade.ejbfacade.EJBFacade;

import com.vaadin.data.Container;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Table;
import com.vaadin.ui.TableFieldFactory;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class TestItemAsTable extends CustomComponent{

	private static final long serialVersionUID = 3419245432580903151L;
	SolicitudCompraView solicitud ;
	VerticalLayout layout;
	private ArrayList<SolicitudArticulosItemView> items = new ArrayList<SolicitudArticulosItemView>();
	final EJBFacade facade;
	public TestItemAsTable() throws NamingException{
		facade = EJBFacade.getIntance();
		solicitud =facade.getRecomendacionCompra();
		items = solicitud.getItems();
		layout = new VerticalLayout();
		buildLayout();
	}
	private void buildLayout(){
		final BeanItemContainer<SolicitudArticulosItemView> itemContainer;
		itemContainer = new BeanItemContainer<SolicitudArticulosItemView>(SolicitudArticulosItemView.class);
		 /* This set contains the ids of the "selected" items */
		final Set<Object> selectedItemIds = new HashSet<Object>();
	  	itemContainer.addNestedContainerProperty("articulo.nombre");
		itemContainer.addNestedContainerProperty("articulo.stock");
		itemContainer.addAll(items);
	    selectedItemIds.addAll(itemContainer.getItemIds()); // We'll start off with #4 selected, just to show that it works
		setCompositionRoot(layout);
		final Table table = new Table("Pedido", itemContainer);
	    /* This checkbox reflects the contents of the selectedItemIds set */ 
		table.setTableFieldFactory(new TableFieldFactory () {
			    public Field createField(Container container, Object itemId,
			            Object propertyId, Component uiContext) {
			        TextField field = new TextField((String) propertyId);
			        
			        // If you want to disable edition on a column, use ReadOnly
			        if (!("txtCantidad".equals(propertyId)))
			            field.setReadOnly(true);
			        else { // The numeric column
			            // The field needs to know the item it is in
			            field.setData(itemId);
			        }
			        return field;
			    }
		});			
		
		table.addGeneratedColumn("selected", new Table.ColumnGenerator() {
			private static final long serialVersionUID = -2130209119536163943L;

			@Override
		      public Object generateCell(Table source, final Object itemId, Object columnId) {
		        boolean selected = selectedItemIds.contains(itemId);
		        /* When the chekboc value changes, add/remove the itemId from the selectedItemIds set */
		        final CheckBox cb = new CheckBox("", selected);
		        cb.addValueChangeListener(new ValueChangeListener() {
					private static final long serialVersionUID = 8264861549655813906L;

					@Override
					public void valueChange(ValueChangeEvent event) {
						if(selectedItemIds.contains(itemId)){
				              selectedItemIds.remove(itemId);
				            } else {
				              selectedItemIds.add(itemId);
				            }
				          }
				        });
				        return cb;
						
					}

				});		
			
			
			
			table.setColumnHeader("articulo.nombre", "Nombre");
			table.setColumnHeader("articulo.stock", "Stock");
			table.setColumnHeader("cantidad", "Cantidad A Fabricar Recomendada");
			table.setColumnHeader("totalSolicitado", "Total Solicitado");
			table.setColumnHeader("solicitarItem", "Solicitar");
			table.setColumnHeader("txtCantidad", "Cantidad A Fabricar");
			table.setColumnHeader("selected", "");
			
			table.setPageLength(table.size());

			// Have to set explicitly to hide the "equatorial" property
			table.setVisibleColumns(new Object[] { "articulo.nombre", "articulo.stock", 
					"totalSolicitado", "cantidad", "txtCantidad", "selected" });
			table.setEditable(true);
			layout.addComponent(table);
			/*Save Button*/
			Button sendPedido = new Button("Enviar A Fabricar");
			sendPedido.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					table.commit();					
					solicitud.reformular(selectedItemIds);
					facade.crearSolicitudCompra(solicitud);
					UI.getCurrent().getNavigator().navigateTo("/creararticulo");
				}
			});
			layout.addComponent(sendPedido);	
	}
	
}
