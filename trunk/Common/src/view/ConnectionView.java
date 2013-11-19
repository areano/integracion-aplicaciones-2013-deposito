package view;

import java.io.Serializable;

public class ConnectionView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int moduleId;
	private boolean active;
	private String ip;
	boolean syncronic;
	public ConnectionView(){};
	public ConnectionView(int moduleId, boolean active, String ip,
			boolean syncronic) {
		super();
		this.moduleId = moduleId;
		this.active = active;
		this.ip = ip;
		this.syncronic = syncronic;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
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

	public boolean isSyncronic() {
		return syncronic;
	}
	public void setSyncronic(boolean syncronic) {
		this.syncronic = syncronic;
	}
	
}