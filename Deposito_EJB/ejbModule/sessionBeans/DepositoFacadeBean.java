package sessionBeans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


import servicios.AdministradorArticulosBean;
import view.*;
@Stateless
public class DepositoFacadeBean implements DepositoFacade {

	@EJB
	AdministradorArticulosBean admin;
	private static final Logger logger = 
			   Logger.getLogger(DepositoFacadeBean.class.getName());
	public DepositoFacadeBean(){}
	@Override
	public void altaElectrodomestico(ElectrodomesticoView dto) {
		logger.info("*** Alta Electrodomestico  ***" );
		admin.guardarElectrodomestico(dto);
	}

	@Override
	public void altaModa(ModaView m) {
		logger.info("*** Alta Articulo de moda  ***" );
		admin.guardarModa(m);
	}

	@Override
	public void altaMueble(MuebleView m) {
		logger.info("*** Alta Mueble ***" );
		admin.guardarMueble(m);
	}

	@Override
	public void altaInfatil(InfantilView i) {
		logger.info("*** Alta Infantil  ***" );
		admin.guardarInfantil(i);
	}

	@Override
	public void actualizarStock(ArticuloView dto, long stock) {
		logger.info("*** Actualizar Stock  ***" );
		admin.actualizarStock(dto, stock);
	}
}
