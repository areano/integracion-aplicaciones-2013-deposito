package parsers;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import dto.SolicitudCompraDTO;


public class SolicitudCompraXMLParser implements Parser<SolicitudCompraDTO> {

	private static SolicitudCompraXMLParser instancia;
	
	public static SolicitudCompraXMLParser obtenerInstancia(){
		if(instancia==null)
			instancia=new SolicitudCompraXMLParser();
		return instancia;
	}
	
	private SolicitudCompraXMLParser(){}
	
	@Override
	public SolicitudCompraDTO toObject(String json) throws ParserException {
		SolicitudCompraDTO dto=null;

		try {
			JAXBContext jc = JAXBContext.newInstance(SolicitudCompraDTO.class);
			StringReader sr= new StringReader(json);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			dto= (SolicitudCompraDTO) unmarshaller.unmarshal(sr);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}

	@Override
	public String toString(SolicitudCompraDTO dto) throws ParserException {
      
        StringWriter sw= new StringWriter();
        String json=null;
        
        try {
        	JAXBContext jc = JAXBContext.newInstance(SolicitudCompraDTO.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(dto, sw);
			json=sw.toString();
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return json;
        
	}
   
		}


