package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import servicios.AdministradorArticulosBean;
import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;

@Stateless
public class DepositoFacadeBean implements DepositoFacade {

	@EJB
	AdministradorArticulosBean admin;

	@Override
	public void altaElectrodomestico(ElectrodomesticoDTO dto) {
		admin.guardarElectrodomestico(dto);
	}

	@Override
	public void altaModa(ModaDTO m) {
		admin.guardarModa(m);
	}

	@Override
	public void altaMueble(MuebleDTO m) {
		admin.guardarMueble(m);
	}

	@Override
	public void altaInfatil(InfantilDTO i) {
		admin.guardarInfantil(i);
	}

	@Override
	public void actualizarStock(ArticuloDTO dto, long stock) {
		admin.actualizarStock(dto, stock);
	}
}
