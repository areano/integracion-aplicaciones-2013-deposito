package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import servicios.AdministradorArticulos;
import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;

@Stateless
public class DepositoFacadeBean implements DepositoFacade{

	@EJB	
	AdministradorArticulos admin;
	
	@Override
	public void altaElectrodomestico(ElectrodomesticoDTO dto) {
		admin.guardarElectrodomestico(dto);
	}

	@Override
	public void actualizarStock(ArticuloDTO dto, long stock) {
		admin.actualizarStock(dto, stock);
	}
	
	
	

}
