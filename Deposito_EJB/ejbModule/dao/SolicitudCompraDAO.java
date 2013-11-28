package dao;

import java.util.ArrayList;
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
import entities.SolicitudArticulos;
import entities.SolicitudArticulosItem;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class SolicitudCompraDAO
 */
@Stateless
@LocalBean
public class SolicitudCompraDAO {

	@PersistenceContext
	EntityManager em;

	private static final Logger logger = Logger.getLogger(ArticuloDAO.class);

	@EJB
	Transformer transformer;

	/**
	 * Default constructor.
	 */
	public SolicitudCompraDAO() {
	}

	public void persist(SolicitudCompra compra) {
		em.persist(compra);
		em.flush();
		em.persist(compra);
	}

	public void merge(SolicitudCompra compra) {
		em.merge(compra);
		em.flush();
		em.merge(compra);
	}

	@SuppressWarnings("unchecked")
	public SolicitudCompra getRecomendacionCompra() {
		// TODO MF: aca falta obtener la recomendacion real esto es una truchada
		SolicitudCompra sc = new SolicitudCompra();
		sc.setFechaInicio(new Date());
		sc.setCompletada(false);

		try {

			// TODO: AR: Esta es la query que va, la otra es de prueba.
			Query q = em.createQuery("SELECT a.articulo.codigo, sum(a.cantidad) * 2 FROM SolicitudArticulos s join s.items a where s.cumplida=false group by a.articulo.codigo");

			// Query q =
			// em.createQuery("SELECT a.codigo, sum(a.stock) * 2 FROM Articulo a group by a.codigo");

			List<Object[]> result = q.getResultList();

			for (Object[] item : result) {
				ItemSolicitudCompra itemCompra = new ItemSolicitudCompra();
				itemCompra.setArticulo(em.find(Articulo.class, item[0]));
				long cantidad = (Long) item[1];
				itemCompra.setCantidad((int) cantidad);
				sc.getArticulos().add(itemCompra);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return sc;

	}

}
