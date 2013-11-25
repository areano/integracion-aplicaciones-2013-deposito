package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import entities.Articulo;
import entities.ItemSolicitudCompra;
import entities.SolicitudCompra;

/**
 * Session Bean implementation class SolicitudCompraDAO
 */
@Stateless
@LocalBean
public class SolicitudCompraDAO {
	@PersistenceContext
	EntityManager em;
	private static final Logger logger = 
			   Logger.getLogger(ArticuloDAO.class);

	/**
	 * Default constructor.
	 */
	public SolicitudCompraDAO() {
	}

	public void persist(SolicitudCompra compra) {
		// TODO AR: Persistir compra
	}

	public void merge(SolicitudCompra compra) {
		// TODO AR: Merge con la solicitud de compra persistida
	}

	public SolicitudCompra getRecomendacionCompra() {
		// TODO MF: aca falta obtener la recomendacion real esto es una truchada
		SolicitudCompra sc=new SolicitudCompra();
		sc.setFechaInicio(new Date());
		sc.setCompletada(false);

		try{
			
//			Query = em.createQuery("SELECT Articulo, 1 FROM Articulo'");
			int i=0;
			List<Articulo> results = em.createQuery("FROM Articulo", Articulo.class).getResultList();
			for (Articulo a1: results){
				i++;
				sc.getArticulos().add(new ItemSolicitudCompra(a1.getCodigo(), a1, i));
			}
//			logger.info("Find articulo persistido con código: ["+cod+"] ");
		}catch(Exception e)
		{
//			logger.error("Error buscando Articulo codigo ["+cod+"]");
			logger.error(e);
		}
		return sc;
		
	}

}
