package transformer;

import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import entities.Electrodomestico;
import entities.Infantil;
import entities.Moda;
import entities.Mueble;

public class Transfomer {
	
	private static Transfomer instancia;
	
	public static Transfomer obtenerInstancia(){
		if(instancia==null)
			instancia=new Transfomer();
		return instancia;
	}
	
	private Transfomer(){}
	
	public Electrodomestico converToClass(ElectrodomesticoDTO dto){
		Electrodomestico e = new Electrodomestico();
		e.setCodigo(dto.getCodigo());
		e.setCodigoDeposito(dto.getCodigoDeposito());
		e.setDescripcion(dto.getDescripcion());
		e.setFichaTecnica(dto.getFichaTecnica());
		e.setFoto(dto.getFoto());
		e.setMarca(dto.getMarca());
		e.setNombre(dto.getNombre());
		e.setOrigen(dto.getOrigen());
		e.setPrecio(dto.getPrecio());
		return e;
	}
	

	public Infantil converToClass(InfantilDTO dto){
		Infantil i = new Infantil();
		i.setCodigo(dto.getCodigo());
		i.setCodigoDeposito(dto.getCodigoDeposito());
		i.setDescripcion(dto.getDescripcion());
		i.setEdadRecomendada(dto.getEdadRecomendada());
		i.setFoto(dto.getFoto());
		i.setMarca(dto.getMarca());
		i.setNombre(dto.getNombre());
		i.setOrigen(dto.getOrigen());
		i.setPrecio(dto.getPrecio());
		return i;
	}
	

	public Moda converToClass(ModaDTO dto){
		Moda m = new Moda();
		m.setCodigo(dto.getCodigo());
		m.setCodigoDeposito(dto.getCodigoDeposito());
		m.setColor(dto.getColor());
		m.setDescripcion(dto.getDescripcion());
		m.setFoto(dto.getFoto());
		m.setMarca(dto.getMarca());
		m.setNombre(dto.getNombre());
		m.setOrigen(dto.getOrigen());
		m.setPrecio(dto.getPrecio());
		m.setTalle(dto.getTalle());
		return m;
	}
	

	public Mueble converToClass(MuebleDTO dto){
		Mueble m = new Mueble();
		m.setCodigo(dto.getCodigo());
		m.setCodigoDeposito(dto.getCodigoDeposito());
		m.setDescripcion(dto.getDescripcion());
		m.setFoto(dto.getFoto());
		m.setMarca(dto.getMarca());
		m.setMaterial(dto.getMaterial());
		m.setNombre(dto.getNombre());
		m.setOrigen(dto.getOrigen());
		m.setPrecio(dto.getPrecio());
		return m;
	}
}
