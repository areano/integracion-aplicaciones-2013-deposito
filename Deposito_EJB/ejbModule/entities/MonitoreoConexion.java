package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MonitoreoConexion")
public class MonitoreoConexion {

	@Id
	private int monitoreoId;
	private boolean active;
	private boolean syncronico;
	private String ip;
	private String puerto;
	private String queueName;
	private String wsPath;
	private String wsPuerto;
	private String usuario;
	private String password;
	
	
	public MonitoreoConexion(){}

	public int getMonitoreoId() {
		return monitoreoId;
	}

	public void setMonitoreoId(int monitoreoId) {
		this.monitoreoId = monitoreoId;
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

	public boolean isSyncronico() {
		return syncronico;
	}

	public void setSyncronico(boolean syncronico) {
		this.syncronico = syncronico;
	}

	public String getWsPath() {
		return wsPath;
	}

	public void setWsPath(String wsPath) {
		this.wsPath = wsPath;
	}

	public String getWsPuerto() {
		return wsPuerto;
	}

	public void setWsPuerto(String wsPuerto) {
		this.wsPuerto = wsPuerto;
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
