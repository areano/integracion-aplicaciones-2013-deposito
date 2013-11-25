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
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
    public SolicitudCompraFormView() {
    		super();
    		binder = new BeanFieldGroup<SolicitudArticulosItemView>(SolicitudArticulosItemView.class);
    		try {
				facade = EJBFacade.getIntance();
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
    public void init(){
        FormLayout layout = new FormLayout();
        setCompositionRoot(layout);
        
       
        binderList = new ArrayList<BeanFieldGroup<SolicitudArticulosItemView>>();
        bindeable = facade.getRecomendacionCompra();
        //binder.setItemDataSource(bindeable);   	
    	buildLayout(layout, binder);
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
