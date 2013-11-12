package entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import auxiliares.CantidadArticulos;

@Entity
@Table(name = "SolicitudesArticulos")
public class SolicitudArticulos {

	@Id
	private long idSolicitud;
	private long idModulo;

	@OneToOne
	@JoinColumn(name = "cantidadArticuloId")
	private CantidadArticulos articulos;

	private boolean cumplida;

	private Calendar fechaInicio;

	private Calendar fechaFin;

	public SolicitudArticulos() {
	}

	public long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(long idModulo) {
		this.idModulo = idModulo;
	}

	public CantidadArticulos getArticulos() {
		return articulos;
	}

	public void setArticulos(CantidadArticulos articulos) {
		this.articulos = articulos;
	}

	public boolean isCumplida() {
		return cumplida;
	}

	public void setCumplida(boolean cumplida) {
		this.cumplida = cumplida;
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
