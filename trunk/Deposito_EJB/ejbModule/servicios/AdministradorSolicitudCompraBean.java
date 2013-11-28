package servicios;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import transformer.Transformer;
import transformer.ViewTransformer;
import view.SolicitudCompraView;
import dao.ArticuloDAO;
import dao.DespachoDAO;
import dao.FabricaDAO;
import dao.SolicitudCompraDAO;
import dto.SolicitudCompraDTO;
import entities.Articulo;
import entities.ItemSolicitudCompra;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class AdministradorSolicitudCompraBean
 */
@Stateless
@LocalBean
public class AdministradorSolicitudCompraBean {

	@EJB
	private FabricaDAO fabricaDAO;

	@EJB
	private SolicitudCompraDAO solicitudCompraDAO;

	@EJB
	private DespachoDAO despachoDAO;

	@EJB
	private ViewTransformer vt;

	@EJB
	Transformer t;

	@EJB
	private ArticuloDAO articuloDao;

	/**
	 * Default constructor.
	 */
	public AdministradorSolicitudCompraBean() {
	}

	public void crear(SolicitudCompraView compraView) {

		SolicitudCompra compra = vt.converToClass(compraView);

		/*
		 * get entity, validar, enviar a fabrica. Si falla, rollback y log
		 */

		try {

			// TODO AR: Validar entity

			solicitudCompraDAO.persist(compra);

			SolicitudCompraDTO dto = t.toDTO(compra);

			// TODO AR: recepcion de respuesta?
			fabricaDAO.enviar(dto);
		} catch (Exception e) {
			// TODO AR: log de errores y rollback de todo
			e.printStackTrace();
		}
	}

	private SolicitudCompra getEntity(SolicitudCompraDTO compraDTO) {

		SolicitudCompra solicitud = t.converToClass(compraDTO);
		return solicitud;
	}

	public void recibir(SolicitudCompraDTO compraDTO) {

		SolicitudCompra compra = getEntity(compraDTO);

		for (ItemSolicitudCompra item : compra.getArticulos()) {
			Articulo articulo = articuloDao.find(item.getArticulo().getCodigo());
			articulo.setStock(articulo.getStock() + item.getCantidad());
		}

		compra.setCompletada(true);
	}

	public SolicitudCompra getRecomendacionCompra() {
		SolicitudCompra SC = solicitudCompraDAO.getRecomendacionCompra();
		return SC;
	}

}
