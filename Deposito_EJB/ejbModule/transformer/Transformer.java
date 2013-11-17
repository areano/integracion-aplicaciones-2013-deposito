package transformer;

import java.sql.Timestamp;

import javax.ejb.EJB;

import dao.ArticuloDAO;
import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ItemSolicitudCompraDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import dto.SolicitudArticulosDTO;
import dto.SolicitudCompraDTO;
import entities.Articulo;
import entities.Electrodomestico;
import entities.Infantil;
import entities.ItemSolicitudCompra;
import entities.Moda;
import entities.Mueble;
import entities.SolicitudArticulos;
import entities.SolicitudCompra;

public class Transformer {
	@EJB
	ArticuloDAO articuloDAO;
	
	private static Transformer instancia;
	
	public static Transformer obtenerInstancia(){
		if(instancia==null)
			instancia=new Transformer();
		return instancia;
	}
	
	private Transformer(){}
	
	public Articulo converToClass(ArticuloDTO dto){
		Articulo a = new Articulo();
		a.setCodigo(dto.getCodigo());
		a.setCodigoDeposito(dto.getCodigoDeposito());
		a.setDescripcion(dto.getDescripcion());
		a.setFoto(dto.getFoto());
		a.setMarca(dto.getMarca());
		a.setNombre(dto.getNombre());
		a.setOrigen(dto.getOrigen());
		a.setPrecio(dto.getPrecio());
		return a;
	}
	
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
	
	public SolicitudCompra converToClass(SolicitudCompraDTO dto){
		SolicitudCompra solicitud = new SolicitudCompra();
		solicitud.setCodigo(dto.getCodigo());
		solicitud.setFechaInicio(dto.getFechaInicio());
		solicitud.setFechaFin(dto.getFechaFin());
		
		for(ItemSolicitudCompraDTO item:dto.getArticulos()){
			solicitud.getArticulos().add(this.converToClass(item));
		}
		
		return solicitud;
	}
	
	private ItemSolicitudCompra converToClass(ItemSolicitudCompraDTO dto){
		ItemSolicitudCompra item = new ItemSolicitudCompra();
		item.setArticulo(articuloDAO.find(dto.getCodArticulo()));
		item.setCantidad(dto.getCantidad());
		return item;
	}
	
	private void setArticuloDTO(Articulo a, ArticuloDTO dto){
		dto.setCodigo(a.getCodigo());
		dto.setCodigoDeposito(6L);
		dto.setDescripcion(a.getDescripcion());
		dto.setFecha(new Timestamp(new java.util.Date().getTime()).toString());
		dto.setFoto(a.getFoto());
		dto.setMarca(a.getMarca());
		dto.setNombre(a.getNombre());
		dto.setOrigen(a.getOrigen());
		dto.setPrecio(a.getPrecio());
	}
	
	public MuebleDTO toDTO(Mueble m){
		MuebleDTO mDTO=new MuebleDTO();
		setArticuloDTO(m, mDTO);		
		mDTO.setMaterial(m.getMaterial());
		return mDTO;
	}
	
	public InfantilDTO toDTO(Infantil i){
		InfantilDTO iDTO=new InfantilDTO();
		setArticuloDTO(i, iDTO);		
		iDTO.setEdadRecomendada(i.getEdadRecomendada());
		return iDTO;
	}
	
	public ModaDTO toDTO(Moda m){
		ModaDTO mDTO=new ModaDTO();
		setArticuloDTO(m, mDTO);
		mDTO.setColor(m.getColor());
		mDTO.setTalle(m.getTalle());		
		return mDTO;
	}

	public ElectrodomesticoDTO toDTO(Electrodomestico e) {
		ElectrodomesticoDTO eDTO=new ElectrodomesticoDTO();
		setArticuloDTO(e, eDTO);		
		eDTO.setFichaTecnica(e.getFichaTecnica());		
		return eDTO;	
	}

	public SolicitudCompraDTO toDTO(SolicitudCompra solicitud){
		SolicitudCompraDTO dto = new SolicitudCompraDTO();
		dto.setCodigo(solicitud.getCodigo());
		dto.setFechaInicio(solicitud.getFechaInicio());
		dto.setFechaFin(solicitud.getFechaFin());
		
		for(ItemSolicitudCompra i:solicitud.getArticulos()){
			dto.getArticulos().add(this.toDTO(i));
		}
		return dto;
	}
	
	private ItemSolicitudCompraDTO toDTO(ItemSolicitudCompra item){
		ItemSolicitudCompraDTO dto = new ItemSolicitudCompraDTO();
		dto.setCantidad(item.getCantidad());
		dto.setCodArticulo(item.getId());
		dto.setNomArticulo(item.getArticulo().getNombre());
		return dto;
	}
}
