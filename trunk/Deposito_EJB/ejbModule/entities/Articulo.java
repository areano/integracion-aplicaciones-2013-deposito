package entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="articulos")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
public class Articulo {
	
	@Id
	private int codigo;
	private int codigoDeposito;
	private String descripcion;
	private String marca;
	private String nombre;
	private float precio;
	
	/*
	 * Falta definir el tema de la imagen.
	 * No la agregue como tipo de dato ya que 
	 * no la vamos a guardar en la base de datos.
	 * */
	
	public Articulo(){}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoDeposito() {
		return codigoDeposito;
	}

	public void setCodigoDeposito(int codigoDeposito) {
		this.codigoDeposito = codigoDeposito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
