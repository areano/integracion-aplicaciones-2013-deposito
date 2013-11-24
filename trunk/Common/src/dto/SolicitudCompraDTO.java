package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "solicitudCompra")
public class SolicitudCompraDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5903574767372141171L;


	public SolicitudCompraDTO() {
		super();
		articulos = new ArrayList<ItemSolicitudCompraDTO>();
	}
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
	
	@XmlElementWrapper(name = "articulos")
	@XmlElement(name = "articulo")
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
