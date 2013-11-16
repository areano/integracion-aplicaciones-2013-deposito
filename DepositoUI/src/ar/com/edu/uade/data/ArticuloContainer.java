package ar.com.edu.uade.data;



import java.io.Serializable;
import java.util.Random;

import ar.com.edu.uade.ejbfacade.EJBFacade;

import com.vaadin.data.util.BeanItemContainer;

import dto.ArticuloDTO;

@SuppressWarnings("serial")
public class ArticuloContainer extends BeanItemContainer<ArticuloDTO> implements
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

    public ArticuloContainer() throws InstantiationException,
            IllegalAccessException {
        super(ArticuloDTO.class);
    }
//    public  void init(){
//    	EJBFacade facade = new EJBFacade();
//    	addAll(facade.getAllArticulos());
//    	
//    }
    public static ArticuloContainer init() {
    	ArticuloContainer c = null;
        try {
            c = new ArticuloContainer();
            EJBFacade facade = new EJBFacade();
        	c.addAll(facade.getAllArticulos());

        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return c;
    }
   

}
