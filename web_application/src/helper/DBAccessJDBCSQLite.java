package helper;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DBAccessJDBCSQLite extends DBAccessJDBC{
	
	public enum TableName {
		AdministrationEmployee,
		Lecturer,
		Modul,
		ModulLecturer,
		Person,
		Right,
		Student,
		StudyGroup
	}
	
	private TableName tableName = TableName.AdministrationEmployee;
    private String url = "jdbc:sqlite:/";
    private Connection dB = null;
    private PreparedStatement statement;
	
	public DBAccessJDBCSQLite() 
	{
		
	}
	
	public Boolean connectTODB()
	{
		try
		{
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
		String sql = "select * from ?";
		
		setTableName(tableName);
		
		try 
		{
			 setStatement(getDB().prepareStatement(sql));
			 getStatement().setString(1, getTableName().toString());
			 temp = GetResultToObjectData(getStatement().executeQuery());
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return temp;
	}
	
	/**
	 * @param data
	 * Daten die in die Tabellen sollen.
	 * @param tableName
	 * Tabellen Namen.
	 * @return
	 * true = ok
	 * false = fehler
	 * @info Fügt Daten in eine Tabelle.
	 */
	public Boolean insertInto(List<Object[]> data, TableName tableName)
	{
		String sql = "insert into ";
		
		setTableName(tableName);
		
		try
		{
			 setStatement(getDB().prepareStatement(sql));
			 
			 
			 getStatement().setString(1, getTableName().toString());
			 //setcolums()
			 getStatement().executeQuery();
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param data
	 * Daten die Geupdatet werden sollen.
	 * @param tableName
	 * Tabellen Namen
	 * @return
	 * true = ok
	 * false = fehler
	 * @info Updatet Daten in eine Tabelle.
	 */
	public Boolean update(List<Object[]> data, TableName tableName)
	{
		String sql = "insert into ";
		
		setTableName(tableName);
		
		try 
		{
			 setStatement(getDB().prepareStatement(sql));
			 //setcloums
			 getStatement().executeQuery();
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
	public Boolean login(String shortname, String password)
	{
		String sql = "select count(*) from person where = ? and password = ?";
		
		try 
		{
			 setStatement(getDB().prepareStatement(sql));
			 getStatement().setString(1, shortname);
			 getStatement().setString(2, password);
			 ResultSet rs = getStatement().executeQuery();
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
		String sql = "delete ? where = ?";
		
		try 
		{
			 setStatement(getDB().prepareStatement(sql));
			 
			 
			 getStatement().setString(1, getTableName().toString());
			 getStatement().setInt(2, id);
			 getStatement().executeQuery();
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
		String sql = "select count(*) from person where id = ? and rid = ?";
		
		try 
		{
			setStatement(getDB().prepareStatement(sql));
			getStatement().setInt(1, id);
			getStatement().setInt(2, rights);
			ResultSet rs = getStatement().executeQuery();
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

	private PreparedStatement getStatement() {
		return statement;
	}

	private void setStatement(PreparedStatement statement) {
		this.statement = statement;
	}

}