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
		SolicitudCompra sc=new SolicitudCompra();
		sc.setFechaInicio(new Date());
		sc.setCompletada(false);

		try{
			
			Query q = em.createQuery("SELECT sum(s.items),articulo FROM SolicitudArticulos s join s.items where s.cumplida=false "
					+ "group by s.items.articulo");
			
			List<SolicitudArticulosItem> items = q.getResultList();
			
			for(SolicitudArticulosItem item: items){
				item.setCantidad(item.getCantidad()*2);
			}
			
			List<ItemSolicitudCompra> itemsCompra =  transformer.toItemCompra(items);
			
			sc.setArticulos(itemsCompra);
			 
			
//			logger.info("Find articulo persistido con código: ["+cod+"] ");
		}catch(Exception e)
		{
//			logger.error("Error buscando Articulo codigo ["+cod+"]");
			logger.error(e);
		}
		return sc;
		
	}

}
