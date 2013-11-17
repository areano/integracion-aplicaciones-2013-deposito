package sessionBeans;

import javax.ejb.Remote;

import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;

@Remote
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoDTO dto);
	
	public void altaModa(ModaDTO dto);
	
	public void altaMueble(MuebleDTO dto);
	
	public void altaInfatil(InfantilDTO dto);
	
	public void actualizarStock(ArticuloDTO dto, long stock);
}
