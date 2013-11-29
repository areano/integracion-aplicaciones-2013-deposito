package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import transformer.Transformer;
import entities.Articulo;
import entities.ItemSolicitudCompra;
import entities.SolicitudCompra;
import excepctions.BackEndException;

/**
 * Session Bean implementation class SolicitudCompraDAO
 */
@Stateless
@LocalBean
public class SolicitudCompraDAO {

	@PersistenceContext
	EntityManager em;

	private static final Logger logger = Logger.getLogger(SolicitudCompraDAO.class);

	@EJB
	Transformer transformer;

	/**
	 * Default constructor.
	 */
	public SolicitudCompraDAO() {
	}

	public void persist(SolicitudCompra compra) throws BackEndException {
		try {
			em.persist(compra);
			em.flush();
		}catch (Exception e){
			logger.error("Error durante Persistencia de Solicitude De compra", e);
			throw new BackEndException(e);
		}
	}

	public void merge(SolicitudCompra compra) throws BackEndException {
		try {
		em.merge(compra);
		em.flush();
		}catch (Exception e){
			logger.error("Error durante Update de Solicitude De compra", e);
			throw new BackEndException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public SolicitudCompra getRecomendacionCompra() throws BackEndException {
		// TODO MF: aca falta obtener la recomendacion real esto es una truchada
		SolicitudCompra sc = new SolicitudCompra();
		sc.setFechaInicio(new Date());
		sc.setCompletada(false);

		try {

			// TODO: AR: Esta es la query que va, la otra es de prueba.
			Query q = em.createQuery("SELECT a.articulo.codigo, sum(a.cantidad) FROM SolicitudArticulos s join s.items a where s.cumplida=false group by a.articulo.codigo");

			// Query q =
			// em.createQuery("SELECT a.codigo, sum(a.stock) * 2 FROM Articulo a group by a.codigo");

			List<Object[]> result = q.getResultList();

			for (Object[] item : result) {

				Articulo articulo = em.find(Articulo.class, item[0]);
				long cantidadSolicitada = (Long) item[1];
				long cantidad = articulo.getStock() - cantidadSolicitada;

				if (cantidad < 0) {
					ItemSolicitudCompra itemCompra = new ItemSolicitudCompra();
					itemCompra.setArticulo(articulo);
					itemCompra.setCantidad(Math.abs((int) cantidad) * 2);
					itemCompra.setCantidadSolicitada((int) cantidadSolicitada);
					sc.getArticulos().add(itemCompra);
				}
			}
		} catch (Exception e) {
			logger.error(e);
			throw new BackEndException(e);
		}

		return sc;
	}

}
