package view;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;

public class SolicitudCompraView implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<SolicitudArticulosItemView> items = new ArrayList<SolicitudArticulosItemView>();
	private Date date;
	private Date fechaFin;
	private long codigoSolicitud;
	
	public static final String PENDIENTE = "Pendiente";
	public static final String COMPLETA = "Completa";

	private String estado = PENDIENTE;
	
	public ArrayList<SolicitudArticulosItemView> getItems() {
		return items;
	}

	public void setItems(ArrayList<SolicitudArticulosItemView> items) {
		this.items = items;
	}
	public void addItemSolicitudCompra(SolicitudArticulosItemView item){
		items.add(item);
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

	public List<SolicitudArticulosItemView> getArticulos() {
		return items;
	}
	public void reformular(Set<Object> selectedItemIds) {
		 ArrayList<SolicitudArticulosItemView> tempArrayList = new ArrayList<SolicitudArticulosItemView>();
		 for (Object object : selectedItemIds) {
			 tempArrayList.add((SolicitudArticulosItemView)object);
		}
		items.clear();
		items.addAll(tempArrayList);
//		Iterator<SolicitudArticulosItemView> it = items.iterator();
//		while (it.hasNext()) {
//			SolicitudArticulosItemView item= it.next();
//			if (!(selectedItemIds.contains(item))){
//				it.remove();
//			}			
//		}

		
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
