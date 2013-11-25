package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;
import parsers.ArticuloParser;
import transformer.Transformer;

public class ArticulosParserTest {

	@Test
	public void testInfantilToXML() {
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
		iDTO=new Transformer().toDTO(i);
		String s=SAParser.toXML(iDTO);
		assertEquals(s,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <codigoDeposito>6</codigoDeposito>\n"
				+ "    <descripcion>Cthulhu Action Figure</descripcion>\n"
				+ "    <fecha>"+iDTO.getFecha()+"</fecha>\n"
				+ "    <fotoURL>http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg</fotoURL>\n"
				+ "    <marca>Hell Inc.</marca>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "    <origen>HELL</origen>\n"
				+ "    <precio>666.66</precio>\n"
				+ "    <tipo>infantil</tipo>\n"
				+ "    <edadRecomendada>666</edadRecomendada>\n"
				+ "</articulo>\n");
	}
	
	@Test
	public void testInfantilToXMLSmall() {
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
		iDTO=new Transformer().toDTO(i);
		String s=SAParser.toXMLSmall(iDTO);
		assertEquals(s,"<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <idModulo>6</idModulo>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "</articulo>\n");
	}
	@Test
	public void testElectrodomesticoToXML() {
		ArticuloParser SAParser = new ArticuloParser();
		Electrodomestico e= new Electrodomestico();
		e.setCodigo(2);
		e.setDescripcion("Cthulhu Robot");
		e.setFichaTecnica("Bocha de lucecitas");
		e.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		e.setMarca("Hell Inc.");
		e.setNombre("Cthulhu");
		e.setOrigen("HELL");
		e.setPrecio(6666.66F);
		e.setStock(6);

		ElectrodomesticoDTO eDTO= new ElectrodomesticoDTO();
		eDTO=new Transformer().toDTO(e);
		String s=SAParser.toXML(eDTO);
		assertEquals(s,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<articulo>\n"
				+ "    <codigo>2</codigo>\n"
				+ "    <codigoDeposito>6</codigoDeposito>\n"
				+ "    <descripcion>Cthulhu Robot</descripcion>\n"
				+ "    <fecha>"+eDTO.getFecha()+"</fecha>\n"
				+ "    <fotoURL>http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg</fotoURL>\n"
				+ "    <marca>Hell Inc.</marca>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "    <origen>HELL</origen>\n"
				+ "    <precio>6666.66</precio>\n"
				+ "    <tipo>electrodomestico</tipo>\n"
				+ "    <fichaTecnica>Bocha de lucecitas</fichaTecnica>\n"
				+ "</articulo>\n");
	}


	@Test
	public void testElectrodomesticoToXMLSmall() {
		ArticuloParser SAParser = new ArticuloParser();
		Electrodomestico e= new Electrodomestico();
		e.setCodigo(2);
		e.setDescripcion("Cthulhu Robot");
		e.setFichaTecnica("Bocha de lucecitas");
		e.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		e.setMarca("Hell Inc.");
		e.setNombre("Cthulhu");
		e.setOrigen("HELL");
		e.setPrecio(6666.66F);
		e.setStock(6);

		ElectrodomesticoDTO eDTO= new ElectrodomesticoDTO();
		eDTO=new Transformer().toDTO(e);
		String s=SAParser.toXMLSmall(eDTO);
		assertEquals(s,"<articulo>\n"
				+ "    <codigo>2</codigo>\n"
				+ "    <idModulo>6</idModulo>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "</articulo>\n");
	}


	@Test
	public void testMuebleToXML() {
		ArticuloParser SAParser = new ArticuloParser();
		Mueble m= new Mueble();
		m.setCodigo(1);
		m.setDescripcion("Cthulhu Chair");
		m.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		m.setMarca("Hell Inc.");
		m.setNombre("Cthulhu");
		m.setOrigen("HELL");
		m.setPrecio(6666.66F);
		m.setStock(6666);
		m.setMaterial("Human Bones");

		MuebleDTO iDTO= new MuebleDTO();
		iDTO=new Transformer().toDTO(m);
		String s=SAParser.toXML(iDTO);
		assertEquals(s,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <codigoDeposito>6</codigoDeposito>\n"
				+ "    <descripcion>Cthulhu Chair</descripcion>\n"
				+ "    <fecha>"+iDTO.getFecha()+"</fecha>\n"
				+ "    <fotoURL>http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg</fotoURL>\n"
				+ "    <marca>Hell Inc.</marca>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "    <origen>HELL</origen>\n"
				+ "    <precio>6666.66</precio>\n"
				+ "    <tipo>mueble</tipo>\n"
				+ "    <material>Human Bones</material>\n"
				+ "</articulo>\n");
	}

	@Test
	public void testMuebleToXMLSmall() {
		ArticuloParser SAParser = new ArticuloParser();
		Mueble m= new Mueble();
		m.setCodigo(1);
		m.setDescripcion("Cthulhu Chair");
		m.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		m.setMarca("Hell Inc.");
		m.setNombre("Cthulhu");
		m.setOrigen("HELL");
		m.setPrecio(6666.66F);
		m.setStock(6666);
		m.setMaterial("Human Bones");

		MuebleDTO iDTO= new MuebleDTO();
		iDTO=new Transformer().toDTO(m);
		String s=SAParser.toXMLSmall(iDTO);
		assertEquals(s,"<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <idModulo>6</idModulo>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "</articulo>\n");
	}
	
	@Test
	public void testModaToXML() {
		ArticuloParser SAParser = new ArticuloParser();
		Moda m= new Moda();
		m.setCodigo(1);
		m.setDescripcion("Cthulhu Jacket");
		m.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		m.setMarca("Hell Inc.");
		m.setNombre("Cthulhu");
		m.setOrigen("HELL");
		m.setPrecio(666F);
		m.setStock(66);
		m.setColor("Verde Moho");
		
		ModaDTO mDTO= new ModaDTO();
		mDTO=new Transformer().toDTO(m);
		String s=SAParser.toXML(mDTO);
		assertEquals(s,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <codigoDeposito>6</codigoDeposito>\n"
				+ "    <descripcion>Cthulhu Jacket</descripcion>\n"
				+ "    <fecha>"+mDTO.getFecha()+"</fecha>\n"
				+ "    <fotoURL>http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg</fotoURL>\n"
				+ "    <marca>Hell Inc.</marca>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "    <origen>HELL</origen>\n"
				+ "    <precio>666.0</precio>\n"
				+ "    <tipo>moda</tipo>\n"
				+ "    <color>Verde Moho</color>\n"
				+ "</articulo>\n");
	}


	@Test
	public void testModaToXMLSmall() {
		ArticuloParser SAParser = new ArticuloParser();
		Moda m= new Moda();
		m.setCodigo(1);
		m.setDescripcion("Cthulhu Jacket");
		m.setFoto("http://2.bp.blogspot.com/_qVXhZGcRcIA/TOwcBaEiiiI/AAAAAAAAAGo/QSizgG6VLiE/s1600/cthulhu02.jpg");
		m.setMarca("Hell Inc.");
		m.setNombre("Cthulhu");
		m.setOrigen("HELL");
		m.setPrecio(666F);
		m.setStock(66);
		m.setColor("Verde Moho");
		
		ModaDTO mDTO= new ModaDTO();
		mDTO=new Transformer().toDTO(m);
		String s=SAParser.toXMLSmall(mDTO);
		assertEquals(s,"<articulo>\n"
				+ "    <codigo>1</codigo>\n"
				+ "    <idModulo>6</idModulo>\n"
				+ "    <nombre>Cthulhu</nombre>\n"
				+ "</articulo>\n");
	}

}
