package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.SolicitudArticulosDTO;
import parsers.ParserException;
import parsers.SolicitudArticulosParser;

public class SolicitudArticulosParserTest {

	@Test
	public void test() {
		SolicitudArticulosParser SAParser = new SolicitudArticulosParser();
		SolicitudArticulosDTO SADTO = null;
		String xml = new String(
				"<solicitudArticulos><idSolicitud>1</idSolicitud><idModulo>2</idModulo><articulos><articulo><codigo>PEPE1</codigo><cantidad>10</cantidad></articulo></articulos></solicitudArticulos>");

		try {
			SADTO = SAParser.toObject(xml);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(SADTO.getIdSolicitud() == 1);
		assertTrue(SADTO.getIdModulo() == 2);
		assertTrue(SADTO.getLista().get(0).getCantidad() == 10);
		assertEquals(SADTO.getLista().get(0).getCodigo(), "PEPE1");
		assertEquals(SADTO.getLista().size(), 1);

	}

}
