package servicios;

import entities.Articulo;

public interface AdministradorArticulo {
	
	public void guardarArticulo(Articulo articulo);
    
    public void actualizarArticulo(Articulo articulo);
    
    public void eliminarArticulo(Articulo articulo);

}
