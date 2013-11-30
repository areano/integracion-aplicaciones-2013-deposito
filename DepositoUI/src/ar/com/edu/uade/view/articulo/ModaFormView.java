package ar.com.edu.uade.view.articulo;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import view.ModaView;
import ar.com.edu.uade.ejbfacade.EJBFacade;
import ar.com.edu.uade.utils.ImageUploader;
import ar.com.edu.uade.utils.InstallArticuloValidatorBlurListener;
import ar.com.edu.uade.utils.ValidatorUtils;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.server.FileResource;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;

import excepctions.BackEndException;
public class ModaFormView extends CustomComponent {
	
	private static final long serialVersionUID = 1739709695326530748L;
	private boolean editable;
	private ModaView bindeable;

	EJBFacade facade;
	private static final Logger logger = 
			   Logger.getLogger(ModaFormView.class);
	Upload upload;// = new Upload("Upload it here", receiver);
	// Show uploaded file in this placeholder
	private Embedded image;// = new Embedded("Uploaded Image");
	private Panel imagePanel; 
    public ModaFormView() {
    		super();
    		try {
				facade = EJBFacade.getIntance();
			} catch (NamingException e) {
				Notification.show("Error Durante La instanciacion de la Fachada de Sistema", Type.ERROR_MESSAGE);
				logger.error(e);
			}
	}
    public void init( ModaView bean) {
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        final BeanFieldGroup<ModaView> binder = new BeanFieldGroup<ModaView>(ModaView.class);
        bindeable = bean;
        binder.setItemDataSource(bindeable);
        editable = true;
        /* Field Creation Section*/    	
    	buildLayout(layout, binder);
        URI uri;
		try {
			uri = new URI("http://"+bean.getFoto());
			File file = new File("../welcome-content"+uri.getPath());
	        image.setSource(new FileResource(file)); 
	        buildLayout(layout, binder);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
	private void buildLayout(FormLayout layout,
			final BeanFieldGroup<ModaView> binder) {
		final AbstractTextField  descripcion = (AbstractTextField) binder.buildAndBind("Descripcion", "descripcion");
		descripcion.setNullRepresentation("");
		final AbstractTextField  marca=(AbstractTextField) binder.buildAndBind("Marca", "marca");
		marca.setNullRepresentation("");
		final AbstractTextField  nombre=(AbstractTextField) binder.buildAndBind("Nombre", "nombre");
		nombre.setNullRepresentation("");
		final AbstractTextField  precio=(AbstractTextField) binder.buildAndBind("Precio", "textPrecio");
		precio.setNullRepresentation("");
		precio.setNullRepresentation("");
		final AbstractTextField  foto=(AbstractTextField) binder.buildAndBind("Foto", "fotoForm");
		foto.setNullRepresentation("");
		/** 
		 * Image
		 */
			image = new Embedded("Uploaded Image");
			image.setVisible(false);
			image.setHeight("150px");
			image.setWidth("200px");
			ImageUploader receiver = new ImageUploader(image,foto); 
			upload = new Upload("Suba la imagen aqui", receiver);
			upload.addSucceededListener(receiver);
			// Put the components in a panel
			imagePanel = new Panel();
			Layout panelContent = new HorizontalLayout();
			panelContent.addComponents(upload, image);
			imagePanel.setContent(panelContent);
		/**
		 * End upload  Image
		 */
		final AbstractTextField  codigo=(AbstractTextField) binder.buildAndBind("Codigo", "textCodigo");
		codigo.setNullRepresentation("");

		final AbstractTextField  color=(AbstractTextField) binder.buildAndBind("Color", "color");
		color.setNullRepresentation("");
		final AbstractTextField  talle=(AbstractTextField) binder.buildAndBind("Talle", "talle");
		talle.setNullRepresentation("");
		final AbstractTextField  stock =(AbstractTextField) binder.buildAndBind("Stock", "textStock");
		stock.setNullRepresentation("");
		//stock.setConverter(new StringToLongConverter());
		
    	final AbstractTextField  origen =(AbstractTextField) binder.buildAndBind("Origen", "origen");
    	origen.setNullRepresentation("");
		descripcion.addBlurListener(new InstallArticuloValidatorBlurListener(descripcion, "descripcion"));
		marca.addBlurListener(new InstallArticuloValidatorBlurListener(marca,"marca"));
		nombre.addBlurListener(new InstallArticuloValidatorBlurListener(nombre,"nombre"));
		precio.addBlurListener(new InstallArticuloValidatorBlurListener(precio,"textPrecio"));
		foto.addBlurListener(new InstallArticuloValidatorBlurListener(foto,"fotoForm"));
		codigo.addBlurListener(new InstallArticuloValidatorBlurListener(codigo,"textCodigo"));
		color.addBlurListener(new InstallArticuloValidatorBlurListener(color,"color"));
		talle.addBlurListener(new InstallArticuloValidatorBlurListener(talle,"talle"));    	
		origen.addBlurListener(new InstallArticuloValidatorBlurListener(origen,"origen"));
		layout.addComponent(codigo);
		layout.addComponent(marca);
		layout.addComponent(nombre);
		layout.addComponent(color);
		layout.addComponent(descripcion );
		layout.addComponent(precio);
    	HorizontalLayout fotoUpload =  new HorizontalLayout();
    	fotoUpload.addComponentAsFirst(foto);
    	fotoUpload.addComponent(imagePanel);
    	layout.addComponent(fotoUpload);	
		layout.addComponent(talle); 
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
		        	foto.setValue(((FileResource) image.getSource()).getFilename());
		        	ValidatorUtils.installSingleValidator(marca,"marca");
		        	ValidatorUtils.installSingleValidator(nombre,"nombre");
		        	ValidatorUtils.installSingleValidator(precio,"textPrecio");
		        	ValidatorUtils.installSingleValidator(foto,"fotoForm");
		        	ValidatorUtils.installSingleValidator(codigo,"textCodigo");
		        	ValidatorUtils.installSingleValidator(color,"color");
		        	ValidatorUtils.installSingleValidator(talle,"talle");
		        	ValidatorUtils.installSingleValidator(origen,"origen");
		            binder.commit();
		            //EJBFacade.getIntance().altaModa(bindeable);
	        		if (editable)
	        			facade.updateStock(bindeable);	
	        		else
	        			facade.altaModa(bindeable);
		            Notification.show("Articulo Moda creado", Type.HUMANIZED_MESSAGE);
		            UI.getCurrent().getNavigator().navigateTo("/creararticulo");
		        } catch (CommitException e) {
    	        	try{
    	        		for(Field<?> f:binder.getFields()){
    	        			f.validate();
    	        		}
    	        	
    	        	}catch(Exception j){
    	        		logger.error(j);
    	        		Notification.show("Error Durante la Valiadacion del Formulario", Type.ERROR_MESSAGE);
    	        	}
    	        } catch (BackEndException e) {
    	        	logger.error(e);
    	        	Notification.show("Error Durante la Persistencia del Formulario", Type.ERROR_MESSAGE);
				} 
				
			}
		} ));
	}
	public void init() {
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        final BeanFieldGroup<ModaView> binder = new BeanFieldGroup<ModaView>(ModaView.class);
        bindeable = new ModaView();
        binder.setItemDataSource(bindeable);
        editable = false;
        /* Field Creation Section*/	    	
    	buildLayout(layout, binder);
		
	}

}
