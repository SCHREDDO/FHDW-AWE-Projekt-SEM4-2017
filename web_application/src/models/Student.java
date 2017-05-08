package models;

public class Student extends Person{
	
	private int stid;
	private int matrikelnumber;
	private StudyGroup group;
	
	public Student() {
		super();
	}
	
	
	
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public int getMatrikelnumber() {
		return matrikelnumber;
	}
	public void setMatrikelnumber(int matrikelnumber) {
		this.matrikelnumber = matrikelnumber;
	}
	public StudyGroup getGroup() {
		return this.group;
	}
	public void setGroup(StudyGroup group) {
		this.group = group;
	}
}
