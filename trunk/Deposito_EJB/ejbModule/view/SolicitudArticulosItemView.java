package view;



public class SolicitudArticulosItemView {
	private ArticuloView articulo;
	private int cantidad;
	public SolicitudArticulosItemView(ArticuloView articulo, int cantidad){
		this.articulo = articulo;
		this.cantidad = cantidad;		
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
	}
	
}
