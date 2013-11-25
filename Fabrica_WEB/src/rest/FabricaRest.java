package rest;

import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import parsers.ParserException;
import parsers.SolicitudCompraJSONParser;
import dto.SolicitudCompraDTO;
import facade.FabricaFacade;

@Path("/Fabrica")
public class FabricaRest {

	
	SolicitudCompraJSONParser parser=SolicitudCompraJSONParser.obtenerInstancia();


	FabricaFacade facade=null;

	 private void getFabricaFacade() {
		 if (facade==null){
		 
		 try {
				InitialContext ic = new InitialContext();
				facade = (FabricaFacade) ic.lookup("java:global/Fabrica_EAR/Fabrica_EJB/FabricaFacadeBean");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	 }	 
	@POST
	@Path("/RecibirSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String guardar(String compra) {

		
		try {
			getFabricaFacade();
			
			SolicitudCompraDTO dto = parser.toObject(compra);

			facade.recibirSolicitudCompra(dto);
		} catch (ParserException e) {
			// TODO AR: log error
			e.printStackTrace();
		} 
		
		return compra;

		// TODO AR: Verificar si necesitamos devolver algo para el otro lado...
	}
	
	
}
