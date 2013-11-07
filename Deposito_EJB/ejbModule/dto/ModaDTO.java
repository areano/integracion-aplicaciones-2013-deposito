package dto;

import javax.validation.constraints.NotNull;

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
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
}
