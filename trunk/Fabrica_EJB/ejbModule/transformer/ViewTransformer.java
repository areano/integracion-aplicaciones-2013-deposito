package transformer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
import view.SolicitudCompraView;

import dao.SolicitudCompraDAOBean;
import entities.ItemSolicitudCompra;
import entities.SolicitudCompra;

@Stateless
@LocalBean
public class ViewTransformer {
	@EJB
	SolicitudCompraDAOBean scDAO;

	public ViewTransformer() {

	}

	public SolicitudCompraView toView(SolicitudCompra solicitud) {
		SolicitudCompraView view = new SolicitudCompraView();
		view.setCodigoSolicitud(solicitud.getCodigo());
		if (solicitud.getFechaFin() == null) {
			// TODO: MF set no entregado.
		} else {
			// TODO: MF set entregado.
		}

		for (ItemSolicitudCompra i : solicitud.getItemArticulos()) {
			view.getArticulos().add(toView(i));
		}
		return view;
	}

	public SolicitudCompra converToClass(SolicitudCompraView scv) {
		SolicitudCompra solicitud = new SolicitudCompra();
		solicitud.setCodigo(scv.getCodigoSolicitud());

		// TODO: MF falta agregar aca la fecha fin.
		for (SolicitudArticulosItemView item : scv.getArticulos()) {
			solicitud.getItemArticulos().add(this.converToClass(item));
		}

		return solicitud;
	}

	private ItemSolicitudCompra converToClass(SolicitudArticulosItemView iscv) {
		ItemSolicitudCompra item = new ItemSolicitudCompra();
		item.setCodArticulo(iscv.getArticulo().getCodigo());
		item.setNombreArticulo(iscv.getArticulo().getNombre());
		item.setCantidad(iscv.getCantidad());
		return item;
	}


	private SolicitudArticulosItemView toView(ItemSolicitudCompra item) {

		ArticuloView av = new ElectrodomesticoView();
		av.setCodigo(item.getCodArticulo());
		av.setNombre(item.getNombreArticulo());
		SolicitudArticulosItemView view = new SolicitudArticulosItemView(av, item.getCantidad());
		return view;
	}

	public List<SolicitudCompraView> toView(List<SolicitudCompra> lista) {
		List<SolicitudCompraView> listaView=new ArrayList<SolicitudCompraView>();
		
		for (SolicitudCompra item : lista){
			listaView.add(toView(item));
		}

		return listaView;
	}
	
	
}
