package view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SolicitudArticulosView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -818101022335386849L;
	private ArrayList<SolicitudArticulosItemView> items = new ArrayList<SolicitudArticulosItemView>();
	private int idModulo;
	private Date date;
	private long codigoSolicitud;
	private boolean selectable;
	private boolean selected;

	public void setItems(ArrayList<SolicitudArticulosItemView> items) {
		this.items = items;
	}

	public void addItemSolicitudArticulos(SolicitudArticulosItemView item) {
		items.add(item);
	}

	public long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
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

	public ArrayList<SolicitudArticulosItemView> getArticulos() {
		return items;
	}

	public ArrayList<SolicitudArticulosItemView> getItems() {
		return items;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		if (selectable) {
			this.selected = selected;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || object.getClass() != getClass()) {
			return false;
		}
		return this.hashCode() == object.hashCode();
	}

	@Override
	public int hashCode() {
		return (int) codigoSolicitud;
	}
}
