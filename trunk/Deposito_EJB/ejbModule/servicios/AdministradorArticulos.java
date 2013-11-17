package servicios;

import view.*;

public interface AdministradorArticulos {

	/*
	 * public void guardarArticulo(Articulo articulo);
	 * 
	 * public void actualizarArticulo(Articulo articulo);
	 * 
	 * public void eliminarArticulo(Articulo articulo);
	 */

	public void guardarElectrodomestico(ElectrodomesticoView dto);

	public void guardarInfantil(InfantilView dto);

	public void guardarModa(ModaView dto);

	public void guardarMueble(MuebleView dto);

	public void actualizarStock(ArticuloView dto, long stock);

}
