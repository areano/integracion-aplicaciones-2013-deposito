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


import dto.InfantilDTO;

public class InfantilFormView extends CustomComponent {
	
	private static final long serialVersionUID = 1739709695326530748L;
	private boolean editable;
	private InfantilDTO bindeable;
    public InfantilFormView() {
	        FormLayout layout = new FormLayout();
	        setCompositionRoot(layout);
	        final BeanFieldGroup<InfantilDTO> binder = new BeanFieldGroup<InfantilDTO>(InfantilDTO.class);
	        binder.setItemDataSource(new InfantilDTO());
	        editable = false;
	        /* Field Creation Section*/	    	
	    	buildLayout(layout, binder);  	

	    }
    public InfantilFormView(InfantilDTO bean) {
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        final BeanFieldGroup<InfantilDTO> binder = new BeanFieldGroup<InfantilDTO>(InfantilDTO.class);
        bindeable = bean;
        binder.setItemDataSource(bindeable);
        editable = true;
        /* Field Creation Section*/    	
    	buildLayout(layout, binder);
    	

    }
	private void buildLayout(FormLayout layout,
			final BeanFieldGroup<InfantilDTO> binder) {
		final AbstractTextField  descripcion = (AbstractTextField) binder.buildAndBind("Descripcion", "descripcion");
		descripcion.setNullRepresentation("");
		final AbstractTextField  marca=(AbstractTextField) binder.buildAndBind("Marca", "marca");
		marca.setNullRepresentation("");
		final AbstractTextField  nombre=(AbstractTextField) binder.buildAndBind("Nombre", "nombre");
		nombre.setNullRepresentation("");
		final AbstractTextField  precio=(AbstractTextField) binder.buildAndBind("Precio", "precio");
		precio.setNullRepresentation("");
		final AbstractTextField  foto=(AbstractTextField) binder.buildAndBind("Foto", "foto");
		foto.setNullRepresentation("");
		final AbstractTextField  codigoDeposito=(AbstractTextField) binder.buildAndBind("Codigo Deposito", "codigoDeposito");
		codigoDeposito.setNullRepresentation("");
		final AbstractTextField  edadRecomendada=(AbstractTextField) binder.buildAndBind("Edad Recomendada", "edadRecomendada");
		edadRecomendada.setNullRepresentation("");
		final AbstractTextField  stock =(AbstractTextField) binder.buildAndBind("Stock", "stock");
		stock.setNullRepresentation("");
		

		descripcion.addBlurListener(new InstallArticuloValidatorBlurListener(descripcion, "descripcion"));
		marca.addBlurListener(new InstallArticuloValidatorBlurListener(marca,"marca"));
		nombre.addBlurListener(new InstallArticuloValidatorBlurListener(nombre,"nombre"));
		precio.addBlurListener(new InstallArticuloValidatorBlurListener(precio,"precio"));
		foto.addBlurListener(new InstallArticuloValidatorBlurListener(foto,"foto"));
		codigoDeposito.addBlurListener(new InstallArticuloValidatorBlurListener(codigoDeposito,"codigoDeposito"));
		edadRecomendada.addBlurListener(new InstallArticuloValidatorBlurListener(edadRecomendada,"edadRecomendada"));


		layout.addComponent(descripcion );
		layout.addComponent(marca);
		layout.addComponent(nombre);
		layout.addComponent(precio);
		layout.addComponent(foto);
		layout.addComponent(codigoDeposito);
		layout.addComponent(edadRecomendada);
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
		        	ValidatorUtils.installSingleValidator(edadRecomendada,"edadRecomendada");
		            binder.commit();
		        } catch (CommitException e) {
		        }
				
			}
		} ));
	}
}
