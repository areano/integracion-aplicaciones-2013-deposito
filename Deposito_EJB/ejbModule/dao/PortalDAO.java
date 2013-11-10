package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import jms.GenericQueueClient;
import parsers.ArticuloParser;
import entities.Articulo;

/**
 * Session Bean implementation class PortalDAO
 */
@Stateless
@LocalBean
public class PortalDAO {

    public PortalDAO() {}
    
    public void enviar(Articulo a){
    	ArticuloParser parser = new ArticuloParser();
    	String xml = parser.electrodomesticoToXML(a);
    	GenericQueueClient cliente = new GenericQueueClient();
    	cliente.enviar(xml);
    }

}
