package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import dto.SolicitudCompraDTO;
import facade.FabricaFacade;
import parsers.ParserException;
import parsers.SolicitudCompraParser;

@Path("/REST")
public class RecibirSolicitudCompraRest {

	@EJB
	FabricaFacade facade;

	@POST()
	@Path("/RecibirSolicitudCompra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String recibirCompra(String solicitudCompra) {

		try {
			SolicitudCompraParser parser = new SolicitudCompraParser();

			SolicitudCompraDTO dto = parser.toObject(solicitudCompra);

			facade.recibirSolicitudCompra(dto);
		} catch (ParserException e) {
			// TODO AR: log error
			e.printStackTrace();
		}

		return "Hello World!";
	}
}
