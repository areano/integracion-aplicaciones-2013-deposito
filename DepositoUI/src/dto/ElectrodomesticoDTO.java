package dto;

import javax.validation.constraints.NotNull;

public class ElectrodomesticoDTO extends ArticuloDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4674360310404545979L;
	@NotNull
	private String fichaTecnica;
	
	public ElectrodomesticoDTO(){
		super();
		fichaTecnica = null;
		setTipo("electrodomestico");
		
		
	}
	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
}
