package models;

public class Modul {
	private int moid;
	private String name;
	private String shortName;
	private int creditpoints;
	
	public Modul(){
		
	}
	
	
	
	public int getMoid() {
		return moid;
	}
	public void setMoid(int moid) {
		this.moid = moid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShort_name(String shortName) {
		this.shortName = shortName;
	}
	public int getCreditpoints() {
		return creditpoints;
	}
	public void setCreditpoints(int creditpoints) {
		this.creditpoints = creditpoints;
	}
}