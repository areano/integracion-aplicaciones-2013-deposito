package parsers;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import dto.LogDTO;


public class LogParser implements Parser<LogDTO> {


	private static LogParser instancia;
	
	public static LogParser obtenerInstancia(){
		if(instancia==null)
			instancia=new LogParser();
		return instancia;
	}
	
	private LogParser(){}
	
	@Override
	public LogDTO toObject(String xml) throws ParserException {
		LogDTO dto=null;

		try {
			JAXBContext jc = JAXBContext.newInstance(LogDTO.class);
			StringReader sr= new StringReader(xml);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			dto= (LogDTO) unmarshaller.unmarshal(sr);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}

	@Override
	public String toString(LogDTO dto) throws ParserException {
      
        StringWriter sw= new StringWriter();
        String xml=null;
        
        try {
        	JAXBContext jc = JAXBContext.newInstance(LogDTO.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(dto, sw);
			xml=sw.toString();
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return xml;
        
	}


}
