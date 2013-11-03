package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="electrodomestico")
public class Electrodomestico extends Articulo {

	private String fichaTecnica;
	
	public Electrodomestico(){
		super();
	}
	
	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
}
