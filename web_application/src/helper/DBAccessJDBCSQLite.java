package helper;

import java.util.ArrayList;
import java.util.List;

import models.User;

import java.sql.*;

public class DBAccessJDBCSQLite extends DBAccessJDBC{
	
	public enum TableName 
	{
		administration_employee,
		grade,
		lecturer,
		modul,
		modul_lecturer,
		module_lecturer_study_group,
		person,
		permission,
		student,
		study_group;

		public static int valueOf(TableName tableName) {
			TableName[] temp = TableName.values();
			int index = -1;
			
			for (int i = 0; i < temp.length; i++) 
			{
				if (tableName.equals(temp[i]))
				{
					index = i;
				}
			}
			return index;
		}
	}
	
	public enum TableID
	{
		aeid,
		grid, 
		leid, 
		moid, 
		mlid,
		msid,
		peid,
		pid, 
		stid, 
		sgid 
	}
	
	private TableName tableName = TableName.administration_employee;
    private String url = "jdbc:sqlite:/SQLite/database";
    private Connection dB = null;
	
	public DBAccessJDBCSQLite() 
	{
		
	}
	
	public Boolean connectTODB()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			setDB(DriverManager.getConnection(getUrl()));
			
			System.out.println("Connected to database.");
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param tableName
	 * Name der Tabelle
	 * @return List Datentyp Objekt Array.
	 * @info Gibt alle Daten der Tabelle.
	 */
	public List<Object[]> getObjectData(TableName tableName)
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		String sql = "select * from $TableName";
		
		setTableName(tableName);
		
		sql = sql.replace("$TableName", getTableName().toString());
		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			temp = GetResultToObjectData(statement.executeQuery());
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}
	
	public List<Object[]> getObjectDataByID(TableName tableName, int id)
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		String sql = "select * from $TableName where $IDName = ?";
		
		setTableName(tableName);
		
		sql = sql.replace("$TableName", getTableName().toString());
		sql = sql.replace("$IDName", TableID.values()[TableName.valueOf(getTableName())].toString());
		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			statement.setInt(1, id);
			temp = GetResultToObjectData(statement.executeQuery());
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}
	
	public List<Object[]> getObjectDataPersonStudent()
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		String sql = "select p.peid, p.riid, p.firstname, p.larstname, p.short, p.password, p.e_mail,address, p.phone_number, s.stid, s.sgid, s.matrikelnumber, g.sgid, g.short from person as p, student as s, study_group as g where p.peid = s.peid and s.sgid = g.sgid";

		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			temp = GetResultToObjectData(statement.executeQuery());
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}
	
	public List<Object[]> getObjectDataPersonLecturer()
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		String sql = "select p.peid, p.riid, p.firstname, p.larstname, p.short, p.password, p.e_mail, p.address, p.phone_number, l.leid, l.is_honouree_lecturer from person as p, lecturer as l where p.peid = l.peid";

		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			temp = GetResultToObjectData(statement.executeQuery());
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}
	
	public List<Object[]> getObjectDataPersonAdministrationEmployee()
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		String sql = "select p.peid, p.riid, p.firstname, p.larstname, p.short, p.password, p.e_mail, p.address, p.phone_number, a.aeid, a.task_area from person as p, administration_employee as a where p.peid = a.peid";
		
		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			temp = GetResultToObjectData(statement.executeQuery());
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}
	
	public List<Object[]> getObjectDataStudentGroup(String studentgroup)
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		String sql = "select p.peid, p.riid, p.firstname, p.larstname, p.short, p.password, p.e_mail,address, p.phone_number, s.stid, s.peid, s.sgid, s.matrikelnumber from person p, student s, study_group g where p.peid = s.peid and s.sgid = g.sgid";
		
		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			statement.setString(1, studentgroup);
			temp = GetResultToObjectData(statement.executeQuery());
			System.out.println("Test");
			System.out.println(temp.get(0)[0]);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}

	public Boolean insertIntoAdministrationEmployee(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (peid, task_area) VALUES (?, ?)";

		PreparedStatement statement;
		
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setString(2, (String)temp[2]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}

		return true;
	}

	public Boolean insertIntoGrade(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (stid, mlid, gradenumber, gradepercent) VALUES (?, ?, ?, ?)";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			statement.setInt(3, (int)temp[3]);
			statement.setInt(4, (int)temp[4]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}

		return true;
	}

	public Boolean insertIntoLecturer(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (peid, is_honouree_lecturer) VALUES (?, ?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setString(2, (String)temp[2]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public Boolean insertIntoModul(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (name, short, creditpoints) VALUES (?, ?, ?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setString(1, (String)temp[1]);
			statement.setString(2, (String)temp[2]);
			statement.setInt(3, (int)temp[3]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public Boolean insertIntoModulLecturer(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (moid, leid) VALUES (?, ?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}

		
		return true;
	}

	public Boolean insertIntoPerson(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (riid, firstname, larstname, short, password, e_mail, address, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setString(2, (String)temp[2]);
			statement.setString(3, (String)temp[3]);
			statement.setString(4, (String)temp[4]);
			statement.setString(5, (String)temp[5]);
			statement.setString(6, (String)temp[6]);
			statement.setString(7, (String)temp[7]);
			statement.setInt(8, (int)temp[8]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}

		return true;
	}

	public Boolean insertIntoRight(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (name) VALUES (?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setString(1, (String)temp[1]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public Boolean insertIntoStudent(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (peid, sgid, matrikelnumber) VALUES (?, ?, ?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setInt(1, (int)temp[2]);
			statement.setInt(1, (int)temp[3]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public Boolean insertIntoStudyGroup(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (short) VALUES (?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setString(1, (String)temp[1]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	public Boolean insertIntoModuleLecturerStudyGroup(List<Object[]> data)
	{
		String sql = "INSERT INTO $TableName (sgid, moid, leid) VALUES (?, ?, ?)";
		
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			statement.setInt(3, (int)temp[3]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public Boolean updateAdministrationEmployee(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET peid = ?, task_area = ? WHERE aeid = ?";
			
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(3, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setString(2, (String)temp[2]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}

		return true;
	}

	public Boolean updateGrade(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET stid = ?, mlid = ?, gradenumber = ?, gradepercent = ? WHERE grid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(5, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			statement.setInt(3, (int)temp[3]);
			statement.setInt(4, (int)temp[4]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}

	public Boolean updateLecturer(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET peid = ?, is_honouree_lecturer = ? WHERE leid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(3, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}

	public Boolean updateModul(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET name = ?, short = ?, creditpoints = ? WHERE moid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(4, (int)temp[0]);
			statement.setString(1, (String)temp[1]);
			statement.setString(2, (String)temp[2]);
			statement.setInt(3, (int)temp[3]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}

	public Boolean updateModulLecturer(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET moid = ?, leid = ? WHERE mlid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(3, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}

	public Boolean updatePerson(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET riid = ?, firstname = ?, larstname = ?, short = ?, password = ?, e_mail = ?, address = ?, phone_number = ?  WHERE peid = ?";
			
		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(9, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setString(2, (String)temp[2]);
			statement.setString(3, (String)temp[3]);
			statement.setString(4, (String)temp[4]);
			statement.setString(5, (String)temp[5]);
			statement.setString(6, (String)temp[6]);
			statement.setString(7, (String)temp[7]);
			statement.setInt(8, (int)temp[8]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}

		return true;
	}

	public Boolean updateRight(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET name = ? WHERE riid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(2, (int)temp[0]);
			statement.setString(1, (String)temp[1]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}

	public Boolean updateStudent(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET peid = ?, sgid = ?, matrikelnumber = ? WHERE stid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(4, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			statement.setInt(3, (int)temp[3]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}

	public Boolean updateStudyGroup(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET short = ? WHERE sgid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(2, (int)temp[0]);
			statement.setString(1, (String)temp[1]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}
	
	public Boolean updateModuleLecturerStudyGroup(List<Object[]> data)
	{
		String sql = "UPDATE $TableName SET sgid = ?, moid = ?, leid = ? WHERE msid = ?";

		PreparedStatement statement;
			
		try 
		{			
			statement = getDB().prepareStatement(sql);
			
			Object[] temp = data.get(0);
			
			statement.setInt(4, (int)temp[0]);
			statement.setInt(1, (int)temp[1]);
			statement.setInt(2, (int)temp[2]);
			statement.setInt(3, (int)temp[3]);
			
			statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
			
		return true;
	}
	
	/**
	 * @param shortname
	 * Kurzel
	 * @param password
	 * Password
	 * @return
	 * true = ok
	 * false = fehler
	 * @info
	 * Schaut ob der User existirt
	 */
	public Boolean login(String e_mail, String password)
	{
		String sql = "select count(*) from person where e_mail = ? and password = ?";
		
		PreparedStatement statement;
		
		try 
		{
			 statement = getDB().prepareStatement(sql);
			 statement.setString(1, e_mail);
			 statement.setString(2, password);
			 ResultSet rs = statement.executeQuery();
			 
			 while(rs.next())
			 {
				 if (rs.getInt(1) != 1)
				 {
					 return false;
				 }
			 }
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param id
	 * ID des Datensatrztes
	 * @param tableName
	 * Name der Tabelle
	 * @return
	 * true = ok
	 * false = fehler
	 * @info
	 * löscht einen Datensatz
	 */
	public Boolean delete(int id, TableName tableName)
	{
		String sql = "delete $TableName where $IDName = ?";
		
		setTableName(tableName);
		
		sql = sql.replace("$TableName", getTableName().toString());
		sql = sql.replace("$IDName", TableID.values()[TableName.valueOf(getTableName())].toString());
		PreparedStatement statement;
		
		try 
		{
			 statement = getDB().prepareStatement(sql);
			 statement.setInt(1, id);
			 statement.executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param id
	 * Personen ID
	 * @param rights
	 * Rechte ID
	 * @return
	 * True hat rechte
	 * false nicht
	 * @info
	 * Schaut ob Person die Rechte da für hat
	 */
	public Boolean hasRight(int id, int rights)
	{
		String sql = "select count(*) from person where peid = ? and riid = ?";
		
		setTableName(tableName);
		
		sql = sql.replace("$TableName", getTableName().toString());
		PreparedStatement statement;
		
		try 
		{
			statement = getDB().prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, rights);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
			{
				if (rs.getInt(1) != 1)
				{
					return false;
				}
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	public User getlogindata(String e_mail, String password)
	{
		String sql = "select short, pid from person where e_mail = ? and password = ?";
		
		PreparedStatement statement;
		
		User temp = new User();
		
		try 
		{
			 statement = getDB().prepareStatement(sql);
			 statement.setString(1, e_mail);
			 statement.setString(2, password);
			 ResultSet rs = statement.executeQuery();
			 
			 while(rs.next())
			 {
				 temp.setShortname(rs.getString(1));
				 temp.setPid(rs.getInt(2));
			 }
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
		
		return temp;
	}
	
	public TableName getTableName() {
		return tableName;
	}
	public void setTableName(TableName table_name) {
		this.tableName = table_name;
	}
	private String getUrl() {
		return url;
	}
	private void setUrl(String url) {
		this.url = url;
	}
	private Connection getDB() {
		return dB;
	}
	private void setDB(Connection db) {
		this.dB = db;
	}
}