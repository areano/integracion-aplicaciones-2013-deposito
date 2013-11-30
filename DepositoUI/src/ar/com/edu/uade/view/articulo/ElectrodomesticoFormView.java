package ar.com.edu.uade.view.articulo;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import view.ElectrodomesticoView;
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
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;

import excepctions.BackEndException;


public class ElectrodomesticoFormView extends CustomComponent {
	

	private class ButtonSave implements Button.ClickListener{
		private static final long serialVersionUID = 1L;
		EJBFacade facade;
		public ButtonSave(){
			super();
			try {
				facade = EJBFacade.getIntance();
			} catch (NamingException e) {
				Notification.show("Error Durante La instanciacion de la Fachada de Sistema", Type.ERROR_MESSAGE);
				logger.error(e);
			}
		}
		@Override
		public void buttonClick(ClickEvent event) {
	        try {
	        	if (editable) {
	        		ValidatorUtils.installSingleValidator(stock,"textStock");
	        	}
	        	
	        	//foto.setValue(((FileResource) image.getSource()).getSourceFile().getPath());
	        	foto.setValue(((FileResource) image.getSource()).getFilename());
	        	ValidatorUtils.installSingleValidator(codigo,"textCodigo");
	        	ValidatorUtils.installSingleValidator(marca,"marca");
	        	ValidatorUtils.installSingleValidator(nombre,"nombre");
	        	ValidatorUtils.installSingleValidator(precio,"textPrecio");
	        	ValidatorUtils.installSingleValidator(foto,"fotoForm");
	        	ValidatorUtils.installSingleValidator(fichaTecnica,"fichaTecnica");
	        	ValidatorUtils.installSingleValidator(origen,"origen");
	        	binder.commit();
        		facade.altaElectrodomestico(bindeable);
        		Notification.show("Articulo Electrodomestico creado", Type.HUMANIZED_MESSAGE);
        		UI.getCurrent().getNavigator().navigateTo("/creararticulo");
	        } catch (CommitException e) {
	        	try{
	        		for(Field<?> f:binder.getFields()){
	        			System.out.println(f.getCaption());
	        			System.out.println(f.getValue());
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
		
	} 
	
	private static final long serialVersionUID = 1739709695326530748L;
	protected final BeanFieldGroup<ElectrodomesticoView> binder;
	protected FormLayout layout;
	private ElectrodomesticoView bindeable;
	private boolean editable;
	private static final Logger logger = 
			   Logger.getLogger(ElectrodomesticoFormView.class);
	
	
	final AbstractTextField  descripcion ;
	final AbstractTextField  marca;
	final AbstractTextField  nombre;
	final AbstractTextField  precio;
	final AbstractTextField  foto;
	final AbstractTextField  codigo;
	final AbstractTextField  fichaTecnica;
	final AbstractTextField  stock ;
	final AbstractTextField  origen;
	Upload upload;// = new Upload("Upload it here", receiver);
	// Show uploaded file in this placeholder
	private Embedded image;// = new Embedded("Uploaded Image");
	private Panel imagePanel; 
    public ElectrodomesticoFormView() {
    		super();
			binder = new BeanFieldGroup<ElectrodomesticoView>(ElectrodomesticoView.class);
			descripcion = (AbstractTextField) binder.buildAndBind("Descripcion", "descripcion");
			descripcion.setNullRepresentation("");
			marca=(AbstractTextField) binder.buildAndBind("Marca", "marca");
			marca.setNullRepresentation("");
			nombre=(AbstractTextField) binder.buildAndBind("Nombre", "nombre");
			nombre.setNullRepresentation("");
			precio=(AbstractTextField) binder.buildAndBind("Precio", "textPrecio");
			precio.setNullRepresentation("");
			foto=(AbstractTextField) binder.buildAndBind("Foto", "fotoForm");
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
			codigo=(AbstractTextField) binder.buildAndBind("Codigo", "textCodigo");
			codigo.setNullRepresentation("");
			fichaTecnica=(AbstractTextField) binder.buildAndBind("Ficha Tecnica", "fichaTecnica");
			fichaTecnica.setNullRepresentation("");
			stock = (AbstractTextField) binder.buildAndBind("Stock", "textStock");
			stock.setNullRepresentation("");
			//stock.setConverter(new StringToLongConverter());
			
			origen =(AbstractTextField) binder.buildAndBind("Origen", "origen");
			origen.setNullRepresentation("");
	}
    public void init(){
        layout = new FormLayout();
        setCompositionRoot(layout);
        
        bindeable = new ElectrodomesticoView();
        binder.setItemDataSource(bindeable);
        editable = false;
        buildLayout(layout, binder);
    }
    public void  init(ElectrodomesticoView bean){
        layout = new FormLayout();
        layout.setStyleName("chameleon");
        setCompositionRoot(layout);
       
        bindeable = bean;
        binder.setItemDataSource(bindeable);
        editable = true;
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
			final BeanFieldGroup<ElectrodomesticoView> binder) {
    	
   	
    	descripcion.addBlurListener(new InstallArticuloValidatorBlurListener(descripcion, "descripcion"));
    	marca.addBlurListener(new InstallArticuloValidatorBlurListener(marca,"marca"));
    	nombre.addBlurListener(new InstallArticuloValidatorBlurListener(nombre,"nombre"));
    	precio.addBlurListener(new InstallArticuloValidatorBlurListener(precio,"textPrecio"));
    	foto.addBlurListener(new InstallArticuloValidatorBlurListener(foto,"tipo"));
    	fichaTecnica.addBlurListener(new InstallArticuloValidatorBlurListener(fichaTecnica,"fichaTecnica"));
    	origen.addBlurListener(new InstallArticuloValidatorBlurListener(origen,"origen"));
    	codigo.addBlurListener(new InstallArticuloValidatorBlurListener(codigo,"textCodigo"));
    	layout.addComponent(codigo);
    	layout.addComponent(descripcion );
    	layout.addComponent(marca);
    	layout.addComponent(nombre);
    	layout.addComponent(precio);
    	HorizontalLayout fotoUpload =  new HorizontalLayout();
    	fotoUpload.addComponentAsFirst(foto);
    	fotoUpload.addComponent(imagePanel);
    	layout.addComponent(fotoUpload); 	
    	layout.addComponent(fichaTecnica);
    	layout.addComponent(origen);
    	
    	if (editable){	    		
    		layout.addComponent(stock);
    		stock.addBlurListener(new InstallArticuloValidatorBlurListener(stock,"textStock"));
    	}
    	// Buffer the form content
    	binder.setBuffered(true);
    	Button okButton =  new Button("OK");
    	okButton.addClickListener(new ButtonSave());
    	layout.addComponent(okButton);
    }

   
}
