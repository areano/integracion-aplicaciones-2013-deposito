package entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SolicitudesCompra")
public class SolicitudCompra {

	@Id
	private long codigo;

	@OneToMany
	@JoinColumn(name = "cantidadArticuloId")
	private List<CantidadArticulos> articulos;

	private boolean completada;

	private Calendar fechaInicio;

	private Calendar fechaFin;

	public SolicitudCompra() {
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<CantidadArticulos> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<CantidadArticulos> articulos) {
		this.articulos = articulos;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
}
