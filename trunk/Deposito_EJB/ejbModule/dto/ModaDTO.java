package dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articulo")
public class ModaDTO extends ArticuloDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2987887305063852144L;
	@NotNull
	private String color;
	@NotNull
	private String talle;
	
	public ModaDTO(){
		super();
		talle = null;
		color= null;
		setTipo("moda");
	}

	@XmlElement
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@XmlElement
	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
}
