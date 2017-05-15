package helper;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class ConvertObjectAndClass {
	public AdministrationEmployee ConvertToAdministrationEmployee(Object[] obj)
	{
		AdministrationEmployee temp = new AdministrationEmployee();
		
		temp.setPeid((int)obj[0]);
		temp.setFirstname((String)obj[1]);
		temp.setLarstname((String)obj[2]);
		temp.setShortname((String)obj[3]);
		Permission r = new Permission();
		r.setRiid((int)obj[4]);
		temp.setRight(r);
		temp.setE_mail((String)obj[5]);
		temp.setPassword((String)obj[6]);
		temp.setAddreass((String)obj[7]);
		temp.setPhoneNumber((int)obj[8]);
		temp.setAeid((int)obj[9]);
		temp.setTask_area((String)obj[10]);
		
		return temp;
	}
	
	public Lecturer ConvertToLecturer(Object[] obj)
	{
		Lecturer temp = new Lecturer();
		
		temp.setPeid((int)obj[0]);
		temp.setFirstname((String)obj[1]);
		temp.setLarstname((String)obj[2]);
		temp.setShortname((String)obj[3]);
		Permission r = new Permission();
		r.setRiid((int)obj[4]);
		temp.setRight(r);
		temp.setE_mail((String)obj[5]);
		temp.setPassword((String)obj[6]);
		temp.setAddreass((String)obj[7]);
		temp.setPhoneNumber((int)obj[8]);
		temp.setLeid((int)obj[9]);
		temp.setIs_honouree_lecturer((boolean)obj[10]);
		
		return temp;
	}
	
	public Modul ConvertToModul(Object[] obj)
	{
		Modul temp = new Modul();
		
		temp.setMoid((int)obj[0]);
		temp.setName((String)obj[0]);
		temp.setShort_name((String)obj[0]);
		temp.setCreditpoints((int)obj[0]);
		
		return temp;
	}
	
	public ModulLecturer ConvertToModulLecturer(Object[] obj)
	{
		ModulLecturer temp = new ModulLecturer();
		
		temp.setMlid((int)obj[0]);
		Modul m = new Modul();
		m.setMoid((int)obj[1]);
		temp.setModul(m);
		Lecturer l = new Lecturer();
		l.setLeid((int)obj[2]);
		temp.setLecturer(l);
		
		return temp;
	}
	
	public Permission ConvertToRight(Object[] obj)
	{
		Permission temp = new Permission();
		
		temp.setRiid((int)obj[0]);
		temp.setName((String)obj[0]);
		
		return temp;
	}
	
	public Student ConvertToStudent(Object[] obj)
	{
		Student temp = new Student();
		
		temp.setPeid((int)obj[0]);
		temp.setFirstname((String)obj[1]);
		temp.setLarstname((String)obj[2]);
		temp.setShortname((String)obj[3]);
		Permission r = new Permission();
		r.setRiid((int)obj[4]);
		temp.setRight(r);
		temp.setE_mail((String)obj[5]);
		temp.setPassword((String)obj[6]);
		temp.setAddreass((String)obj[7]);
		temp.setPhoneNumber((int)obj[8]);
		temp.setStid((int)obj[9]);
		StudyGroup s = new StudyGroup();
		s.setSgid((int)obj[11]);
		s.setShortName((String)obj[12]);
		temp.setGroup(s);
		temp.setMatrikelnumber((int)obj[10]);
		
		return temp;
	}
	
	public StudyGroup ConvertToStudyGroup(Object[] obj)
	{
		StudyGroup temp = new StudyGroup();
		
		temp.setSgid((int)obj[0]);
		temp.setShortName((String)obj[1]);
		
		return temp;
	}
	
	public Object[] ConvertToAdministrationEmployee(AdministrationEmployee obj)
	{
		Object[] temp = new Object[11];
		
		temp[0] = obj.getPeid();
		temp[1] = obj.getFirstname();
		temp[2] = obj.getLarstname();
		temp[3] = obj.getShortname();
		temp[4] = obj.getRight().getRiid();
		temp[5] = obj.getE_mail();
		temp[6] = obj.getPassword();
		temp[7] = obj.getAddreass();
		temp[8] = obj.getPhoneNumber();
		temp[9] = obj.getAeid();
		temp[10] = obj.getTask_area();		
		
		return temp;
	}
	
	public Object[] ConvertToLecturer(Lecturer obj)
	{
		Object[] temp = new Object[11];
		
		temp[0] = obj.getPeid();
		temp[1] = obj.getFirstname();
		temp[2] = obj.getLarstname();
		temp[3] = obj.getShortname();
		temp[4] = obj.getRight().getRiid();
		temp[5] = obj.getE_mail();
		temp[6] = obj.getPassword();
		temp[7] = obj.getAddreass();
		temp[8] = obj.getPhoneNumber();
		temp[9] = obj.getLeid();
		temp[10] = obj.getIs_honouree_lecturer() ? 1 : 0;;
		
		return temp;
	}
	
	public Object[] ConvertToModul(Modul obj)
	{
		Object[] temp = new Object[4];
		
		temp[0] = obj.getMoid();
		temp[1] = obj.getName();
		temp[2] = obj.getShortName();
		temp[3] = obj.getCreditpoints();
		
		return temp;
	}
	
	public Object[] ConvertToModulLecturer(ModulLecturer obj)
	{
		Object[] temp = new Object[3];
		
		temp[0] = obj.getMlid();
		temp[1] = obj.getModul().getMoid();
		temp[2] = obj.getLecturer().getLeid();
		
		return temp;
	}
	
	public Object[] ConvertToRight(Permission obj)
	{
		Object[] temp = new Object[2];
		
		temp[0] = obj.getRiid();
		temp[1] = obj.getName();
		
		return temp;
	}
	
	public Object[] ConvertToStudent(Student obj)
	{
		Object[] temp = new Object[11];
		
		temp[0] = obj.getPeid();
		temp[1] = obj.getFirstname();
		temp[2] = obj.getLarstname();
		temp[3] = obj.getShortname();
		temp[4] = obj.getRight().getRiid();
		temp[5] = obj.getE_mail();
		temp[6] = obj.getPassword();
		temp[7] = obj.getAddreass();
		temp[8] = obj.getPhoneNumber();
		temp[9] = obj.getStid();
		temp[10] = obj.getMatrikelnumber();
		
		return temp;
	}
	
	public Object[] ConvertToStudyGroup(StudyGroup obj)
	{
		Object[] temp = new Object[2];
		
		temp[0] = obj.getSgid();
		temp[1] = obj.getShortName();
		
		return temp;
	}
}