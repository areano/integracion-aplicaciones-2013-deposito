package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import auxiliares.CantidadArticulos;

@Entity
@Table(name="SolicitudesArticulos")
public class SolicitudArticulos {
	
	@Id
	private long idSolicitud;
	private long idModulo;
	
	@OneToOne
	private CantidadArticulos articulos;

	private boolean cumplida;
	
	public SolicitudArticulos(){}

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
}
