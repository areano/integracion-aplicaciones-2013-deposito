package sessionBeans;

import javax.ejb.Remote;

import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;

@Remote
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoDTO e);
	
	public void altaModa(ModaDTO m);
	
	public void altaMueble(MuebleDTO m);
	
	public void altaInfatil(InfantilDTO i);
	
	public void actualizarStock(ArticuloDTO dto, long stock);
}
