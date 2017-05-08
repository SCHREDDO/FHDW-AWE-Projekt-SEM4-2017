package models;

import java.util.List;

public class StudyGroup {
	
	private int sgid;
	private String shortName;
	private List<ModulLecturer> modulLecturer;
	
	public StudyGroup(){
		
	}
	
	

	public int getSgid() {
		return sgid;
	}
	public void setSgid(int sgid) {
		this.sgid = sgid;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public List<ModulLecturer> getModule() {
		return modulLecturer;
	}
	public void setModule(List<ModulLecturer> modulLecturer) {
		this.modulLecturer = modulLecturer;
	}
}