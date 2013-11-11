package dto;

import java.util.ArrayList;

public class SolicitudCompraDTO {

	private ArrayList<ItemSolicitudCompra> items;
	private long codigoDespacho;
	public ArrayList<ItemSolicitudCompra> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemSolicitudCompra> items) {
		this.items = items;
	}
	public void addItemSolicitudCompra(ItemSolicitudCompra item){
		items.add(item);
	}

	public long getCodigoDespacho() {
		return codigoDespacho;
	}

	public void setCodigoDespacho(long codigoDespacho) {
		this.codigoDespacho = codigoDespacho;
	}
	
}
