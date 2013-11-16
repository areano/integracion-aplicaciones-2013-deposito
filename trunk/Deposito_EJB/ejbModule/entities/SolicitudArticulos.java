package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SolicitudArticulos")
public class SolicitudArticulos {

	@Id
	@Column(name = "solicitudArticulosId")
	private long solicitudId;

	private long moduloId;

	@OneToMany()
	@JoinColumn(referencedColumnName = "solicitudArticulosId")
	private List<SolicitudArticulosItem> items = new ArrayList<SolicitudArticulosItem>();

	private boolean cumplida;

	private Calendar fechaInicio;

	private Calendar fechaFin;

	public List<SolicitudArticulosItem> getItems() {
		return items;
	}

	public SolicitudArticulos() {
	}

	public long getSolicitudId() {
		return solicitudId;
	}

	public long getModuloId() {
		return moduloId;
	}

	public void setModuloId(long idModulo) {
		this.moduloId = idModulo;
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

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
}
