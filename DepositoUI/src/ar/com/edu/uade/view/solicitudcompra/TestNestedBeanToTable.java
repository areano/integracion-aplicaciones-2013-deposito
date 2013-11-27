package ar.com.edu.uade.view.solicitudcompra;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
import view.SolicitudCompraView;
import ar.com.edu.uade.ejbfacade.EJBFacade;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TableFieldFactory;
import com.vaadin.ui.TextField;

public class TestNestedBeanToTable extends CustomComponent {

	private static final long serialVersionUID = 4027479393578050192L;
/**
 * 
 */	
 
	class ItemTable extends CustomField {
	    Table table = new Table();
	    BeanItemContainer<SolicitudArticulosItemView> itemContainer =
	        new BeanItemContainer<SolicitudArticulosItemView>(SolicitudArticulosItemView.class);

	    public ItemTable() {
	        table.setContainerDataSource(itemContainer);
	        table.setTableFieldFactory(new TableFieldFactory() {
	            @Override
	            public Field createField(Container container, Object itemId,
	                    Object propertyId, Component uiContext) {
	                TextField field = new TextField();
	                if ("name".equals(propertyId))
	                    field.setWidth("10em");
	                else if ("year".equals(propertyId))
	                    field.setWidth("4em");
	                field.setImmediate(true);
	                return field;
	            }
	        });
	        table.setVisibleColumns(new Object[]{"name", "year"});
	        table.setEditable(!isReadOnly());
	        setCompositionRoot(table);
	    }

	    @Override
	    public Class<?> getType() {
	        return ArrayList.class;
	    }
	    
	    @Override
	    public void setPropertyDataSource(Property newDataSource) {
	        Object value = newDataSource.getValue();
	        if (value instanceof List<?>) {
	            @SuppressWarnings("unchecked")
	            List<SolicitudArticulosItemView> beans = (List<SolicitudArticulosItemView>) value;
	            itemContainer.removeAllItems();
	            itemContainer.addAll(beans);
	            table.setPageLength(beans.size());
	        } else


	        super.setPropertyDataSource(newDataSource);
	    }
	    
	    @Override
	    public Object getValue() {
	        ArrayList<SolicitudArticulosItemView> beans = new ArrayList<SolicitudArticulosItemView>(); 
	        for (Object itemId: itemContainer.getItemIds())
	            beans.add(itemContainer.getItem(itemId).getBean());
	        return beans;
	    }
	    
	    @Override
	    public void setReadOnly(boolean readOnly) {
	        table.setEditable(!readOnly);
	        super.setReadOnly(readOnly);
	    }

		@Override
		protected Component initContent() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	    
	public void nestedtable(Layout rootLayout) throws NamingException {
	    // Create a nested bean
//	    Planet jupiter = new Planet("Jupiter");
//	    jupiter.setMoons(Arrays.asList(
//	            new Moon("io", 1610, null),
//	            new Moon("europa", 1610, null),
//	            new Moon("ganymedes", 1610, null),
//	            new Moon("callisto", 1610, null)
//	    ));

	    // Wrap it
	    final BeanItem<SolicitudCompraView> solicitudBean = new BeanItem<SolicitudCompraView>
			( EJBFacade.getIntance().getRecomendacionCompra());

//	    =	new BeanItem<SolicitudArticulosItemView>();
	    
	    class MyNestedFormFactory extends DefaultFieldFactory {
	        @Override
	        public Field createField(Item item, Object propertyId,
	                Component uiContext) {
	            Field field;
	            if ("items".equals(propertyId)) {
	                field = new ItemTable();
	                field.setCaption("Items");
	            } else
	                field = super.createField(item, propertyId, uiContext);
	            return field;
	        }
	    }            
	    
	    // Bind it to a form
	    final Form form = new Form();
	    form.setFormFieldFactory(new MyNestedFormFactory());
	    form.setItemDataSource(solicitudBean);
	    form.setVisibleItemProperties(new Object[]{"txtCantidad", "items"});
	    form.addStyleName("innertable");
	    
	    // Read-only form to display the buffered data model value
	    final Form valueForm = new Form();
	    valueForm.setFormFieldFactory(new MyNestedFormFactory());
	    valueForm.setReadOnly(true);
	    valueForm.addStyleName("innertable");
	    
	    Button save = new Button("Save");
	    save.addClickListener(new Button.ClickListener() {
	        @Override
	        public void buttonClick(ClickEvent event) {
	            form.commit();
	            valueForm.setItemDataSource(solicitudBean);
	            valueForm.setVisibleItemProperties(new Object[]{"txtCantidad", "items"});
	            valueForm.setReadOnly(true);
	        }

	    });
	    form.getFooter().addComponent(save);

	    // Put the forms in a layout
	    HorizontalLayout layout = new HorizontalLayout();
	    layout.addComponent(form);
	    layout.addComponent(valueForm);
	    layout.setSpacing(true);
	    rootLayout.addComponent(layout);
	}
	
/**
 * 	
 */
}
