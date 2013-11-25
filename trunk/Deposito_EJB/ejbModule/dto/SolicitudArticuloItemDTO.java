package dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articulo")
public class SolicitudArticuloItemDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6973883739324145835L;

	public SolicitudArticuloItemDTO() {
		super();
	}

	String codigo;
	Integer cantidad;

	@XmlElement
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@XmlElement
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
