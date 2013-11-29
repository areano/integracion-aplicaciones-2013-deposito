package dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import parsers.ParserException;
import parsers.SolicitudCompraJSONParser;
import clientes.GenericRestClient;
import dto.SolicitudCompraDTO;
import excepctions.BackEndException;

/**
 * Session Bean implementation class FabricaDAO
 */
@Stateless
@LocalBean
public class FabricaDAO {	
	SolicitudCompraJSONParser parser=SolicitudCompraJSONParser.obtenerInstancia();	
	GenericRestClient clienteRest ;
	private static final Logger logger = Logger.getLogger(FabricaDAO.class);

	public FabricaDAO() throws BackEndException{
		clienteRest = new GenericRestClient();
		String localMachine =null;
		try {
			localMachine=java.net.InetAddress.getLocalHost().getHostAddress();
			}
			catch (java.net.UnknownHostException uhe) { // [beware typo in
				logger.error("Error Getting Machine Local Address / Host", uhe);
				throw new BackEndException(uhe);
			}
		clienteRest.setIp(localMachine);
		clienteRest.setPort("8080");
		clienteRest.setMetodo("Fabrica_WEB/Fabrica/RecibirSolicitud");
	}
	
    public FabricaDAO(String ip, String puerto, String metodo) {
    	
		this.clienteRest = new GenericRestClient(ip, puerto, metodo);
    	
    }

	public void enviar(SolicitudCompraDTO compra) throws BackEndException {
		
		try {
			String mensaje = parser.toString(compra);
			clienteRest.enviar(mensaje);
			
		} catch (ParserException e) {
			e.printStackTrace();
			logger.error("Error Parseando XML", e);
			throw new BackEndException(e);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Enviando XML de compra", e);
			throw new BackEndException(e);
		}
	}
}
