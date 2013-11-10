package sessionBeans;

import javax.ejb.Remote;

import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;

@Remote
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoDTO e);
	
	public void actualizarStock(ArticuloDTO dto, long stock);
}
