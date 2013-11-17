package view;

import java.util.Date;
import java.util.ArrayList;

public class SolicitudCompraView {

	private ArrayList<SolicitudArticulosItemView> items = new ArrayList<SolicitudArticulosItemView>();
	private long codigoDespacho;
	private Date date;
	private long codigoSolicitud;
	public ArrayList<SolicitudArticulosItemView> getItems() {
		return items;
	}

	public void setItems(ArrayList<SolicitudArticulosItemView> items) {
		this.items = items;
	}
	public void addItemSolicitudCompra(SolicitudArticulosItemView item){
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

	public Object getArticulos() {
		return items;
	}
	
}
