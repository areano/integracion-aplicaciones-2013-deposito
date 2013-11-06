package servicios;

import entities.Articulo;

public interface AdministradorArticulos {
	
	public void guardarArticulo(Articulo articulo);
    
    public void actualizarArticulo(Articulo articulo);
    
    public void eliminarArticulo(Articulo articulo);

}
