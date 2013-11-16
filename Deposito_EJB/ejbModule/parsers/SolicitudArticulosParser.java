package parsers;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import dto.SolicitudArticulosDTO;

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

}
