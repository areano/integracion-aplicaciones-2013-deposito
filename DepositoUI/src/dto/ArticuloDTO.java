package dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public abstract class ArticuloDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	@NotNull
	private String nombre;
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
	private Integer stock;
	private String tipo;
	public ArticuloDTO(){
	    codigo=null;
	    descripcion=null;
	    foto = null;
	    marca=null;
	    nombre=null;
	    precio=null;
	    codigoDeposito=Long.valueOf(6);
	    stock = 0;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public Long getCodigoDeposito() {
		return codigoDeposito;
	}
	
	public void setCodigoDeposito(Long codigoDeposito) {
		this.codigoDeposito = codigoDeposito;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
