package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import parsers.ParserException;
import parsers.SolicitudCompraJSONParser;
import clientes.GenericRestClient;
import dto.SolicitudCompraDTO;

/**
 * Session Bean implementation class FabricaDAO
 */
@Stateless
@LocalBean
public class FabricaDAO {

	GenericRestClient clienteRest ;
	

	public FabricaDAO(){
		clienteRest = new GenericRestClient();
		clienteRest.setIp("127.0.0.1");
		clienteRest.setPort("8080");
		clienteRest.setMetodo("Fabrica_WEB/Fabrica/RecibirSolicitud");
	}
	
    public FabricaDAO(String ip, String puerto, String metodo) {
        // TODO AR: levantar parametros de comunicacion REST y crear el cliente
    	
		this.clienteRest = new GenericRestClient(ip, puerto, metodo);
    	
    }

	public void enviar(SolicitudCompraDTO compra) {
		// TODO AR: enviar solicitud mediante REST
		
		try {
			SolicitudCompraJSONParser parser = new SolicitudCompraJSONParser();
			String mensaje = parser.toString(compra);
			clienteRest.enviar(mensaje);
			
		} catch (ParserException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
