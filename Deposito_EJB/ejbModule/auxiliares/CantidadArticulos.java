package auxiliares;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entities.Articulo;

@Entity
@Table(name="CantidadArticulos")
public class CantidadArticulos {
	
	@Id
	private int id;
	
	@OneToOne
	private Articulo articulo;
	private int cantidad;
	
	public CantidadArticulos(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
