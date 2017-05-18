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
		temp.setFirstname((String)obj[2]);
		temp.setLarstname((String)obj[3]);
		temp.setShortname((String)obj[4]);
		Permission r = new Permission();
		r.setRiid((int)obj[1]);
		temp.setRight(r);
		temp.setPassword((String)obj[5]);
		temp.setE_mail((String)obj[6]);
		temp.setAddreass((String)obj[7]);
		temp.setPhoneNumber((int)obj[8]);
		temp.setLeid((int)obj[9]);
		if ((int)obj[10] == 1) {
			temp.setIs_honouree_lecturer(true);
		} else {
			temp.setIs_honouree_lecturer(false);
		}
		
		
		return temp;
	}
	
	public Modul ConvertToModul(Object[] obj)
	{
		Modul temp = new Modul();
		
		temp.setMoid((int)obj[0]);
		temp.setName((String)obj[1]);
		temp.setShort_name((String)obj[2]);
		temp.setCreditpoints((int)obj[3]);
		
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
		temp.setName((String)obj[1]);
		
		return temp;
	}
	
	public Student ConvertToStudent(Object[] obj)
	{
		Student temp = new Student();
		
		temp.setPeid((int)obj[0]);
		temp.setFirstname((String)obj[2]);
		temp.setLarstname((String)obj[3]);
		temp.setShortname((String)obj[4]);
		Permission r = new Permission();
		r.setRiid((int)obj[1]);
		temp.setRight(r);
		temp.setPassword((String)obj[5]);
		temp.setE_mail((String)obj[6]);
		temp.setAddreass((String)obj[7]);
		temp.setPhoneNumber((int)obj[8]);
		temp.setStid((int)obj[9]);
		StudyGroup s = new StudyGroup();
		s.setSgid((int)obj[10]);
		s.setShortName((String)obj[13]);
		temp.setGroup(s);
		temp.setMatrikelnumber((int)obj[11]);
		
		return temp;
	}
	
	public StudyGroup ConvertToStudyGroup(Object[] obj)
	{
		StudyGroup temp = new StudyGroup();
		
		temp.setSgid((int)obj[0]);
		temp.setShortName((String)obj[1]);
		
		return temp;
	}
	
	public Person ConvertToPerson(Object[] obj)
	{
		Person temp = new Person();
		
		temp.setPeid((int)obj[0]);
		temp.setFirstname((String)obj[2]);
		temp.setLarstname((String)obj[3]);
		temp.setShortname((String)obj[4]);
		Permission p = new Permission();
		p.setRiid((int)obj[1]);
		temp.setRight(p);
		temp.setPassword((String)obj[5]);
		temp.setE_mail((String)obj[6]);
		temp.setAddreass((String)obj[7]);
		temp.setPhoneNumber((int)obj[8]);
		
		return temp;
	}
	
	public Student ConvertToStudento(Object[] obj)
	{
		Student temp = new Student();
		
		temp.setStid((int)obj[0]);
		temp.setPeid((int)obj[1]);
		StudyGroup studyGroup = new StudyGroup();
		studyGroup.setSgid((int)obj[2]);
		temp.setGroup(studyGroup);
		temp.setMatrikelnumber((int)obj[3]);
		
		return temp;
	}
	
	public AdministrationEmployee ConvertToAdministrationEmployeeo(Object[] obj)
	{
		AdministrationEmployee temp = new AdministrationEmployee();
		
		temp.setAeid((int)obj[0]);
		temp.setPeid((int)obj[1]);
		temp.setTask_area((String)obj[2]);
		
		return temp;
	}
	
	public Lecturer ConvertToLecturero(Object[] obj)
	{
		Lecturer temp = new Lecturer();
		
		temp.setLeid((int)obj[0]);
		temp.setPeid((int)obj[1]);
		if ((int)obj[2] == 1) 
		{
			temp.setIs_honouree_lecturer(true);
		}
		else
		{
			temp.setIs_honouree_lecturer(false);
		}
		
		return temp;
	}
	
	public Object[] ConvertToStudento(Student obj)
	{
		Object[] temp = new Object[11];
		
		temp[0] = obj.getStid();
		temp[1] = obj.getPeid();
		temp[2] = obj.getGroup().getSgid();
		temp[3] = obj.getMatrikelnumber();
		
		return temp;
	}
	
	public Object[] ConvertToAdministrationEmployeeo(AdministrationEmployee obj)
	{
		Object[] temp = new Object[11];
		
		temp[0] = obj.getAeid();
		temp[1] = obj.getPeid();
		temp[2] = obj.getTask_area();
		
		return temp;
	}
	
	public Object[] ConvertToLecturero(Lecturer obj)
	{
		Object[] temp = new Object[11];
		
		temp[0] = obj.getLeid();
		temp[1] = obj.getPeid();
		if (obj.getIs_honouree_lecturer()) 
		{
			temp[2] = 1;
		}
		else
		{
			temp[2] = 0;
		}
		
		return temp;
	}
	
	public Object[] ConvertToPerson(Person obj)
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