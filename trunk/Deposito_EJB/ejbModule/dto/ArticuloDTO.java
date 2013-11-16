package dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

public abstract class ArticuloDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	@NotNull
	private String nombre;
	@NotNull
	private String fecha;
	@NotNull
	private Long codigoDeposito;
	@NotNull
	private String descripcion;
	@NotNull
	private String marca;
	@NotNull
	private Float precio;
	@NotNull
	private String origen;
	@NotNull
	private String foto;	
	private String tipo;
	public ArticuloDTO(){
	    codigo=null;
	    descripcion=null;
	    foto = null;
	    marca=null;
	    nombre=null;
	    precio=null;
	    codigoDeposito=null;
	}
	
	@XmlElement
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@XmlElement
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@XmlElement
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	@XmlElement
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	@XmlElement
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	@XmlElement
	public Long getCodigoDeposito() {
		return codigoDeposito;
	}
	
	public void setCodigoDeposito(Long codigoDeposito) {
		this.codigoDeposito = codigoDeposito;
	}
	
	@XmlElement
	public String getFecha(){
		return fecha;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	
	@XmlElement
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
