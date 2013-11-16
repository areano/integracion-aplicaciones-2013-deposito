package parsers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
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

	public String toXML(MuebleDTO mDTO) {
		// TODO MF:MuebleDTO-> xml
		return null;
	}
	
	public String toXML(InfantilDTO iDTO) {
		// TODO MF:MuebleDTO -> xml
		return null;
	}
	
	public String toXML(ModaDTO mDTO) {
		// TODO MF:MuebleDTO -> xml
		return null;
	}
}
