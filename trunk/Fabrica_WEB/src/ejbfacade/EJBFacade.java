package ejbfacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;








import excepctions.BackEndException;
import facade.FabricaFacade;
import facade.FabricaWebFacade;
import sessionBeans.DepositoFacade;
//import ar.com.edu.uade.beans.DepositoFacade;
import view.ArticuloView;
import view.ConnectionView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudCompraView;



public class EJBFacade {

	private static final Logger logger = 
			   Logger.getLogger(EJBFacade.class);
	
	
	static EJBFacade instance =null;
	
	static FabricaWebFacade fabricaWebFacade ;
	
	private EJBFacade() throws NamingException{
		getFabricaFacade();
	}
	public static EJBFacade getIntance() throws NamingException{
		if(instance==null){
			instance= new EJBFacade();
		}
		return instance;
	}
	
	public List<SolicitudCompraView> getSolicitudesDeCompra(){		
		try {
			return fabricaWebFacade.getSolicitudesDeCompra();
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void entregarCompras(List<Long> lista){
		try {
			fabricaWebFacade.entregarCompras(lista);
		} catch (BackEndException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getFabricaFacade() throws NamingException{
		   try {
				InitialContext ic = new InitialContext();
				fabricaWebFacade = (FabricaWebFacade) ic.lookup("java:global/Fabrica_EAR/Fabrica_EJB/FabricaWebFacadeBean");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	
}
