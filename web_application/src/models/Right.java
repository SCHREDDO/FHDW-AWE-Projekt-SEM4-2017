package models;

public class Right {
	
	private int riid;
	private String name;

	public Right(){
		riid = 0;
		name = "";
	}
	
	
	public int getRiid() {
		return riid;
	}
	public void setRiid(int riid) {
		this.riid = riid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
