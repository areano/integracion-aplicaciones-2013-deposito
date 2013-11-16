package dto;

import javax.validation.constraints.NotNull;

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


	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
}
