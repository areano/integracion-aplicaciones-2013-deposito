package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DespachoConexion")
public class DespachoConexion {

	@Id
	private int despachoId;
	private boolean active;
	private String ip;
	private String puerto;
	private String queueName;
	private String restPath;
	private String restPort;
	private String usuario;
	private String password;
	
	
	public DespachoConexion(){}

	public int getDespachoId() {
		return despachoId;
	}

	public void setDespachoId(int despachoId) {
		this.despachoId = despachoId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getRestPath() {
		return restPath;
	}

	public void setRestPath(String restPath) {
		this.restPath = restPath;
	}

	public String getRestPort() {
		return restPort;
	}

	public void setRestPort(String restPort) {
		this.restPort = restPort;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
