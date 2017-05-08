package models;

public class Lecturer extends Person{
	private int leid;
	private Boolean is_honouree_lecturer;
	
	public Lecturer() {
		super();
	}
	
	
	
	public int getLeid() {
		return leid;
	}
	public void setLeid(int leid) {
		this.leid = leid;
	}
	public Boolean getIs_honouree_lecturer() {
		return is_honouree_lecturer;
	}
	public void setIs_honouree_lecturer(Boolean is_honouree_lecturer) {
		this.is_honouree_lecturer = is_honouree_lecturer;
	}
}
