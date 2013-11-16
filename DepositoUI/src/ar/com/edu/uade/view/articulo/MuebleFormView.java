package ar.com.edu.uade.view.articulo;
import ar.com.edu.uade.utils.InstallArticuloValidatorBlurListener;
import ar.com.edu.uade.utils.ValidatorUtils;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;

import dto.MuebleDTO;

public class MuebleFormView extends CustomComponent {

	private static final long serialVersionUID = 1739709695326530748L;
	private boolean editable;
	private MuebleDTO bindeable;
    public MuebleFormView() {
	        FormLayout layout = new FormLayout();
	        setCompositionRoot(layout);
	        final BeanFieldGroup<MuebleDTO> binder = new BeanFieldGroup<MuebleDTO>(MuebleDTO.class);
	        bindeable = new MuebleDTO();
	        binder.setItemDataSource(bindeable);
	        editable = false;
	        /* Field Creation Section*/
   	
	    	buildLayout(layout, binder);
	    	

	    }
    public MuebleFormView(MuebleDTO bean) {
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        final BeanFieldGroup<MuebleDTO> binder = new BeanFieldGroup<MuebleDTO>(MuebleDTO.class);
        bindeable = bean;
        binder.setItemDataSource(bindeable);
        editable = true;
        /* Field Creation Section*/	
    	buildLayout(layout, binder);
    }
	private void buildLayout(FormLayout layout,
			final BeanFieldGroup<MuebleDTO> binder) {
		final AbstractTextField  descripcion = (AbstractTextField) binder.buildAndBind("Descripcion", "descripcion");
		descripcion.setNullRepresentation("");
		final AbstractTextField  marca=(AbstractTextField) binder.buildAndBind("Marca", "marca");
		marca.setNullRepresentation("");
		final AbstractTextField  nombre=(AbstractTextField) binder.buildAndBind("Nombre", "nombre");
		nombre.setNullRepresentation("");
		final AbstractTextField  precio=(AbstractTextField) binder.buildAndBind("Precio", "precio");
		precio.setNullRepresentation("");
		final AbstractTextField  foto=(AbstractTextField) binder.buildAndBind("foto", "foto");
		foto.setNullRepresentation("");
		final AbstractTextField  codigoDeposito=(AbstractTextField) binder.buildAndBind("Codigo Deposito", "codigoDeposito");
		codigoDeposito.setNullRepresentation("");
		final AbstractTextField  material=(AbstractTextField) binder.buildAndBind("Material", "material");
		material.setNullRepresentation("");
		final AbstractTextField  stock =(AbstractTextField) binder.buildAndBind("Stock", "stock");
		stock.setNullRepresentation("");
		

		descripcion.addBlurListener(new InstallArticuloValidatorBlurListener(descripcion, "descripcion"));
		marca.addBlurListener(new InstallArticuloValidatorBlurListener(marca,"marca"));
		nombre.addBlurListener(new InstallArticuloValidatorBlurListener(nombre,"nombre"));
		precio.addBlurListener(new InstallArticuloValidatorBlurListener(precio,"precio"));
		foto.addBlurListener(new InstallArticuloValidatorBlurListener(foto,"foto"));
		codigoDeposito.addBlurListener(new InstallArticuloValidatorBlurListener(codigoDeposito,"codigoDeposito"));
		material.addBlurListener(new InstallArticuloValidatorBlurListener(material,"material"));
		

		layout.addComponent(descripcion );
		layout.addComponent(marca);
		layout.addComponent(nombre);
		layout.addComponent(precio);
		layout.addComponent(foto);
		layout.addComponent(codigoDeposito);
		layout.addComponent(material);
		if (editable){	    		
			layout.addComponent(stock);
			stock.addBlurListener(new InstallArticuloValidatorBlurListener(stock,"stock"));
		}

		// Buffer the form content
		binder.setBuffered(true);
		layout.addComponent(new Button("OK",new Button.ClickListener() {
			private static final long serialVersionUID = -5099264481778928221L;
			@Override
			public void buttonClick(ClickEvent event) {
		        try {
		        	if (editable) {
		        		ValidatorUtils.installSingleValidator(stock,"stock");
		        	}
		        	ValidatorUtils.installSingleValidator(marca,"marca");
		        	ValidatorUtils.installSingleValidator(nombre,"nombre");
		        	ValidatorUtils.installSingleValidator(precio,"precio");
		        	ValidatorUtils.installSingleValidator(foto,"foto");
		        	ValidatorUtils.installSingleValidator(codigoDeposito,"codigoDeposito");
		        	ValidatorUtils.installSingleValidator(material,"material");
		            binder.commit();
		        } catch (CommitException e) {
		        }
				
			}
		} ));
	}
}
