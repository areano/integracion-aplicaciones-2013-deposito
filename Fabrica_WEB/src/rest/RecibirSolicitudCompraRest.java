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
import facade.DepositoFacade;

@Path("/ejemplo")
public class RecibirSolicitudCompraRest {

	@EJB
	DepositoFacade facade;

	// @GET
	// @Path("/obtener/{id}")
	// @Produces(MediaType.TEXT_PLAIN)
	// public String obtener(@PathParam("id") String id) {
	// return "ingresaste " + id;
	// }

	@POST
	@Path("/recibirSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	public void guardar(String compra) {

		try {
			SolicitudCompraParser parser = new SolicitudCompraParser();

			SolicitudCompraDTO dto;

			dto = parser.toDto(compra);

			facade.recibirSolicitudCompra(dto);
		} catch (ParserException e) {
			// TODO AR: log error y rollback
			e.printStackTrace();
		}

		// TODO AR: Verificar si necesitamos devolver algo para el otro lado...
	}
}
