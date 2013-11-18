package sessionBeans;

import javax.ejb.Local;
import javax.ejb.Remote;

import view.*;


@Local
public interface DepositoFacade {

	public void altaElectrodomestico(ElectrodomesticoView dto);
	
	public void altaModa(ModaView dto);
	
	public void altaMueble(MuebleView dto);
	
	public void altaInfatil(InfantilView dto);
	
	public void actualizarStock(ArticuloView dto, long stock);
}
