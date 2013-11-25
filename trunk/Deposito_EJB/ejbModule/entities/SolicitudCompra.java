package entities;

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
@Table(name = "SolicitudCompra")
public class SolicitudCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "codigoSolicitud")
	private List<ItemSolicitudCompra> articulos;

	private boolean completada;

	private Date fechaInicio;

	private Date fechaFin;

	public SolicitudCompra() {
		articulos = new ArrayList<ItemSolicitudCompra>();
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<ItemSolicitudCompra> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ItemSolicitudCompra> articulos) {
		this.articulos = articulos;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
