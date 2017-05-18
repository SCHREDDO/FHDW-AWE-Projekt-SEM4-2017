package models;

public class User {
	
	private String shortname;
	private int pid;
	
	public User()
	{
		this.shortname = "";
		this.pid = 0;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
