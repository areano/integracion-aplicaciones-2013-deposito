package dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articulo")
public class ItemSolicitudCompraDTO {
	
	public ItemSolicitudCompraDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemSolicitudCompraDTO(Long codArticulo, String nomArticulo, int cantidad) {
		super();
		this.codArticulo = codArticulo;
		this.nomArticulo = nomArticulo;
		this.cantidad = cantidad;
	}
	private Long codArticulo;
	@NotNull
	private String nomArticulo;
	@NotNull
	private int cantidad;
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Long getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(Long codArticulo) {
		this.codArticulo = codArticulo;
	}
	
	public String getNomArticulo() {
		return nomArticulo;
	}
	public void setNomArticulo(String nomArticulo) {
		this.nomArticulo = nomArticulo;
	}
	
}
