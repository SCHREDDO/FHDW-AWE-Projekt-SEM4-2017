package models;

public class AdministrationEmployee extends Person{
	private int aeid;
	private String task_area;
	
	public AdministrationEmployee() {
		super();
	}
	
	
	
	public int getAeid() {
		return aeid;
	}
	public void setAeid(int aeid) {
		this.aeid = aeid;
	}
	public String getTask_area() {
		return task_area;
	}
	public void setTask_area(String task_area) {
		this.task_area = task_area;
	}
}