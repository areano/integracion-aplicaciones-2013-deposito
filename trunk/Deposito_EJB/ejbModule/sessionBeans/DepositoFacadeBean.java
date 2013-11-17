package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


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
	private static final Logger logger = 
			   Logger.getLogger(DepositoFacadeBean.class.getName());
	@Override
	public void altaElectrodomestico(ElectrodomesticoDTO dto) {
		logger.info("*** Alta Electrodomestico  ***" );
		admin.guardarElectrodomestico(dto);
	}

	@Override
	public void altaModa(ModaDTO m) {
		logger.info("*** Alta Articulo de moda  ***" );
		admin.guardarModa(m);
	}

	@Override
	public void altaMueble(MuebleDTO m) {
		logger.info("*** Alta Mueble ***" );
		admin.guardarMueble(m);
	}

	@Override
	public void altaInfatil(InfantilDTO i) {
		logger.info("*** Alta Infantil  ***" );
		admin.guardarInfantil(i);
	}

	@Override
	public void actualizarStock(ArticuloDTO dto, long stock) {
		logger.info("*** Actualizar Stock  ***" );
		admin.actualizarStock(dto, stock);
	}
}
