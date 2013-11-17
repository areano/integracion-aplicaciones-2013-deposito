package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import parsers.ParserException;
import parsers.SolicitudCompraParser;
import dto.ItemSolicitudCompraDTO;
import dto.SolicitudCompraDTO;

public class SolicitudCompraParserTest {

	private String json;
	private Date fechaInicio;
	SolicitudCompraDTO dto;
	
	@Before
	public void beforeTest(){
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		fechaInicio= new Date();

		json="{\n \"solicitudCompra\" : {\n \"articulos\" : {\n \"articulo\" : [ {\n \"cantidad\" : 11,\n \"codArticulo\" : 1,\n \"nomArticulo\" : \"Articulo1\"\n }, {\n \"cantidad\" : 22,\n \"codArticulo\" : 2,\n \"nomArticulo\" : \"Articulo2\"\n } ]\n },\n \"codigo\" : 1,\n \"fechaInicio\" : \""+formatoDelTexto.format(fechaInicio)+"\"\n }\n}\n";
		dto= new SolicitudCompraDTO();
		dto.setCodigo(1);
		dto.getArticulos().add(new ItemSolicitudCompraDTO(1L, "Articulo1", 11));
		dto.getArticulos().add(new ItemSolicitudCompraDTO(2L, "Articulo2", 22));
		dto.setFechaInicio(fechaInicio);
	}
	@Test
	public void testToObject() {
		SolicitudCompraParser p= new SolicitudCompraParser();
		SolicitudCompraDTO dto2 = null;
		try {
			dto2 = p.toObject(json);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(dto2.getCodigo(), dto.getCodigo());
		assertEquals(dto2.getFechaInicio(), dto.getFechaInicio());
		assertEquals(dto2.getFechaFin(), dto.getFechaFin());
		int index=0;
		for (ItemSolicitudCompraDTO iDto : dto.getArticulos()){
			assertEquals(dto2.getArticulos().get(index).getCantidad(), iDto.getCantidad() );
			assertEquals(dto2.getArticulos().get(index).getNomArticulo(), iDto.getNomArticulo() );
			assertEquals(dto2.getArticulos().get(index).getCodArticulo(), iDto.getCodArticulo() );
			index++;
		}
	}

	@Test
	public void testToStringSolicitudCompraDTO() {

		SolicitudCompraDTO dto2=null;
		SolicitudCompraParser p= new SolicitudCompraParser();
		String json2=null;
		
		try {
			json2= p.toString(dto);
			
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(json.replaceAll("\\s+",""),json2.replaceAll("\\s+",""));
		
	}

	
	@Test
	public void testIdaYVuelta() {
		SolicitudCompraDTO dto= new SolicitudCompraDTO();
		SolicitudCompraDTO dto2=null;
		SolicitudCompraParser p= new SolicitudCompraParser();
		dto.setCodigo(1);
		dto.getArticulos().add(new ItemSolicitudCompraDTO(1L, "Articulo1", 11));
		dto.getArticulos().add(new ItemSolicitudCompraDTO(2L, "Articulo2", 22));
		dto.setFechaInicio(new java.util.Date());
		String json=null;
		
		try {
			json= p.toString(dto);
			dto2=p.toObject(json);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(dto2.getCodigo(), dto.getCodigo());
		assertEquals(dto2.getFechaInicio(), dto.getFechaInicio());
		assertEquals(dto2.getFechaFin(), dto.getFechaFin());
		int index=0;
		for (ItemSolicitudCompraDTO iDto : dto.getArticulos()){
			assertEquals(dto2.getArticulos().get(index).getCantidad(), iDto.getCantidad() );
			assertEquals(dto2.getArticulos().get(index).getNomArticulo(), iDto.getNomArticulo() );
			assertEquals(dto2.getArticulos().get(index).getCodArticulo(), iDto.getCodArticulo() );
			index++;
		}
	}

	
}
