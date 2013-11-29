package sessionBeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import entities.SolicitudArticulos;
import excepctions.BackEndException;
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
	 * @throws BackEndException 
	 * */
	@Override
	public ArrayList<SolicitudArticulosView> getSolicitudes() throws BackEndException {

		solicitudes = inicializarSolicitudes();
		stockArticulos = getStockArticulos();

		for (SolicitudArticulosView view : solicitudes) {

			validarSolicitud(view);
		}

		return solicitudes;
	}

	private void validarSolicitud(SolicitudArticulosView view) {

		view.setSelectable(true);

		for (SolicitudArticulosItemView itemView : view.getItems()) {

			Long codigoArticulo = itemView.getArticulo().getCodigo();
			Long stock = stockArticulos.get(codigoArticulo);

			if (stock >= itemView.getCantidad()) {
				itemView.setTotalSolicitado(itemView.getCantidad());
			} else {
				itemView.setTotalSolicitado(0);
				view.setSelectable(false);
			}
		}
	}

	private ArrayList<SolicitudArticulosView> inicializarSolicitudes() throws BackEndException {

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

	private HashMap<Long, Long> getStockArticulos() throws BackEndException {
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

		SolicitudArticulosView view = buscarSolicitud(solicitud.getCodigoSolicitud());

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

		return actualizarSolicitudes();
	}

	private SolicitudArticulosView buscarSolicitud(Long codigo) {
		for (SolicitudArticulosView view : solicitudes) {
			if (view.getCodigoSolicitud() == codigo) {
				return view;
			}
		}
		return null;
	}

	private ArrayList<SolicitudArticulosView> actualizarSolicitudes() {

		ArrayList<SolicitudArticulosView> actualizadas = new ArrayList<SolicitudArticulosView>();

		for (SolicitudArticulosView view : solicitudes) {

			if (!view.isSelected()) {

				actualizadas.add(view);
				view.setSelectable(true);

				for (SolicitudArticulosItemView itemView : view.getItems()) {

					if (stockArticulos.get(itemView.getArticulo().getCodigo()) >= itemView.getCantidad()) {
						itemView.setTotalSolicitado(itemView.getCantidad());
					} else {
						itemView.setTotalSolicitado(0);
						view.setSelectable(false);
						break;
					}
				}
			}
		}

		return actualizadas;
	}

	@Override
	public void enviarArticulos(ArrayList<SolicitudArticulosView> solicitudes) throws BackEndException {
		adminSolicitudes.enviarArticulos(solicitudes);
	}


}
