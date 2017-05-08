package models;

public class ModulLecturer {
	
	private Modul modul;
	private Lecturer lecturer;
	
	public ModulLecturer()
	{
		
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
