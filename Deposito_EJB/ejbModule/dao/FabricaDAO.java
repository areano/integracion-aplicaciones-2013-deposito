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

	
	SolicitudCompraJSONParser parser=SolicitudCompraJSONParser.obtenerInstancia();
	
	GenericRestClient clienteRest ;
	

	public FabricaDAO(){
		clienteRest = new GenericRestClient();
		clienteRest.setIp("127.0.0.1");
		clienteRest.setPort("8080");
		clienteRest.setMetodo("Fabrica_WEB/Fabrica/RecibirSolicitud");
	}
	
    public FabricaDAO(String ip, String puerto, String metodo) {
    	
		this.clienteRest = new GenericRestClient(ip, puerto, metodo);
    	
    }

	public void enviar(SolicitudCompraDTO compra) {
		
		try {
			String mensaje = parser.toString(compra);
			clienteRest.enviar(mensaje);
			
		} catch (ParserException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
