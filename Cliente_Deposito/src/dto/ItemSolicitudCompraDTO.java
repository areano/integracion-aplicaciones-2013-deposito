package dto;

public class ItemSolicitudCompraDTO {
	private ArticuloDTO articulo;
	private int cantidad;
	
	public ItemSolicitudCompraDTO(ArticuloDTO articulo, int cantidad){
		this.articulo = articulo;
		this.cantidad = cantidad;		
	}
	public ArticuloDTO getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
