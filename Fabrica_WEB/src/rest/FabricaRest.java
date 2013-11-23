package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import parsers.ParserException;
import parsers.SolicitudCompraParser;
import dto.SolicitudCompraDTO;
import facade.FabricaFacade;

@Path("/Fabrica")
public class FabricaRest {

	@EJB
	FabricaFacade facade;

	@POST
	@Path("/RecibirSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String guardar(String compra) {

		try {
			SolicitudCompraParser parser = new SolicitudCompraParser();

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
