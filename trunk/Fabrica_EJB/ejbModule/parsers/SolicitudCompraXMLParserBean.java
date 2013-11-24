package parsers;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

import dto.SolicitudCompraDTO;

@LocalBean
@Stateless
public class SolicitudCompraXMLParserBean implements Parser<SolicitudCompraDTO> {

	@Override
	public SolicitudCompraDTO toObject(String json) throws ParserException {
		SolicitudCompraDTO dto=null;
		Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
		try {
			JAXBContext jc = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[] {SolicitudCompraDTO.class}, properties);
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
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        StringWriter sw= new StringWriter();
        String json=null;
        
        try {
			JAXBContext jc = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[] {SolicitudCompraDTO.class}, properties);
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


