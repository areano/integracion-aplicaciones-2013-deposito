package dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articulo")
public class InfantilDTO extends ArticuloDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8079686246371671720L;
	@NotNull
	private String edadRecomendada;
	
	public InfantilDTO(){
		super();
		edadRecomendada = null;
		setTipo("infantil");
	}

	@XmlElement
	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
}
