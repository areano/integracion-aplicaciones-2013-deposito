package ar.com.uade.fabricaejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FabricaSolicitudCompra")
public class SolicitudCompra implements Serializable {

	public static final String PENDIENTE = "Pendiente";
	public static final String COMPLETA = "Completa";

	public SolicitudCompra() {
	}

	private static final long serialVersionUID = 5903574767372141171L;

	@Id
	@Column(name = "solicitudCompraId")
	private long codigo;

	private Date fechaInicio = new Date();

	private Date fechaFin;

	private String estado = PENDIENTE;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(referencedColumnName = "solicitudCompraId")
	private List<ItemSolicitudCompra> itemArticulos = new ArrayList<ItemSolicitudCompra>();;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<ItemSolicitudCompra> getItemArticulos() {
		return itemArticulos;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
		this.fechaFin = null;

		if (estado == COMPLETA) {
			fechaFin = new Date();
		}
	}
}
