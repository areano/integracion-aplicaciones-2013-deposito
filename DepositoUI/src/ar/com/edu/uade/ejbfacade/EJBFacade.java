package ar.com.edu.uade.ejbfacade;

import java.util.ArrayList;
import java.util.Collection;

import dto.ArticuloDTO;
import dto.ConnectionDTO;
import dto.ElectrodomesticoDTO;
import dto.ItemSolicitudCompra;
import dto.ModaDTO;
import dto.SolicitudCompraDTO;

public class EJBFacade {

	
	public ArrayList<ConnectionDTO> getPortalConections(){
		
		ArrayList<ConnectionDTO> retorno = new ArrayList<ConnectionDTO>();
		ConnectionDTO dto = new ConnectionDTO();
		for (int i = 0; i < 9; i++) {
			dto.setID(String.valueOf(i));
			dto.setActive(true);
			dto.setType("PORTAL");
			dto.setID("192.168.0."+String.valueOf(i));
			dto.setSynchronic(false);
			retorno.add(dto);
		}
		return retorno;
		
	}
	public ArrayList<ConnectionDTO> getDespachoConnection(){
		ArrayList<ConnectionDTO> retorno = new ArrayList<ConnectionDTO>();
		ConnectionDTO dto = new ConnectionDTO();
		for (int i = 0; i < 9; i++) {
			dto.setID(String.valueOf(i));
			dto.setActive(true);
			dto.setType("DESPACHO");
			dto.setID("192.168.1."+String.valueOf(i));
			dto.setSynchronic(false);
			retorno.add(dto);
		}
		return retorno;
	}
	public ArrayList<ConnectionDTO> getMonitoreoConnection(){
		ArrayList<ConnectionDTO> retorno = new ArrayList<ConnectionDTO>();
		ConnectionDTO dto = new ConnectionDTO();
		for (int i = 0; i < 9; i++) {
			dto.setID(String.valueOf(i));
			dto.setActive(true);
			dto.setType("MONITOREO");
			dto.setID("192.168.2."+String.valueOf(i));			
			dto.setSynchronic(false);
			retorno.add(dto);
		}
		return retorno;
	}
	public ArrayList<ConnectionDTO> getFabricaConnection(){
		ArrayList<ConnectionDTO> retorno = new ArrayList<ConnectionDTO>();
		ConnectionDTO dto = new ConnectionDTO();
		for (int i = 0; i < 9; i++) {
			dto.setID(String.valueOf(i));
			dto.setActive(true);
			dto.setType("FABRICA");
			dto.setID("192.168.3."+String.valueOf(i));			
			dto.setSynchronic(false);
			retorno.add(dto);
		}
		return retorno;
	}
	public ArrayList<SolicitudCompraDTO> getSolicitudesDeCompra(){		
		
		ElectrodomesticoDTO electro =new ElectrodomesticoDTO();
		ModaDTO moda =  new ModaDTO();
		electro.setCodigo(Long.valueOf(1));
		electro.setDescripcion("Un electro");
		electro.setFichaTecnica("una url");
		electro.setMarca("Modila");
		electro.setNombre("Supercalifragitisticoespiralidoso");
		electro.setOrigen("Tierra cdel fuego");
		electro.setPrecio(Float.valueOf((float) 12.5));
		
		moda.setCodigo(Long.valueOf(1));
		moda.setDescripcion("una remera");
		moda.setTalle("XL");
		moda.setMarca("Mota");
		moda.setNombre("Motta inside");
		moda.setOrigen("El Salvador");
		moda.setPrecio(Float.valueOf((float) 12.5));
		moda.setColor("Azul");
		
		ArrayList<SolicitudCompraDTO> solicitudes =  new ArrayList<SolicitudCompraDTO>();
		SolicitudCompraDTO dto = new SolicitudCompraDTO();
		
		dto.setCodigoDespacho(1);
		dto.addItemSolicitudCompra(new ItemSolicitudCompra(electro, 2));
		dto.addItemSolicitudCompra(new ItemSolicitudCompra(moda, 2));
		dto.setDate(new java.util.Date());
		dto.setCodigoSolicitud(1);
		solicitudes.add(dto);
		
		dto = new SolicitudCompraDTO();
		dto.setCodigoDespacho(2);
		dto.setDate(new java.util.Date());
		dto.addItemSolicitudCompra(new ItemSolicitudCompra(electro, 5));
		dto.addItemSolicitudCompra(new ItemSolicitudCompra(moda, 5));
		dto.setCodigoSolicitud(2);
		solicitudes.add(dto);
		
		
		return solicitudes;
	}
	public Collection<? extends ArticuloDTO> getAllArticulos() {
		ArrayList<ArticuloDTO> articulos =  new ArrayList<ArticuloDTO>();
		ElectrodomesticoDTO electro =new ElectrodomesticoDTO();
		ModaDTO moda =  new ModaDTO();
		electro.setCodigo(Long.valueOf(1));
		electro.setDescripcion("Un electro");
		electro.setFichaTecnica("una url");
		electro.setMarca("Modila");
		electro.setNombre("Supercalifragitisticoespiralidoso");
		electro.setOrigen("Tierra cdel fuego");
		electro.setPrecio(Float.valueOf((float) 12.5));
		electro.setFoto("una Foto");
		
		moda.setCodigo(Long.valueOf(1));
		moda.setDescripcion("una remera");
		moda.setTalle("XL");
		moda.setMarca("Mota");
		moda.setNombre("Motta inside");
		moda.setOrigen("El Salvador");
		moda.setPrecio(Float.valueOf((float) 12.5));
		moda.setColor("Azul");
		moda.setFoto("otra Foto");
			
		articulos.add(electro);
		articulos.add(moda);
		return articulos;
	}
}
