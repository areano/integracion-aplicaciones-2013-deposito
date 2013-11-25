package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FabricaSolicitudCompraItem")
public class ItemSolicitudCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2100742387455993471L;

	public ItemSolicitudCompra() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fabricaSolicitudCompraItemId")
	private int id;

	private int cantidad;
	private Long codArticulo;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setCodArticulo(Long codArticulo) {
		this.codArticulo = codArticulo;
	}

	public Long getCodArticulo() {
		return codArticulo;
	}

}
