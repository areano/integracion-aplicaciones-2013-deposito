package dto;

import java.util.Date;
import java.util.ArrayList;

public class SolicitudCompraDTO {

	private ArrayList<ItemSolicitudCompra> items = new ArrayList<ItemSolicitudCompra>();
	private long codigoDespacho;
	private Date date;
	private long codigoSolicitud;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(long codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}
	
}
