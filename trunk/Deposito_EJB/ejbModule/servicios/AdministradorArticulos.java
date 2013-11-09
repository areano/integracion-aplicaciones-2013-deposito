package servicios;

import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import entities.Articulo;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;

public interface AdministradorArticulos {
	
	/*
	public void guardarArticulo(Articulo articulo);
    
    public void actualizarArticulo(Articulo articulo);
    
    public void eliminarArticulo(Articulo articulo);
    */
	
	public void guardarElectrodomestico(ElectrodomesticoDTO dto);
	
	public void guardarInfantil(InfantilDTO dto);
	
	public void guardarModa(ModaDTO dto);
	
	public void guardarMueble(MuebleDTO dto);

}
