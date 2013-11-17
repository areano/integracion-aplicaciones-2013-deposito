package parsers;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import dto.ArticuloDTO;
import dto.MuebleDTO;
import dto.SolicitudArticuloItemDTO;
import dto.SolicitudArticulosDTO;
import entities.SolicitudArticulos;

public class SolicitudArticulosParser implements Parser<SolicitudArticulosDTO> {

	@Override
	public SolicitudArticulosDTO toObject(String data) throws ParserException {
		JAXBContext jaxbCtx;
		SolicitudArticulosDTO sa = null;

		try {
			jaxbCtx = JAXBContext.newInstance(SolicitudArticulosDTO.class);
			Unmarshaller u = jaxbCtx.createUnmarshaller();

			u.setEventHandler(new ValidationEventHandler() {
				public boolean handleEvent(ValidationEvent event) {
					throw new RuntimeException(event.getMessage(), event.getLinkedException());
				}

			});
			StringReader reader = new StringReader(data);
			sa = (SolicitudArticulosDTO) u.unmarshal(reader);
		} catch (JAXBException e) {
			// TODO AR - Log error
			e.printStackTrace();
		}

		return sa;
	}

	@Override
	public String toString(SolicitudArticulosDTO data) throws ParserException {
		// TODO Auto-generated method stub
		return null;
	}
	public String toXML(SolicitudArticulos a){
		// TODO 
		return null;
	}

	public String toJson(SolicitudArticulosDTO sa){
		String json="{\n"
				+ "   idModulo:6,\n"
				+ "   idSolicitud:"+ sa.getIdSolicitud();
		if (sa.getLista().size()>0){
			int i=1;
			int j=sa.getLista().size();
			json=json + ",\n\n   items: [\n";
			for (SolicitudArticuloItemDTO a : sa.getLista()){
				if (i<j) {
					json=json + "   {codigo:"+a.getCodigo()+", cantidad: "+a.getCantidad()+"},\n";
					i=i+1;
				} else{
					json=json + "   {codigo:"+a.getCodigo()+", cantidad: "+a.getCantidad()+"}\n";					
				}
			}
			json=json + "   ]\n}\n";
		} else { 
			json=json + "\n}\n";
		}
		
		return json;		
		
	}
	
	
}
