package sessionBeans;

import javax.ejb.Remote;

import dto.ElectrodomesticoDTO;

@Remote
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoDTO e);
}
