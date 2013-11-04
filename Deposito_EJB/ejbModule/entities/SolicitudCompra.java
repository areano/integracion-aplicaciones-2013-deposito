package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import auxiliares.CantidadArticulos;

@Entity
@Table(name="SolicitudesCompra")
public class SolicitudCompra {
	
	@Id
	private long codigo;
	
	@OneToMany
	private List<CantidadArticulos> articulos;
	
	public SolicitudCompra(){}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<CantidadArticulos> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<CantidadArticulos> articulos) {
		this.articulos = articulos;
	}
}
