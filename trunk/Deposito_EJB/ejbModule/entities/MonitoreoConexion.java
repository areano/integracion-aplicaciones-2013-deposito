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
}
