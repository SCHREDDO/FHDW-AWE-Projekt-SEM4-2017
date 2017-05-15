package models;

public class ModulLecturer {
	
	private int mlid;
	private Modul modul;
	private Lecturer lecturer;
	
	public ModulLecturer()
	{
		modul = new Modul();
		lecturer = new Lecturer();
	}
	
	
	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public Modul getModul() {
		return modul;
	}
	public void setModul(Modul modul) {
		this.modul = modul;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
}
