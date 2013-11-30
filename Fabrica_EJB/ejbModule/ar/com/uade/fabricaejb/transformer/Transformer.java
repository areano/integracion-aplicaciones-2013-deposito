package ar.com.uade.fabricaejb.transformer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ar.com.uade.fabricaejb.entities.ItemSolicitudCompra;
import ar.com.uade.fabricaejb.entities.SolicitudCompra;
import dto.ItemSolicitudCompraDTO;
import dto.SolicitudCompraDTO;

/**
 * Session Bean implementation class Transformer
 */
@Stateless
@LocalBean
public class Transformer {

    /**
     * Default constructor. 
     */
    public Transformer() {
        // TODO Auto-generated constructor stub
    }
    
    public SolicitudCompra getEntity(SolicitudCompraDTO compra) {

		SolicitudCompra entity = new SolicitudCompra();

		entity.setCodigo(compra.getCodigo());

		for (ItemSolicitudCompraDTO item : compra.getArticulos()) {

			ItemSolicitudCompra itemEntity = new ItemSolicitudCompra();

			itemEntity.setCodArticulo(item.getCodArticulo());
			itemEntity.setNombreArticulo(item.getNomArticulo());
			itemEntity.setCantidad(item.getCantidad());

			entity.getItemArticulos().add(itemEntity);

		}

		return entity;
	}
	
    public SolicitudCompraDTO toDTO(SolicitudCompra solicitud){
		SolicitudCompraDTO dto = new SolicitudCompraDTO();
		dto.setCodigo(solicitud.getCodigo());
		dto.setFechaInicio(solicitud.getFechaInicio());
		dto.setFechaFin(solicitud.getFechaFin());
		
		for(ItemSolicitudCompra i:solicitud.getItemArticulos()){
			dto.getArticulos().add(this.toDTO(i));
		}
		return dto;
	}
	
    public ItemSolicitudCompraDTO toDTO(ItemSolicitudCompra item){
		ItemSolicitudCompraDTO dto = new ItemSolicitudCompraDTO();
		dto.setCantidad(item.getCantidad());
		dto.setCodArticulo(item.getCodArticulo());
		dto.setNomArticulo("sin nombre");
		return dto;
	}

}
