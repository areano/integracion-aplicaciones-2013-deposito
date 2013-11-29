package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SolicitudCompraItem")
public class ItemSolicitudCompra {

	public ItemSolicitudCompra(long id, Articulo articulo, int cantidad) {
		super();
		this.id = id;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	@Id
	@Column(name = "solicitudCompraItemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "codigoArticulo")
	private Articulo articulo;

	private int cantidad;

	@Transient
	private int cantidadSolicitada;

	public ItemSolicitudCompra() {
	}

	public long getId() {
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

	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
}
