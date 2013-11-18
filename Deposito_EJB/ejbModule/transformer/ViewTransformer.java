package transformer;

import java.sql.Timestamp;

import javax.ejb.EJB;

import view.ArticuloView;
import view.ElectrodomesticoView;
import view.InfantilView;
import view.ModaView;
import view.MuebleView;
import view.SolicitudArticulosItemView;
import view.SolicitudArticulosView;
import view.SolicitudCompraView;
import dao.ArticuloDAO;
import dao.SolicitudArticulosDAO;
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
import entities.SolicitudArticulos;
import entities.SolicitudArticulosItem;
import entities.SolicitudCompra;

public class ViewTransformer {
	@EJB
	ArticuloDAO articuloDAO;
	
	@EJB
	SolicitudArticulosDAO solicitudArticulosDAO;
	
	private static ViewTransformer instancia;
	
	public static ViewTransformer obtenerInstancia(){
		if(instancia==null)
			instancia=new ViewTransformer();
		return instancia;
	}
	
	private ViewTransformer(){}
	
	public Articulo converToClass(ArticuloView av){
		Articulo a = new Articulo();
		a.setCodigo(av.getCodigo());
		a.setCodigoDeposito(av.getCodigoDeposito());
		a.setDescripcion(av.getDescripcion());
		a.setFoto(av.getFoto());
		a.setMarca(av.getMarca());
		a.setNombre(av.getNombre());
		a.setOrigen(av.getOrigen());
		a.setPrecio(av.getPrecio());
		return a;
	}
	
	public Electrodomestico converToClass(ElectrodomesticoView ev){
		Electrodomestico e = new Electrodomestico();
		e.setCodigo(ev.getCodigo());
		e.setCodigoDeposito(ev.getCodigoDeposito());
		e.setDescripcion(ev.getDescripcion());
		e.setFichaTecnica(ev.getFichaTecnica());
		e.setFoto(ev.getFoto());
		e.setMarca(ev.getMarca());
		e.setNombre(ev.getNombre());
		e.setOrigen(ev.getOrigen());
		e.setPrecio(ev.getPrecio());
		return e;
	}
	

	public Infantil converToClass(InfantilView iv){
		Infantil i = new Infantil();
		i.setCodigo(iv.getCodigo());
		i.setCodigoDeposito(iv.getCodigoDeposito());
		i.setDescripcion(iv.getDescripcion());
		i.setEdadRecomendada(iv.getEdadRecomendada());
		i.setFoto(iv.getFoto());
		i.setMarca(iv.getMarca());
		i.setNombre(iv.getNombre());
		i.setOrigen(iv.getOrigen());
		i.setPrecio(iv.getPrecio());
		return i;
	}
	

	public Moda converToClass(ModaView mv){
		Moda m = new Moda();
		m.setCodigo(mv.getCodigo());
		m.setCodigoDeposito(mv.getCodigoDeposito());
		m.setColor(mv.getColor());
		m.setDescripcion(mv.getDescripcion());
		m.setFoto(mv.getFoto());
		m.setMarca(mv.getMarca());
		m.setNombre(mv.getNombre());
		m.setOrigen(mv.getOrigen());
		m.setPrecio(mv.getPrecio());
		m.setTalle(mv.getTalle());
		return m;
	}
	

	public Mueble converToClass(MuebleView mv){
		Mueble m = new Mueble();
		m.setCodigo(mv.getCodigo());
		m.setCodigoDeposito(mv.getCodigoDeposito());
		m.setDescripcion(mv.getDescripcion());
		m.setFoto(mv.getFoto());
		m.setMarca(mv.getMarca());
		m.setMaterial(mv.getMaterial());
		m.setNombre(mv.getNombre());
		m.setOrigen(mv.getOrigen());
		m.setPrecio(mv.getPrecio());
		return m;
	}
	

	private void setArticuloView(Articulo a, ArticuloView view){
		view.setCodigo(a.getCodigo());
		view.setCodigoDeposito(6L);
		view.setDescripcion(a.getDescripcion());
//		view.setFecha(new Timestamp(new java.util.Date().getTime()).toString());
		view.setFoto(a.getFoto());
		view.setMarca(a.getMarca());
		view.setNombre(a.getNombre());
		view.setOrigen(a.getOrigen());
		view.setPrecio(a.getPrecio());
	}
	
	public MuebleView toView(Mueble m){
		MuebleView view=new MuebleView();
		setArticuloView(m, view);		
		view.setMaterial(m.getMaterial());
		return view;
	}
	
	public InfantilView toView(Infantil i){
		InfantilView view=new InfantilView();
		setArticuloView(i, view);		
		view.setEdadRecomendada(i.getEdadRecomendada());
		return view;
	}
	
	public ModaView toView(Moda m){
		ModaView view=new ModaView();
		setArticuloView(m, view);
		view.setColor(m.getColor());
		view.setTalle(m.getTalle());		
		return view;
	}

	public ElectrodomesticoView toView(Electrodomestico e) {
		ElectrodomesticoView view=new ElectrodomesticoView();
		setArticuloView(e, view);		
		view.setFichaTecnica(e.getFichaTecnica());		
		return view;	
	}

	public SolicitudCompraView toView(SolicitudCompra solicitud){
		SolicitudCompraView view = new SolicitudCompraView();
		view.setCodigoSolicitud(solicitud.getCodigo());
		if (solicitud.getFechaFin()==null){
			//TODO: MF set no entregado.			
		}else {
			//TODO: MF set entregado.
		}
		
		for(ItemSolicitudCompra i:solicitud.getArticulos()){
			view.getArticulos().add(toView(i));
		}
		return view;
	}
	

	
		public SolicitudCompra converToClass(SolicitudCompraView scv){
		SolicitudCompra solicitud = new SolicitudCompra();
		solicitud.setCodigo(scv.getCodigoSolicitud());
		solicitud.setFechaInicio(scv.getDate());
		// TODO: MF falta agregar aca la fecha fin.
		for(SolicitudArticulosItemView item:scv.getArticulos()){
			solicitud.getArticulos().add(this.converToClass(item));
		}
		
		return solicitud;
	}

	private ItemSolicitudCompra converToClass(SolicitudArticulosItemView iscv){
		ItemSolicitudCompra item = new ItemSolicitudCompra();
		item.setArticulo(articuloDAO.find(iscv.getArticulo().getCodigo()));
		item.setCantidad(iscv.getCantidad());
		return item;
	}

		public SolicitudArticulos converToClass(SolicitudArticulosView scv){
		SolicitudArticulos solicitud = new SolicitudArticulos();
		solicitud=solicitudArticulosDAO.buscarSolicitud(scv.getCodigoSolicitud());		
		return solicitud;
	}

	private SolicitudArticulosItem converToSolicitudArticulosItem(SolicitudArticulosItemView iscv){
		SolicitudArticulosItem item = new SolicitudArticulosItem();
		item.setArticulo(articuloDAO.find(iscv.getArticulo().getCodigo()));
		item.setCantidad(iscv.getCantidad());
		return item;
	}

	
	private SolicitudArticulosItemView toView(ItemSolicitudCompra item){
		
		Articulo a= item.getArticulo();
		ArticuloView av=null;
		if (a.getClass()== Infantil.class){
			av=toView((Infantil)a);
		}else if (a.getClass()== Electrodomestico.class){
			av=toView((Electrodomestico)a);
		}else if (a.getClass()== Mueble.class){
			av=toView((Mueble)a);
		}else if (a.getClass()== Moda.class){
			av=toView((Moda)a);
		}
		
		SolicitudArticulosItemView view = new SolicitudArticulosItemView(av,item.getCantidad());
		return view;
	}

}
