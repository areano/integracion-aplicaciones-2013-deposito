package ar.com.edu.uade.searcher;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ar.com.edu.uade.data.ArticuloContainer;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import dto.ArticuloDTO;

@SuppressWarnings("serial")
public class ArticuloForm extends Form implements ClickListener {

    private Button save = new Button("Save", (ClickListener) this);
    private Button cancel = new Button("Cancel", (ClickListener) this);
    private Button edit = new Button("Edit", (ClickListener) this);
    

    
    private boolean newContactMode = false;
    private ArticuloDTO newPerson = null;
    private ArticuloContainer container = ArticuloContainer.init();
    public ArticuloForm() {
        

        /*
         * Enable buffering so that commit() must be called for the form before
         * input is written to the data. (Form input is not written immediately
         * through to the underlying object.)
         */
        

        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(save);
        footer.addComponent(cancel);
        footer.addComponent(edit);
        footer.setVisible(false);

        setFooter(footer);


        /* Populate cities select using the cities in the data container */
        
//        for (Iterator<ArticuloDTO> it = container.getItemIds().iterator(); it.hasNext();) {
//
//        }

        /*
         * Field factory for overriding how the component for city selection is
         * created
         */
        setFormFieldFactory(new DefaultFieldFactory() {
            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {

                Field field = super.createField(item, propertyId, uiContext);
                /* example */
                if (propertyId.equals("postalCode")) {
                }

                field.setWidth("200px");
                return field;
            }
        });
    }

    public void buttonClick(ClickEvent event) {
        Button source = event.getButton();

        if (source == save) {
            /* If the given input is not valid there is no point in continuing */
            if (!isValid()) {
                return;
            }

            commit();
            if (newContactMode) {
                /* We need to add the new person to the container */
                Item addedItem = container.addItem(newPerson);
                /*
                 * We must update the form to use the Item from our datasource
                 * as we are now in edit mode (no longer in add mode)
                 */
                setItemDataSource(addedItem);

                newContactMode = false;
            }
            setReadOnly(true);
        } else if (source == cancel) {
            if (newContactMode) {
                newContactMode = false;
                /* Clear the form and make it invisible */
                setItemDataSource(null);
            } else {
                discard();
            }
            setReadOnly(true);
        } else if (source == edit) {
            setReadOnly(false);
        }
    }

    @Override
    public void setItemDataSource(Item newDataSource) {
        newContactMode = false;

        if (newDataSource != null) {
            List<Object> orderedProperties = Arrays
                    .asList(ArticuloContainer.NATURAL_COL_ORDER);
            super.setItemDataSource(newDataSource, orderedProperties);

            setReadOnly(true);
            getFooter().setVisible(true);
        } else {
            super.setItemDataSource(null);
            getFooter().setVisible(false);
        }
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        save.setVisible(!readOnly);
        cancel.setVisible(!readOnly);
        edit.setVisible(readOnly);
    }

//    public void addContact() {
//        // Create a temporary item for the form
//        newPerson = new ArticuloDTO();
//        setItemDataSource(new BeanItem<ArticuloDTO>(newPerson));
//        newContactMode = true;
//        setReadOnly(false);
//    }

}