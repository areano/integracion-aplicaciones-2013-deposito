package sessionBeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import entities.SolicitudArticulos;
import servicios.AdministradorArticulosBean;
import servicios.AdministradorSolicitudArticulosBean;
import transformer.ViewTransformer;
import view.ArticuloView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;

@Stateful
public class DespachoSolicitudesFacadebean implements DespachoSolicitudesFacade {

	@EJB
	AdministradorSolicitudArticulosBean adminSolicitudes;

	@EJB
	AdministradorArticulosBean adminArticulos;

	@EJB
	ViewTransformer transformer;

	ArrayList<SolicitudArticulosView> solicitudes;

	private HashMap<Long, Long> stockArticulos;

	private Comparator<SolicitudArticulosView> comparer = new Comparator<SolicitudArticulosView>() {
		@Override
		public int compare(SolicitudArticulosView o1, SolicitudArticulosView o2) {
			return o1.getDate().compareTo(o2.getDate());
		}
	};

	/**
	 * this method should return all @SolicitudArticulosView. each
	 * SolicitudArticulosView should be marked as selectable or not to be
	 * delivered according if the stock of @Articulo could complete the
	 * SolicitudArticulosView
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> getSolicitudes() {

		solicitudes = inicializarSolicitudes();
		stockArticulos = getStockArticulos();

		List<SolicitudArticulos> data = adminSolicitudes.getSolicitudesArticulos();

		for (SolicitudArticulos solicitud : data) {
			SolicitudArticulosView view = transformer.toView(solicitud);
			for (SolicitudArticulosItemView itemView : view.getItems()) {

				if (stockArticulos.get(itemView.getArticulo().getCodigo()) >= itemView.getCantidad()) {
					itemView.setTotalSolicitado(itemView.getCantidad());
				} else {
					itemView.setTotalSolicitado(0);
					view.setSelectable(false);
				}
			}
			solicitudes.add(view);
		}

		return solicitudes;
	}

	private ArrayList<SolicitudArticulosView> inicializarSolicitudes() {

		ArrayList<SolicitudArticulosView> views = new ArrayList<SolicitudArticulosView>();
		List<SolicitudArticulos> entities = adminSolicitudes.getSolicitudesArticulos();

		for (SolicitudArticulos solicitud : entities) {
			SolicitudArticulosView view = transformer.toView(solicitud);
			views.add(view);
		}

		// ordena las solicitudes por fecha
		Collections.sort(views, comparer);
		return views;
	}

	private HashMap<Long, Long> getStockArticulos() {
		HashMap<Long, Long> stockArticulos = new HashMap<Long, Long>();

		ArrayList<ArticuloView> articulos = adminArticulos.getArticulos();
		for (ArticuloView articulo : articulos) {
			stockArticulos.put(articulo.getCodigo(), articulo.getStock());
		}
		return stockArticulos;
	}

	/**
	 * This method should should recalculate the SolicitudArticulosView that
	 * could be delivered according the @SolicitudArticulosView checked by the
	 * user
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> markSolicitud(SolicitudArticulosView s) {
		return cambiarSolicitud(s, true);
	}

	/**
	 * This method should should recalculate the list of @SolicitudArticulosView
	 * that could be delivered according the @SolicitudArticulosView unchecked
	 * by the user
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> unmarkSolicitud(SolicitudArticulosView s) {
		return cambiarSolicitud(s, false);
	}

	public ArrayList<SolicitudArticulosView> cambiarSolicitud(SolicitudArticulosView solicitud, boolean seleccionada) {

		for (SolicitudArticulosView view : solicitudes) {

			if (view.getCodigoSolicitud() == solicitud.getCodigoSolicitud()) {

				view.setSelected(seleccionada);

				for (SolicitudArticulosItemView viewItem : view.getItems()) {

					Long codigoArticulo = viewItem.getArticulo().getCodigo();

					if (stockArticulos.containsKey(codigoArticulo)) {

						int incremento = viewItem.getCantidad();
						if (view.isSelected()) {
							incremento = incremento * -1;
						}
						stockArticulos.put(codigoArticulo, stockArticulos.get(codigoArticulo) + incremento);
					}
				}
			}
		}

		return actualizarSolicitudes();
	}

	private ArrayList<SolicitudArticulosView> actualizarSolicitudes() {

		ArrayList<SolicitudArticulosView> actualizadas = new ArrayList<SolicitudArticulosView>();

		for (SolicitudArticulosView view : solicitudes) {

			if (view.isSelectable() && !view.isSelected()) {

				actualizadas.add(view);

				for (SolicitudArticulosItemView itemView : view.getItems()) {

					if (stockArticulos.get(itemView.getArticulo().getCodigo()) >= itemView.getCantidad()) {
						itemView.setTotalSolicitado(itemView.getCantidad());
					} else {
						itemView.setTotalSolicitado(0);
						view.setSelectable(false);
					}
				}
			}
		}

		return actualizadas;
	}

	// private static ArrayList<SolicitudArticulosView> prueba() {
	// ElectrodomesticoView electro = new ElectrodomesticoView();
	// ModaView moda = new ModaView();
	// electro.setCodigo(Long.valueOf(1));
	// electro.setDescripcion("Un electro");
	// electro.setFichaTecnica("una url");
	// electro.setMarca("Modila");
	// electro.setNombre("Supercalifragitisticoespiralidoso");
	// electro.setOrigen("Tierra cdel fuego");
	// electro.setPrecio(Float.parseFloat("12.5"));
	//
	// moda.setCodigo(Long.valueOf(1));
	// moda.setDescripcion("una remera");
	// moda.setTalle("XL");
	// moda.setMarca("Mota");
	// moda.setNombre("Motta inside");
	// moda.setOrigen("El Salvador");
	// moda.setPrecio(Float.parseFloat("12.5"));
	// moda.setColor("Azul");
	//
	// ArrayList<SolicitudArticulosView> solicitudes = new
	// ArrayList<SolicitudArticulosView>();
	// SolicitudArticulosView dto = new SolicitudArticulosView();
	//
	// dto.setIdModulo(1);
	// SolicitudArticulosItemView item = new SolicitudArticulosItemView(electro,
	// 2);
	// dto.addItemSolicitudArticulos(item);
	//
	// dto.setDate(new java.util.Date());
	// dto.setCodigoSolicitud(1);
	// dto.setSelectable(true);
	// solicitudes.add(dto);
	//
	// dto = new SolicitudArticulosView();
	// dto.setIdModulo(2);
	// dto.setDate(new java.util.Date());
	// dto.addItemSolicitudArticulos(new SolicitudArticulosItemView(electro,
	// 5));
	// dto.addItemSolicitudArticulos(new SolicitudArticulosItemView(moda, 5));
	// dto.setCodigoSolicitud(2);
	// dto.setSelectable(false);
	// solicitudes.add(dto);
	//
	// return solicitudes;
	// }
}
