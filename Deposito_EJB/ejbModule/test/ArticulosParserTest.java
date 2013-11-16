package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.SolicitudArticulosDTO;
import entities.Articulo;
import entities.Mueble;
import parsers.ArticuloParser;
import parsers.ParserException;
import parsers.SolicitudArticulosParser;

public class ArticulosParserTest {

	@Test
	public void testParseo() {
		ArticuloParser SAParser = new ArticuloParser();
		Articulo a= new Mueble();
		String s=SAParser.articuloToXML(a);

		System.out.println(s);

	}
	
//	<?xml version="1.0" encoding="UTF-8"?>
//	<articulo>
//	   <codigo>int</codigo>
//	   <codigoDeposito>int</codigoDeposito>
//	   <nombre>String</nombre>
//	   <descripcion>String</descripcion>
//	   <marca>String</marca>
//	   <origen>String</origen>
//	   <precio>float</precio>
//	   <tipo>String</tipo>
//	   <fecha>String</fecha>
//	   <!--Formato: yyyy-MM-dd hh:mm:ss -->
//	   <fotoURL>String</fotoURL>
//	   <!--URL de la Imagen -->
//	   <color>String</color>
//	   <!--Dependiendo del tipo de articulo va vacio -->
//	   <edadRecomendada>String</edadRecomendada>
//	   <!--Dependiendo del tipo de articulo va vacio -->
//	   <fichaTecnica>String</fichaTecnica>
//	   <!--Dependiendo del tipo de articulo va vacio -->
//	   <talle>String</talle>
//	   <!--Dependiendo del tipo de articulo va vacio -->
//	   <material>String</material>
//	   <!--Dependiendo del tipo de articulo va vacio -->
//	</articulo>
	

}
