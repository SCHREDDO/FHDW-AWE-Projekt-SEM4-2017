package models;

public class Permission {
	
	private int pid;
	private String name;

	public Permission(){
		pid = 0;
		name = "";
	}
	
	
	public int getRiid() {
		return pid;
	}
	public void setRiid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
