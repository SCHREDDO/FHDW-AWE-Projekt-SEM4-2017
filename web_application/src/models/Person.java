package models;

public class Person {
	
	private int peid;
	private String firstname;
	private String larstname;
	private String shortname;
	private Right right;
	private String e_mail;
	private String password;
	private String addreass;
	private int phoneNumber;

	public Person()
	{
		peid = 0;
		firstname = "";
		larstname = "";
		shortname = "";
		right = new Right();
		e_mail = "";
		password = "";
		addreass = "";
		phoneNumber = 0;
	}
	
	
	
	public int getPeid() {
		return peid;
	}
	public void setPeid(int peid) {
		this.peid = peid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLarstname() {
		return larstname;
	}
	public void setLarstname(String larstname) {
		this.larstname = larstname;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public Right getRight() {
		return right;
	}
	public void setRight(Right right) {
		this.right = right;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddreass() {
		return addreass;
	}
	public void setAddreass(String addreass) {
		this.addreass = addreass;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
