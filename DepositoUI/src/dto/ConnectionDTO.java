package dto;

public class ConnectionDTO {

	private String IP;
	private String ID;
	private boolean active;
	private boolean synchronic;
	private String type;
	
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isSynchronic() {
		return synchronic;
	}
	public void setSynchronic(boolean synchronic) {
		this.synchronic = synchronic;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
