package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import servicios.AdministradorArticulos;
import dto.ElectrodomesticoDTO;

@Stateless
public class DepositoFacadeBean implements DepositoFacade{

	@EJB	
	AdministradorArticulos admin;
	
	@Override
	public void altaElectrodomestico(ElectrodomesticoDTO e) {
		
		
	}
	

}
