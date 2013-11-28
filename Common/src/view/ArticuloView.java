package view;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public abstract class ArticuloView implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotNull
	private Long codigo;
	@NotNull
	private String nombre;
	private Long codigoDeposito;
	@NotNull
	private String descripcion;
	@NotNull
	private String marca;
	@Min(value=0)
	private Float precio;
	@NotNull
	private String origen;
	@NotNull
	private String foto;
	@Min (value=0)
	private Long stock;
	private String tipo;
	@Min (value=0)
	private Number textPrecio;
	@NotNull
	private Number textCodigo;
	@Min (value = 0)
	private Number textStock;

	public ArticuloView(){
	    codigo=null;
	    descripcion=null;
	    foto = null;
	    marca=null;
	    nombre=null;
	    precio=(float) 0;
	    origen =null;
	    codigoDeposito=Long.valueOf(6);
	    stock = 0L;
	    textCodigo = null;
	    textPrecio = null;
	    textStock = 0;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
		textCodigo = codigo;
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
		textPrecio = precio;
	
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
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
		textStock =  stock;
	}
	public abstract String getFichaTecnica();
	public abstract String getColor() ;
	public abstract String getTalle() ;
	public abstract String getMaterial() ;
	public abstract String getEdadRecomendada() ;
	public Number getTextPrecio() {
		return textPrecio;
	}
	public void setTextPrecio(Number textPrecio) {
		this.textPrecio = textPrecio;
		precio = textPrecio.floatValue();
	}
	public Number getTextCodigo() {
		return textCodigo;
	}
	public void setTextCodigo(Number textCodigo) {
		this.textCodigo = textCodigo;
		codigo =  textCodigo.longValue();
	}
	public Number getTextStock() {
		return textStock;
	}
	public void setTextStock(Number textStock) {
		this.textStock = textStock;
		stock =  textStock.longValue();
	}
	public String toString(){
		return "Art.: "+codigo+" - "+tipo+" - "+marca+" "+ nombre;
	}
}
