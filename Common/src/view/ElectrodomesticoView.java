package view;

import javax.validation.constraints.NotNull;



public class ElectrodomesticoView extends ArticuloView{

	private static final long serialVersionUID = 1L;
	@NotNull
	private String fichaTecnica;
	
	public ElectrodomesticoView(){
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
