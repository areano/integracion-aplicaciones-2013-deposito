package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.SolicitudArticulosDTO;
import parsers.ArticuloParser;
import parsers.ParserException;
import parsers.SolicitudArticulosParser;

public class SolicitudArticulosParserTest {

	@Test
	public void testParseo() {
		
		ArticuloParser AParser =new ArticuloParser();
		
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

	
	@Test
	public void testJson1() {
		
		ArticuloParser AParser =new ArticuloParser();
		
		SolicitudArticulosParser SAParser = new SolicitudArticulosParser();
		SolicitudArticulosDTO SADTO = null;
		String xml = new String(
				"<solicitudArticulos><idSolicitud>1</idSolicitud><idModulo>2</idModulo><articulos></articulos></solicitudArticulos>");
		String json=null;
		try {
			SADTO = SAParser.toObject(xml);
			json=SAParser.toJson(SADTO);
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("{\n"
					+ "   idModulo:6,\n"
					+ "   idSolicitud:1\n"
					+ "}\n",json);
		
	}
	
	@Test
	public void testJson2() {
		
		ArticuloParser AParser =new ArticuloParser();
		
		SolicitudArticulosParser SAParser = new SolicitudArticulosParser();
		SolicitudArticulosDTO SADTO = null;
		String xml = new String(
				"<solicitudArticulos><idSolicitud>1</idSolicitud><idModulo>2</idModulo><articulos><articulo><codigo>PEPE1</codigo><cantidad>10</cantidad></articulo></articulos></solicitudArticulos>");
		String json=null;
		try {
			SADTO = SAParser.toObject(xml);
			json=SAParser.toJson(SADTO);
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("{\n"
				+ "   idModulo:6,\n"
				+ "   idSolicitud:1,\n\n"
				+ "   items: [\n"
				+ "   {codigo:PEPE1, cantidad: 10}\n"
				+ "   ]\n"
				+ "}\n",json);
		
	}
	
	@Test
	public void testJson4() {
		
		ArticuloParser AParser =new ArticuloParser();
		
		SolicitudArticulosParser SAParser = new SolicitudArticulosParser();
		SolicitudArticulosDTO SADTO = null;
		String xml = new String(
				"<solicitudArticulos><idSolicitud>1</idSolicitud><idModulo>2</idModulo><articulos><articulo><codigo>PEPE1</codigo><cantidad>10</cantidad></articulo><articulo><codigo>PEPE2</codigo><cantidad>11</cantidad></articulo></articulos></solicitudArticulos>");
		String json=null;
		try {
			SADTO = SAParser.toObject(xml);
			json=SAParser.toJson(SADTO);
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("{\n"
				+ "   idModulo:6,\n"
				+ "   idSolicitud:1,\n\n"
				+ "   items: [\n"
				+ "   {codigo:PEPE1, cantidad: 10},\n"
				+ "   {codigo:PEPE2, cantidad: 11}\n"
				+ "   ]\n"
				+ "}\n",json);
		
	}



}


