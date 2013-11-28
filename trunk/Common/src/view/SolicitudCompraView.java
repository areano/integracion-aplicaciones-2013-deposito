package view;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SolicitudCompraView implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<SolicitudArticulosItemView> items = new ArrayList<SolicitudArticulosItemView>();
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
	
}
