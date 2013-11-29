package ar.com.edu.uade.view.solicitudcompra;

import java.util.ArrayList;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import view.SolicitudArticulosItemView;
import view.SolicitudCompraView;
import ar.com.edu.uade.ejbfacade.EJBFacade;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;

import excepctions.BackEndException;

public class SolicitudCompraFormView extends CustomComponent{

	private static final long serialVersionUID = -4946499543984000472L;
	private SolicitudCompraView bindeable;
	private EJBFacade facade;
	private BeanFieldGroup<SolicitudArticulosItemView> binder ;
	private ArrayList<BeanFieldGroup<SolicitudArticulosItemView>> binderList;
	private static final Logger logger = 
			   Logger.getLogger(SolicitudCompraFormView.class);

	
	private class SendRequestListener implements Button.ClickListener{
		private static final long serialVersionUID = -5696020991388183733L;
		private ArrayList<BeanFieldGroup<SolicitudArticulosItemView>> binder ;
		public SendRequestListener(ArrayList<BeanFieldGroup<SolicitudArticulosItemView>> binderList ){
			this.binder = binderList;
		}
		@Override
		public void buttonClick(ClickEvent event) {
            	try {
            		for(BeanFieldGroup<SolicitudArticulosItemView> toBind: binder )
            			toBind.commit();
            			facade.crearSolicitudCompra(bindeable);
				} catch (CommitException e) {
					logger.error(e);
    	        	Notification.show("Error Durante Binding del Formulario", Type.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (BackEndException e) {
					logger.error(e);
    	        	Notification.show("Error Durante la cracionde la Solicitud", Type.ERROR_MESSAGE);
				}
		}
	}
    public SolicitudCompraFormView() {
    		super();
    		binder = new BeanFieldGroup<SolicitudArticulosItemView>(SolicitudArticulosItemView.class);
    		try {
				facade = EJBFacade.getIntance();
				
			} catch (NamingException e) {
				logger.error(e);
	        	Notification.show("Error Durante la Set Up de Fachada del Sistema", Type.ERROR_MESSAGE);
			}
	}
    public void init(){
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        try{	       
	        binderList = new ArrayList<BeanFieldGroup<SolicitudArticulosItemView>>();
	        bindeable = facade.getRecomendacionCompra();
	        //binder.setItemDataSource(bindeable);   	
	    	buildLayout(layout, binder);
		} catch (BackEndException e) {
			logger.error(e);
        	Notification.show("Error Durante la Gestion de Solicitud Recomendada", Type.ERROR_MESSAGE);
		}
    }
	private void buildLayout(FormLayout layout,
			BeanFieldGroup<SolicitudArticulosItemView> binder) {
		AbstractTextField cantidad ;
		for  (SolicitudArticulosItemView s : bindeable.getArticulos()) {
			binder = new BeanFieldGroup<SolicitudArticulosItemView>(SolicitudArticulosItemView.class);
			binder = createForm(s);
			binderList.add(binder);
			cantidad =(AbstractTextField) binder.buildAndBind(s.getArticulo().toString(),"cantidad");
			cantidad.setNullRepresentation("");
			layout.addComponent(cantidad);
			binder.setBuffered(true);
		}
		
		Button sendRequest = new Button();
		sendRequest.addClickListener(new SendRequestListener(binderList));
		layout.addComponent(sendRequest);		
	}
	private BeanFieldGroup<SolicitudArticulosItemView> createForm(SolicitudArticulosItemView s){
		BeanFieldGroup<SolicitudArticulosItemView> toBind = new BeanFieldGroup<SolicitudArticulosItemView>(SolicitudArticulosItemView.class);
		toBind.setItemDataSource(s);
		return toBind;
		
	}
    
}
