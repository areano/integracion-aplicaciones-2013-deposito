/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import parsers.LogParser;
import parsers.ParserException;
import dto.ItemSolicitudCompraDTO;
import dto.LogDTO;
import dto.SolicitudCompraDTO;

/**
 * @author Martin
 *
 */
public class LogParserTest {

	/**
	 * Test method for {@link parsers.LogParser#toObject(java.lang.String)}.
	 */
	String mensaje;
	int idModulo;
	String fecha;
	
	@Before
	public void beforeTest(){
		fecha=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		idModulo=6;
		mensaje="Este es un mensaje de test, bla bla bla";
	}
	
	@Test
	public void testToObject() {
		String xml="<log>\n"+
				"<fecha>"+fecha+"</fecha>\n"+
				"<idModulo>"+idModulo+"</idModulo>\n" +
				"<mensaje>"+mensaje+"</mensaje>\n" +
				"</log>";
		LogDTO dto=null;
		try {
			dto=LogParser.obtenerInstancia().toObject(xml);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(fecha,dto.getFecha());
		assertEquals(idModulo,dto.getIdModulo());
		assertEquals(mensaje,dto.getMensaje());
	
	}

	/**
	 * Test method for {@link parsers.LogParser#toString(dto.LogDTO)}.
	 */
	@Test
	public void testToStringLogDTO() {
		LogDTO dto=new LogDTO(mensaje);
		fecha=dto.getFecha();
		idModulo=dto.getIdModulo();
		
		String xml="<log>\n"+
				"<fecha>"+fecha+"</fecha>\n"+
				"<idModulo>"+idModulo+"</idModulo>\n" +
				"<mensaje>"+mensaje+"</mensaje>\n" +
				"</log>";
		String xml2 = null;
		try {
			xml2 = LogParser.obtenerInstancia().toString(dto);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(xml, xml2);
		
	}

}
