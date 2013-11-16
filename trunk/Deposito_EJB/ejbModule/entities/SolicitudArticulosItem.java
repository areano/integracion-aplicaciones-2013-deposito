package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SolicitudArticulosItem")
public class SolicitudArticulosItem {

	@Id
	@Column(name = "solicitudArticulosItemId")
	private int id;

	@ManyToOne
	@JoinColumn(name = "codigo")
	private Articulo articulo;

	private int cantidad;

	public int getId() {
		return id;
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
