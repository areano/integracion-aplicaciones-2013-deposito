package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CantidadArticulos")
public class ItemSolicitudCompra {

	@Id
	@Column(name = "cantidadArticuloId")
	private int id;

	@OneToOne
	@JoinColumn(name = "codigo")
	private Articulo articulo;

	private int cantidad;

	public ItemSolicitudCompra() {
	}

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
