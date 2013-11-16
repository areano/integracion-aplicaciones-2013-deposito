package parsers;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;

public class ArticuloParser {

	public ArticuloParser(){}
	
	public String toXML(MuebleDTO mDTO) {
		JAXBContext jaxbCtx;
		String xml = null;
		java.io.StringWriter sw = new StringWriter();
		try {
			jaxbCtx = JAXBContext.newInstance(MuebleDTO.class);
			Marshaller m = jaxbCtx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(mDTO, sw );			
			xml=sw.toString();
			
		} catch (JAXBException e) {
			// TODO AR - Log error
			e.printStackTrace();
		}
		return xml;
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
		return xml;
	}
	
	public String toXML(ModaDTO mDTO) {
		JAXBContext jaxbCtx;
		String xml = null;
		java.io.StringWriter sw = new StringWriter();
		try {
			jaxbCtx = JAXBContext.newInstance(ModaDTO.class);
			Marshaller m = jaxbCtx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(mDTO, sw );			
			xml=sw.toString();
			
		} catch (JAXBException e) {
			// TODO AR - Log error
			e.printStackTrace();
		}
		return xml;		
	}

	public String toXML(ElectrodomesticoDTO eDTO) {
		JAXBContext jaxbCtx;
		String xml = null;
		java.io.StringWriter sw = new StringWriter();
		try {
			jaxbCtx = JAXBContext.newInstance(ElectrodomesticoDTO.class);
			Marshaller m = jaxbCtx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(eDTO, sw );			
			xml=sw.toString();
			
		} catch (JAXBException e) {
			// TODO AR - Log error
			e.printStackTrace();
		}
		return xml;		
	}

	public String toXMLSmall(MuebleDTO mDTO) {
		String xml = toXML(mDTO);
		xml=shrinkXML(xml);
		return xml;
	}
	
	public String toXMLSmall(InfantilDTO iDTO) {
		String xml=toXML(iDTO);
		xml=shrinkXML(xml);
		return xml;
	}
	
	public String toXMLSmall(ModaDTO mDTO) {
		String xml=toXML(mDTO);
		xml=shrinkXML(xml);
		return xml;		
	}

	public String toXMLSmall(ElectrodomesticoDTO eDTO) {
		String xml=toXML(eDTO);
		xml=shrinkXML(xml);
		return xml;		
	}

	private String shrinkXML ( String xml){
		xml=xml.replaceAll("<\\?.*\\?>\n","");
		xml=xml.replaceAll("codigoDeposito>", "idModulo>");
		xml=xml.replaceAll("    <descripcion.*descripcion>\n", "");
		xml=xml.replaceAll("    <marca.*marca>\n", "");
		xml=xml.replaceAll("    <origen.*origen>\n", "");
		xml=xml.replaceAll("    <precio.*precio>\n", "");
		xml=xml.replaceAll("    <fecha.*fecha>\n", "");
		xml=xml.replaceAll("    <tipo.*tipo>\n", "");
		xml=xml.replaceAll("    <fotoURL.*fotoURL>\n", "");
		xml=xml.replaceAll("    <color.*color>\n", "");
		xml=xml.replaceAll("    <edadRecomendada.*edadRecomendada>\n", "");
		xml=xml.replaceAll("    <fichaTecnica.*fichaTecnica>\n", "");
		xml=xml.replaceAll("    <edadRecomendada.*edadRecomendada>\n", "");
		xml=xml.replaceAll("    <talle.*talle>\n", "");
		xml=xml.replaceAll("    <material.*material>\n", "");
		return xml;
	}
}
