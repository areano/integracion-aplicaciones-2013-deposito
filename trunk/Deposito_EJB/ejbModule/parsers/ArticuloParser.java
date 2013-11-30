package parsers;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import excepctions.BackEndException;

public class ArticuloParser {
	private static final Logger logger = Logger.getLogger(ArticuloParser.class);
	public ArticuloParser(){}
	
	public String toXML(MuebleDTO mDTO) throws BackEndException {
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
			logger.error("Error Parseando Mueble DTO a XML",e);
			throw new BackEndException(e);
		}
		xml=xml.replaceAll("codigoDeposito>", "idModulo>");
		xml=xml.replaceAll("<fotoURL>", "<fotoURL>http://");
		return xml;
	}
	
	public String toXML(InfantilDTO iDTO) throws BackEndException {
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
		
			e.printStackTrace();
			logger.error("Error Parseando Infantil DTO a XML",e);
			throw new BackEndException(e);
		}
		xml=xml.replaceAll("codigoDeposito>", "idModulo>");
		xml=xml.replaceAll("<fotoURL>", "<fotoURL>http://");
		return xml;
	}
	
	public String toXML(ModaDTO mDTO) throws BackEndException {
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
			e.printStackTrace();
			logger.error("Error Parseando Moda DTO a XML",e);
			throw new BackEndException(e);
		}
		xml=xml.replaceAll("codigoDeposito>", "idModulo>");
		xml=xml.replaceAll("<fotoURL>", "<fotoURL>http://");
		return xml;		
	}

	public String toXML(ElectrodomesticoDTO eDTO) throws BackEndException {
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
			e.printStackTrace();
			logger.error("Error Parseando Electrodomestico DTO a XML",e);
			throw new BackEndException(e);
		}
		xml=xml.replaceAll("codigoDeposito>", "idModulo>");
		xml=xml.replaceAll("<fotoURL>", "<fotoURL>http://");
		return xml;		
	}

	public String toXMLSmall(MuebleDTO mDTO) throws BackEndException {
		String xml = toXML(mDTO);
		xml=shrinkXML(xml);
		return xml;
	}
	
	public String toXMLSmall(InfantilDTO iDTO) throws BackEndException {
		String xml=toXML(iDTO);
		xml=shrinkXML(xml);
		return xml;
	}
	
	public String toXMLSmall(ModaDTO mDTO) throws BackEndException {
		String xml=toXML(mDTO);
		xml=shrinkXML(xml);
		return xml;		
	}

	public String toXMLSmall(ElectrodomesticoDTO eDTO) throws BackEndException {
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
