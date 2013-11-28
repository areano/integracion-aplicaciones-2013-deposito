package view;

import javax.validation.constraints.NotNull;

public class MuebleView extends ArticuloView{
	

	private static final long serialVersionUID = 1L;
	@NotNull
	private String material;
	
	public MuebleView(){
		super();
		material = null;
		setTipo("mueble");
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String getFichaTecnica() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTalle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEdadRecomendada() {
		// TODO Auto-generated method stub
		return null;
	}
}
