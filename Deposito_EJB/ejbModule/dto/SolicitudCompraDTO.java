package dto;

import java.util.Date;
import java.util.List;

public class SolicitudCompraDTO {

	private long codigo;
	private List<ItemSolicitudCompraDTO> articulos;
	private Date fechaInicio;
	private Date fechaFin;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public List<ItemSolicitudCompraDTO> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<ItemSolicitudCompraDTO> articulos) {
		this.articulos = articulos;
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
