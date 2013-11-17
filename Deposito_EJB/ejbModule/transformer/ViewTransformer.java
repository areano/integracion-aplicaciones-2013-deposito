package transformer;

import java.sql.Timestamp;

import javax.ejb.EJB;

import view.ArticuloView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudArticulosItemView;
import view.SolicitudCompraView;
import dao.ArticuloDAO;
import dto.ArticuloDTO;
import dto.ElectrodomesticoDTO;
import dto.InfantilDTO;
import dto.ItemSolicitudCompraDTO;
import dto.ModaDTO;
import dto.MuebleDTO;
import dto.SolicitudCompraDTO;
import entities.Articulo;
import entities.Electrodomestico;
import entities.Infantil;
import entities.ItemSolicitudCompra;
import entities.Moda;
import entities.Mueble;
import entities.SolicitudCompra;

public class ViewTransformer {
	@EJB
	ArticuloDAO articuloDAO;
	
	private static ViewTransformer instancia;
	
	public static ViewTransformer obtenerInstancia(){
		if(instancia==null)
			instancia=new ViewTransformer();
		return instancia;
	}
	
	private ViewTransformer(){}
	
	public Articulo converToClass(ArticuloView av){
		Articulo a = new Articulo();
//		a.setCodigo(dto.getCodigo());
//		a.setCodigoDeposito(dto.getCodigoDeposito());
//		a.setDescripcion(dto.getDescripcion());
//		a.setFoto(dto.getFoto());
//		a.setMarca(dto.getMarca());
//		a.setNombre(dto.getNombre());
//		a.setOrigen(dto.getOrigen());
//		a.setPrecio(dto.getPrecio());
		return a;
	}
	
	public Electrodomestico converToClass(ElectrodomesticoView ev){
		Electrodomestico e = new Electrodomestico();
//		e.setCodigo(dto.getCodigo());
//		e.setCodigoDeposito(dto.getCodigoDeposito());
//		e.setDescripcion(dto.getDescripcion());
//		e.setFichaTecnica(dto.getFichaTecnica());
//		e.setFoto(dto.getFoto());
//		e.setMarca(dto.getMarca());
//		e.setNombre(dto.getNombre());
//		e.setOrigen(dto.getOrigen());
//		e.setPrecio(dto.getPrecio());
		return e;
	}
	

	public Infantil converToClass(InfantilView iv){
		Infantil i = new Infantil();
//		i.setCodigo(dto.getCodigo());
//		i.setCodigoDeposito(dto.getCodigoDeposito());
//		i.setDescripcion(dto.getDescripcion());
//		i.setEdadRecomendada(dto.getEdadRecomendada());
//		i.setFoto(dto.getFoto());
//		i.setMarca(dto.getMarca());
//		i.setNombre(dto.getNombre());
//		i.setOrigen(dto.getOrigen());
//		i.setPrecio(dto.getPrecio());
		return i;
	}
	

	public Moda converToClass(ModaView mv){
		Moda m = new Moda();
//		m.setCodigo(dto.getCodigo());
//		m.setCodigoDeposito(dto.getCodigoDeposito());
//		m.setColor(dto.getColor());
//		m.setDescripcion(dto.getDescripcion());
//		m.setFoto(dto.getFoto());
//		m.setMarca(dto.getMarca());
//		m.setNombre(dto.getNombre());
//		m.setOrigen(dto.getOrigen());
//		m.setPrecio(dto.getPrecio());
//		m.setTalle(dto.getTalle());
		return m;
	}
	

	public Mueble converToClass(MuebleView mv){
		Mueble m = new Mueble();
//		m.setCodigo(dto.getCodigo());
//		m.setCodigoDeposito(dto.getCodigoDeposito());
//		m.setDescripcion(dto.getDescripcion());
//		m.setFoto(dto.getFoto());
//		m.setMarca(dto.getMarca());
//		m.setMaterial(dto.getMaterial());
//		m.setNombre(dto.getNombre());
//		m.setOrigen(dto.getOrigen());
//		m.setPrecio(dto.getPrecio());
		return m;
	}
	
	public SolicitudCompra converToClass(SolicitudCompraView scv){
		SolicitudCompra solicitud = new SolicitudCompra();
//		solicitud.setCodigo(dto.getCodigo());
//		solicitud.setFechaInicio(dto.getFechaInicio());
//		solicitud.setFechaFin(dto.getFechaFin());
//		
//		for(ItemSolicitudCompraDTO item:dto.getArticulos()){
//			solicitud.getArticulos().add(this.converToClass(item));
//		}
		
		return solicitud;
	}
	
	private ItemSolicitudCompra converToClass(SolicitudArticulosItemView iscv){
		ItemSolicitudCompra item = new ItemSolicitudCompra();
//		item.setArticulo(articuloDAO.find(dto.getCodArticulo()));
//		item.setCantidad(dto.getCantidad());
		return item;
	}
	
//	private void setArticuloDTO(Articulo a, ArticuloDTO dto){
//		dto.setCodigo(a.getCodigo());
//		dto.setCodigoDeposito(6L);
//		dto.setDescripcion(a.getDescripcion());
//		dto.setFecha(new Timestamp(new java.util.Date().getTime()).toString());
//		dto.setFoto(a.getFoto());
//		dto.setMarca(a.getMarca());
//		dto.setNombre(a.getNombre());
//		dto.setOrigen(a.getOrigen());
//		dto.setPrecio(a.getPrecio());
//	}
	
	public MuebleView toView(Mueble m){
		MuebleView view=new MuebleView();
//		setArticuloDTO(m, mDTO);		
//		mDTO.setMaterial(m.getMaterial());
		return view;
	}
	
	public InfantilView toView(Infantil i){
		InfantilView view=new InfantilView();
//		setArticuloDTO(i, iDTO);		
//		iDTO.setEdadRecomendada(i.getEdadRecomendada());
		return view;
	}
	
	public ModaView toView(Moda m){
		ModaView view=new ModaView();
//		setArticuloDTO(m, mDTO);
//		mDTO.setColor(m.getColor());
//		mDTO.setTalle(m.getTalle());		
		return view;
	}

	public ElectrodomesticoView toView(Electrodomestico e) {
		ElectrodomesticoView view=new ElectrodomesticoView();
//		setArticuloDTO(e, eDTO);		
//		eDTO.setFichaTecnica(e.getFichaTecnica());		
		return view;	
	}

	public SolicitudCompraView toView(SolicitudCompra solicitud){
		SolicitudCompraView scv = new SolicitudCompraView();
//		dto.setCodigo(solicitud.getCodigo());
//		dto.setFechaInicio(solicitud.getFechaInicio());
//		dto.setFechaFin(solicitud.getFechaFin());
//		
//		for(ItemSolicitudCompra i:solicitud.getArticulos()){
//			dto.getArticulos().add(this.toView(i));
//		}
		return scv;
	}
	
//	private ItemSolicitudCompraView toView(ItemSolicitudCompra item){
//		ItemSolicitudCompraDTO dto = new ItemSolicitudCompraDTO();
//		dto.setCantidad(item.getCantidad());
//		dto.setCodArticulo(item.getId());
//		dto.setNomArticulo(item.getArticulo().getNombre());
//		return dto;
//	}

}
