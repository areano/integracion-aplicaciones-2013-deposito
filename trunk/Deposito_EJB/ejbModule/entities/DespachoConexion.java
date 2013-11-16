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
}
