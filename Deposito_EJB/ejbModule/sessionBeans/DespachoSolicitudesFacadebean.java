package sessionBeans;

import java.util.ArrayList;

import javax.ejb.Stateful;

import view.ElectrodomesticoView;
import view.ModaView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
@Stateful
public class DespachoSolicitudesFacadebean implements DespachoSolicitudesFacade {

	ArrayList<SolicitudArticulosView> solicitudes;
	/** 
	 * this method should return all @SolicitudArticulosView.
	 * each SolicitudArticulosView should be marked as  selectable or
	 * not to be delivered according if the stock of @Articulo could complete the 
	 * SolicitudArticulosView
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> getSolicitudes() {
		// TODO Auto-generated method stub
		
		//return solicitudes;
		
		// TODO delete this block, is just to testing ui purposes
		
		ElectrodomesticoView electro =new ElectrodomesticoView();
		ModaView moda =  new ModaView();
		electro.setCodigo(Long.valueOf(1));
		electro.setDescripcion("Un electro");
		electro.setFichaTecnica("una url");
		electro.setMarca("Modila");
		electro.setNombre("Supercalifragitisticoespiralidoso");
		electro.setOrigen("Tierra cdel fuego");
		electro.setPrecio( Float.parseFloat("12.5"));
		
		moda.setCodigo(Long.valueOf(1));
		moda.setDescripcion("una remera");
		moda.setTalle("XL");
		moda.setMarca("Mota");
		moda.setNombre("Motta inside");
		moda.setOrigen("El Salvador");
		moda.setPrecio( Float.parseFloat("12.5"));
		moda.setColor("Azul");
		
		 solicitudes =  new ArrayList<SolicitudArticulosView>();
		SolicitudArticulosView dto = new SolicitudArticulosView();
		
		dto.setIdModulo(1);
		SolicitudArticulosItemView item = new SolicitudArticulosItemView(electro, 2);
		dto.addItemSolicitudArticulos(item);

		dto.setDate(new java.util.Date());
		dto.setCodigoSolicitud(1);
		dto.setSelectable(true);
		solicitudes.add(dto);
		
		dto = new SolicitudArticulosView();
		dto.setIdModulo(2);
		dto.setDate(new java.util.Date());
		dto.addItemSolicitudArticulos(new SolicitudArticulosItemView(electro, 5));
		dto.addItemSolicitudArticulos(new SolicitudArticulosItemView(moda, 5));
		dto.setCodigoSolicitud(2);
		dto.setSelectable(false);
		solicitudes.add(dto);

		return solicitudes;//   borrar al implementar admin.getSolicitudesArticulos();
		
	}
	/** This method should should recalculate the SolicitudArticulosView
	 * that could be delivered according the @SolicitudArticulosView 
	 * checked by the user 
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> markSolicitud(
			SolicitudArticulosView s) {
		// TODO Auto-generated method stub
		return null;
	}
	/** This method should should recalculate the list of @SolicitudArticulosView
	 * that could be delivered according the @SolicitudArticulosView 
	 * unchecked by the user 
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> unmarkSolicitud(
			SolicitudArticulosView s) {
		// TODO Auto-generated method stub
		return null;
	}

}
