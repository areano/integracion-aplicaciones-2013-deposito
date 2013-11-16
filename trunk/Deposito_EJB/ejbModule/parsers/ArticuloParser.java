package parsers;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
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
		JAXBContext jaxbCtx;
		String xml = null;
		java.io.StringWriter sw = new StringWriter();
		try {
			jaxbCtx = JAXBContext.newInstance(InfantilDTO.class);
			Marshaller m = jaxbCtx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(iDTO, sw );			
			xml=sw.toString();
			
		} catch (JAXBException e) {
			// TODO AR - Log error
			e.printStackTrace();
		}


		return null;
	}
	
	public String toXML(ModaDTO mDTO) {
		// TODO MF:MuebleDTO -> xml
		return null;
	}

	public String toXML(ElectrodomesticoDTO eDTO) {
		// TODO MF:ElectrodomesticoDTO -> xml
		return null;
	}
}
