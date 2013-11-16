package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.InfantilDTO;
import dto.SolicitudArticulosDTO;
import entities.Articulo;
import entities.Infantil;
import entities.Mueble;
import parsers.ArticuloParser;
import parsers.ParserException;
import parsers.SolicitudArticulosParser;
import transformer.Transformer;

public class ArticulosParserTest {

	@Test
	public void testParseo() {
		ArticuloParser SAParser = new ArticuloParser();
		Infantil i= new Infantil();
		i.setCodigo(1);
		i.setDescripcion("Cthulhu Action Figure");
		i.setEdadRecomendada("666");
		i.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		i.setMarca("Hell Inc.");
		i.setNombre("Cthulhu");
		i.setOrigen("HELL");
		i.setPrecio(666.66F);
		i.setStock(666);

		InfantilDTO iDTO= new InfantilDTO();
		iDTO=Transformer.obtenerInstancia().toDTO(i);
		String s=SAParser.toXML(iDTO);
		assertEquals(s,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <codigoDeposito>6</codigoDeposito>\n"
				+ "    <descripcion>Cthulhu Action Figure</descripcion>\n"
				+ "    <fecha>"+iDTO.getFecha()+"</fecha>\n"
				+ "    <foto>http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg</foto>\n"
				+ "    <marca>Hell Inc.</marca>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "    <origen>HELL</origen>\n"
				+ "    <precio>666.66</precio>\n"
				+ "    <tipo>infantil</tipo>\n"
				+ "    <edadRecomendada>666</edadRecomendada>\n"
				+ "</articulo>\n");
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
