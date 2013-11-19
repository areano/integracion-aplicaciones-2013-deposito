package ar.com.edu.uade.data;



import java.io.Serializable;
import java.util.Random;

import javax.ejb.EJB;
import javax.naming.NamingException;

import ar.com.edu.uade.ejbfacade.EJBFacade;
import view.ArticuloView;

import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class ArticuloContainer extends BeanItemContainer<ArticuloView> implements
        Serializable {

    /**
     * Natural property order for Articulo bean. Used in tables and forms.
     */
    public static final Object[] NATURAL_COL_ORDER = new Object[] {
	    "codigo","marca","nombre","descripcion", "foto","precio","stock"};

    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static final String[] COL_HEADERS_ENGLISH = new String[] {
    	 "Codigo Artitulo","Marca","Nombre", "Descripcion", "Foto","precio","Stock Disponible" };

    EJBFacade facade;
    public ArticuloContainer() throws InstantiationException,
            IllegalAccessException {
        super(ArticuloView.class);
        try {
			facade = EJBFacade.getIntance();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    }
//    public  void init(){
//    	EJBFacade facade = new EJBFacade();
//    	addAll(facade.getAllArticulos());
//    	
//    }
    public  void init() {
//    	ArticuloContainer c = null;
//        try {
//            c = new ArticuloContainer();
////            EJBFacade facade = EJBFacade.getIntance();
//        	c.addAll(facade.getAllArticulos());
        	this.addAll(facade.getAllArticulos());

//        } catch (InstantiationException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } 
//            catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        //return this;
    }
   

}
