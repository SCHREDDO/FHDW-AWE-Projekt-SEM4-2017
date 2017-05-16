package de.fhdw.jsp;

public class Student {
 public  int name;
 public  int zahl;
 
 
public Student(int name, int id) {
	this.name = name;
	this.zahl = id;
	System.out.println("student erstellt");
}


public int getName() {
	return name;
}


public void setName(int name) {
	this.name = name;
}


public int getZahl() {
	return zahl;
}


public void setZahl(int zahl) {
	this.zahl = zahl;
} 

}
