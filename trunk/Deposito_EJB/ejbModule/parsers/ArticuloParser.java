package parsers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import entities.Articulo;
import entities.Electrodomestico;

public class ArticuloParser {

	public ArticuloParser(){}
	
	public String articuloToXML(Articulo a){
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("Articulo", Articulo.class);
		xstream.alias("Electrodomestico", Electrodomestico.class);
		String xml = xstream.toXML(a);
		return xml;
	}
}
