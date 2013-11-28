package ar.com.edu.uade.view.articulo;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import ar.com.edu.uade.ejbfacade.EJBFacade;
import ar.com.edu.uade.utils.InstallArticuloValidatorBlurListener;
import ar.com.edu.uade.utils.StringToLongConverter;
import ar.com.edu.uade.utils.ValidatorUtils;
import view.InfantilView;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
public class InfantilFormView extends CustomComponent {
	
	private static final long serialVersionUID = 1739709695326530748L;
	EJBFacade facade;
	private boolean editable;
	private InfantilView bindeable;
	private static final Logger logger = 
			   Logger.getLogger(InfantilFormView.class);
	public InfantilFormView(){
		super();
        try {
			facade = EJBFacade.getIntance();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
    public  void init () {
	        FormLayout layout = new FormLayout();
	        setCompositionRoot(layout);
	        final BeanFieldGroup<InfantilView> binder = new BeanFieldGroup<InfantilView>(InfantilView.class);
	        bindeable = new InfantilView();
	        binder.setItemDataSource(bindeable);
	        editable = false;
	        /* Field Creation Section*/	    	
	    	buildLayout(layout, binder);  	

	    }
    public void init (InfantilView bean) {
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        final BeanFieldGroup<InfantilView> binder = new BeanFieldGroup<InfantilView>(InfantilView.class);
        bindeable = bean;
        binder.setItemDataSource(bindeable);
        editable = true;
        /* Field Creation Section*/    	
    	buildLayout(layout, binder);
    	

    }
	private void buildLayout(FormLayout layout,
			final BeanFieldGroup<InfantilView> binder) {
		final AbstractTextField  descripcion = (AbstractTextField) binder.buildAndBind("Descripcion", "descripcion");
		descripcion.setNullRepresentation("");
		final AbstractTextField  marca=(AbstractTextField) binder.buildAndBind("Marca", "marca");
		marca.setNullRepresentation("");
		final AbstractTextField  nombre=(AbstractTextField) binder.buildAndBind("Nombre", "nombre");
		nombre.setNullRepresentation("");
		final AbstractTextField  precio=(AbstractTextField) binder.buildAndBind("Precio", "textPrecio");
		//final TextField precio= new TextField("Precio","0");
		precio.setNullRepresentation("");
		final AbstractTextField  foto=(AbstractTextField) binder.buildAndBind("Foto", "foto");
		foto.setNullRepresentation("");
		final AbstractTextField  codigo=(AbstractTextField) binder.buildAndBind("Codigo", "textCodigo");
		codigo.setNullRepresentation("");
		final AbstractTextField  edadRecomendada=(AbstractTextField) binder.buildAndBind("Edad Recomendada", "edadRecomendada");
		edadRecomendada.setNullRepresentation("");
		final AbstractTextField  stock =(AbstractTextField) binder.buildAndBind("Stock", "textStock");
		stock.setNullRepresentation("");
		stock.setConverter(new StringToLongConverter());
    	final AbstractTextField  origen =(AbstractTextField) binder.buildAndBind("Origen", "origen");
    	origen.setNullRepresentation("");		

		descripcion.addBlurListener(new InstallArticuloValidatorBlurListener(descripcion, "descripcion"));
		marca.addBlurListener(new InstallArticuloValidatorBlurListener(marca,"marca"));
		nombre.addBlurListener(new InstallArticuloValidatorBlurListener(nombre,"nombre"));
		precio.addBlurListener(new InstallArticuloValidatorBlurListener(precio,"textPrecio"));
		foto.addBlurListener(new InstallArticuloValidatorBlurListener(foto,"foto"));
		codigo.addBlurListener(new InstallArticuloValidatorBlurListener(codigo,"textCodigo"));
		edadRecomendada.addBlurListener(new InstallArticuloValidatorBlurListener(edadRecomendada,"edadRecomendada"));
		origen.addBlurListener(new InstallArticuloValidatorBlurListener(origen,"origen"));
		layout.addComponent(codigo);
		layout.addComponent(descripcion );
		layout.addComponent(marca);
		layout.addComponent(nombre);
		layout.addComponent(precio);
		layout.addComponent(foto);		
		layout.addComponent(edadRecomendada);
		layout.addComponent(origen);
		if (editable){	    		
			layout.addComponent(stock);
			stock.addBlurListener(new InstallArticuloValidatorBlurListener(stock,"textStock"));
		}


		// Buffer the form content
		binder.setBuffered(true);
		layout.addComponent(new Button("OK",new Button.ClickListener() {
			private static final long serialVersionUID = -5099264481778928221L;
			@Override
			public void buttonClick(ClickEvent event) {
		        try {
		        	if (editable) {
		        		ValidatorUtils.installSingleValidator(stock,"textStock");
		        	}
		        	ValidatorUtils.installSingleValidator(marca,"marca");
		        	ValidatorUtils.installSingleValidator(nombre,"nombre");
		        	ValidatorUtils.installSingleValidator(precio,"textPrecio");
		        	ValidatorUtils.installSingleValidator(foto,"foto");
		        	ValidatorUtils.installSingleValidator(codigo,"textCodigo");
		        	ValidatorUtils.installSingleValidator(edadRecomendada,"edadRecomendada");
		        	ValidatorUtils.installSingleValidator(origen,"origen");
		            binder.commit();
		            facade.altaInfatil(bindeable);
		        } catch (CommitException e) {
    	        	try{
    	        		for(Field<?> f:binder.getFields()){
    	        			f.validate();
    	        		}
    	        	
    	        	}catch(Exception j){
    	        		logger.error(j);
    	        		j.printStackTrace();
    	        	}
		        } 
//		        catch (NamingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			}
		} ));
	}
}
