package view;

import javax.validation.constraints.NotNull;



public class ModaView extends ArticuloView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2987887305063852144L;
	@NotNull
	private String color;
	@NotNull
	private String talle;
	
	public ModaView(){
		super();
		talle = null;
		color= null;
		setTipo("moda");
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

	@Override
	public String getFichaTecnica() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEdadRecomendada() {
		// TODO Auto-generated method stub
		return null;
	}
}
