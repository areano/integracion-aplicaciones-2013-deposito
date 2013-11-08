package dto;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "solicitudArticulos")
public class SolicitudArticulosDTO {
	
	public SolicitudArticulosDTO() {
		super();
	}

	List<SolicitudArticuloItemDTO> lista;
	Integer idSolicitud;
	Integer idModulo;
	

	@XmlElement
	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	@XmlElement
	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	@XmlElementWrapper(name="articulos")
	@XmlElement(name = "articulo")
	public List<SolicitudArticuloItemDTO> getLista() {
		return lista;
	}

	public void setLista(List<SolicitudArticuloItemDTO> lista) {
		this.lista = lista;
	}

}




