package ar.com.edu.uade.data;



import java.io.Serializable;

import javax.naming.NamingException;

import ar.com.edu.uade.ejbfacade.EJBFacade;
import view.ArticuloView;

import com.vaadin.data.util.BeanItemContainer;

import excepctions.BackEndException;

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
    public ArticuloContainer() throws NamingException   {
        super(ArticuloView.class);
		facade = EJBFacade.getIntance();

    }

    public  void init() throws BackEndException {

        	this.addAll(facade.getAllArticulos());

    }
   

}
