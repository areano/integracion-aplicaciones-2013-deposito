package view;

import java.io.Serializable;



public class SolicitudArticulosItemView implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArticuloView articulo;
	private int cantidad;
	private String txtCantidad;
	private int totalSolicitado;
	private Boolean solicitarItem;
	
	public SolicitudArticulosItemView(ArticuloView articulo, int cantidad){
		this.articulo = articulo;
		this.cantidad = cantidad;
		txtCantidad = String.valueOf(cantidad);
		
		setSolicitarItem(true);
	}
	public ArticuloView getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloView articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		this.txtCantidad = String.valueOf(cantidad);
	}
	public String getTxtCantidad() {
		return txtCantidad;
	}
	public void setTxtCantidad(String txtCantidad) {
		this.txtCantidad = txtCantidad;
		this.cantidad = Integer.parseInt(txtCantidad);
	}

	public int getTotalSolicitado() {
		return totalSolicitado;
	}
	public void setTotalSolicitado(int totalSolicitado) {
		this.totalSolicitado = totalSolicitado;
	}
	public Boolean getSolicitarItem() {
		return solicitarItem;
	}
	public void setSolicitarItem(Boolean pedir) {
		this.solicitarItem = pedir;
	}
	
}
