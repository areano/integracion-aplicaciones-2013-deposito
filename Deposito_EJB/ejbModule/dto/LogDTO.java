package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "log")
public class LogDTO {
	
	public LogDTO(String mensaje) {
		super();
		this.idModulo=6;
		this.mensaje = mensaje;
		this.fecha=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
	
	public LogDTO(){}
	
	String fecha;
	String mensaje;
	int idModulo;
	
	public String getFecha() {
		return fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public int getIdModulo() {
		return idModulo;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
	
}

