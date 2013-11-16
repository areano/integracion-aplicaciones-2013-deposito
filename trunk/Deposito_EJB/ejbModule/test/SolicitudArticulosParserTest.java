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

}

//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//<articulo>
//	<codigo>int</codigo>
//	<codigoDeposito>int</codigoDeposito>
//	<nombre>String</nombre>
//	<descripcion>String</descripcion>
//	<marca>String</marca>     
//	<origen>String</origen>
//	<precio>float</precio> 
//	<tipo>String</tipo>
//	<fecha>String</fecha><!--Formato: yyyy-MM-dd hh:mm:ss -->
//	<fotoURL>String</fotoURL><!--URL de la Imagen -->
//	<color>String</color><!--Dependiendo del tipo de articulo va vacio --> 
//	<edadRecomendada>String</edadRecomendada><!--Dependiendo del tipo de articulo va vacio -->
//	<fichaTecnica>String</fichaTecnica><!--Dependiendo del tipo de articulo va vacio -->
//	<talle>String</talle><!--Dependiendo del tipo de articulo va vacio -->
//	<material>String</material><!--Dependiendo del tipo de articulo va vacio --> 
//</articulo>

