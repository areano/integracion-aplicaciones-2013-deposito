package servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import transformer.Transformer;
import transformer.ViewTransformer;
import view.SolicitudCompraView;
import dao.DespachoDAO;
import dao.FabricaDAO;
import dao.SolicitudCompraDAO;
import dto.SolicitudCompraDTO;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class AdministradorSolicitudCompraBean
 */
@Stateless
@LocalBean
public class AdministradorSolicitudCompraBean implements
		AdministradorSolicitudCompra {

	@EJB
	private FabricaDAO fabricaDAO;

	@EJB
	private SolicitudCompraDAO solicitudCompraDAO;

	@EJB
	private DespachoDAO despachoDAO;
	
	@EJB
	private ViewTransformer vt;

	/**
	 * Default constructor.
	 */
	public AdministradorSolicitudCompraBean() {
	}

	
	
	@Override
	public void crear(SolicitudCompraView compraView) {

		Transformer t= Transformer.obtenerInstancia();
		SolicitudCompra compra= vt.converToClass(compraView);

		/*
		 * get entity, validar, enviar a fabrica. Si falla, rollback y log
		 */

		try {

			// TODO AR: Validar entity

			solicitudCompraDAO.persist(compra);
			
			SolicitudCompraDTO dto =Transformer.obtenerInstancia().toDTO(compra);

			// TODO AR: recepcion de respuesta?
			fabricaDAO.enviar(dto);
		} catch (Exception e) {
			// TODO AR: log de errores y rollback de TODO
			e.printStackTrace();
		}
	}
	

	private SolicitudCompra getEntity(SolicitudCompraDTO compraDTO) {
		// TODO AR: crear entity desde dto.
		// los articulos debe recuperarlos
		
		SolicitudCompra solicitud = Transformer.obtenerInstancia().converToClass(compraDTO);
		return solicitud;
	}

	@Override
	public void recibir(SolicitudCompraDTO compraDTO) {
		/*
		 * getEntity validar actualizar el stock de cada articulo marcar la
		 * solicitud de compra com recibida
		 */
		SolicitudCompra compra = getEntity(compraDTO);

		// for (Articulo art : compra.getArticulos()) {
		// /*
		// * buscar entity stock stock
		// * actualizar stock
		// * validar que se persista
		// * */
		// }

		compra.setCompletada(true);
		solicitudCompraDAO.merge(compra);

	}

	public SolicitudCompra getRecomendacionCompra(){
		SolicitudCompra SC=solicitudCompraDAO.getRecomendacionCompra(); 
		return SC;
	}
	
	
}
