package helper;

import models.*;

public class ConvertObjectAndClass {
	public AdministrationEmployee ConvertToAdministrationEmployee(Object[] obj)
	{
		AdministrationEmployee temp = new AdministrationEmployee();
		
		temp.setPeid(obj[0]);
		temp.setFirstname(obj[1]);
		temp.setLarstname(obj[2]);
		temp.setShortname(obj[3]);
		temp.setRight(obj[4]);
		temp.setE_mail(obj[5]);
		temp.setPassword(obj[6]);
		temp.setAddreass(obj[7]);
		temp.setPhoneNumber(obj[8]);
		temp.setAeid(obj[9]);
		temp.setTask_area(obj[10]);
		
		return temp;
	}
	
	public Lecturer ConvertToLecturer(Object[] obj)
	{
		Lecturer temp = new Lecturer();
		
		temp.setPeid(obj[0]);
		temp.setFirstname(obj[1]);
		temp.setLarstname(obj[2]);
		temp.setShortname(obj[3]);
		temp.setRight(obj[4]);
		temp.setE_mail(obj[5]);
		temp.setPassword(obj[6]);
		temp.setAddreass(obj[7]);
		temp.setPhoneNumber(obj[8]);
		temp.setLeid(obj[9]);
		temp.setIs_honouree_lecturer(obj[10]);
		
		return temp;
	}
	
	public Modul ConvertToModul(Object[] obj)
	{
		Modul temp = new Modul();
		
		return temp;
	}
	
	public ModulLecturer ConvertToModulLecturer(Object[] obj)
	{
		ModulLecturer temp = new ModulLecturer();
		
		return temp;
	}
	
	public Right ConvertToRight(Object[] obj)
	{
		Right temp = new Right();
		
		return temp;
	}
	
	public Student ConvertToStudent(Object[] obj)
	{
		Student temp = new Student();
		
		temp.setPeid(obj[0]);
		temp.setFirstname(obj[1]);
		temp.setLarstname(obj[2]);
		temp.setShortname(obj[3]);
		temp.setRight(obj[4]);
		temp.setE_mail(obj[5]);
		temp.setPassword(obj[6]);
		temp.setAddreass(obj[7]);
		temp.setPhoneNumber(obj[8]);
		temp.setStid(obj[9]);
		temp.setMatrikelnumber(obj[10]);
		
		return temp;
	}
	
	public StudyGroup ConvertToStudyGroup(Object[] obj)
	{
		StudyGroup temp = new StudyGroup();
		
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	public Object[] ConvertToAdministrationEmployee(AdministrationEmployee obj)
	{
		Object[] temp = new Object[];
		
		temp.setPeid(obj[0]);
		temp.setFirstname(obj[1]);
		temp.setLarstname(obj[2]);
		temp.setShortname(obj[3]);
		temp.setRight(obj[4]);
		temp.setE_mail(obj[5]);
		temp.setPassword(obj[6]);
		temp.setAddreass(obj[7]);
		temp.setPhoneNumber(obj[8]);
		temp.setAeid(obj[9]);
		temp.setTask_area(obj[10]);
		
		return temp;
	}
	
	public Object[] ConvertToLecturer(Lecturer obj)
	{
		Object[] temp = new Object[];
		
		temp.setPeid(obj[0]);
		temp.setFirstname(obj[1]);
		temp.setLarstname(obj[2]);
		temp.setShortname(obj[3]);
		temp.setRight(obj[4]);
		temp.setE_mail(obj[5]);
		temp.setPassword(obj[6]);
		temp.setAddreass(obj[7]);
		temp.setPhoneNumber(obj[8]);
		temp.setLeid(obj[9]);
		temp.setIs_honouree_lecturer(obj[10]);
		
		return temp;
	}
	
	public Object[] ConvertToModul(Modul obj)
	{
		Object[] temp = new Object[];
		
		return temp;
	}
	
	public Object[] ConvertToModulLecturer(ModulLecturer obj)
	{
		Object[] temp = new Object[];
		
		return temp;
	}
	
	public Object[] ConvertToRight(Right obj)
	{
		Object[] temp = new Object[];
		
		return temp;
	}
	
	public Object[] ConvertToStudent(Student obj)
	{
		Object[] temp = new Object[];
		
		temp.setPeid(obj[0]);
		temp.setFirstname(obj[1]);
		temp.setLarstname(obj[2]);
		temp.setShortname(obj[3]);
		temp.setRight(obj[4]);
		temp.setE_mail(obj[5]);
		temp.setPassword(obj[6]);
		temp.setAddreass(obj[7]);
		temp.setPhoneNumber(obj[8]);
		temp.setStid(obj[9]);
		temp.setMatrikelnumber(obj[10]);
		
		return temp;
	}
	
	public Object[] ConvertToStudyGroup(StudyGroup obj)
	{
		Object[] temp = new Object[];
		
		return temp;
	}
}
