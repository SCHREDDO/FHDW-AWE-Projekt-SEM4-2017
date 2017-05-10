package helper;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public abstract class DBAccessJDBC {
	
	protected String url;
	protected String login;
	protected String password;
	
	public DBAccessJDBC() 
	{
		
	}
	
	public DBAccessJDBC(String url, String login, String password)
	{
		this.url = url;
		this.login = login;
		this.password = password;
	}
	
	public List<Object[]> GetResultToObjectData(ResultSet rs)
	{
		List<Object[]> temp = new ArrayList<Object[]>();
		
		try {
			while(rs.next())
			{	
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return temp;
	}
	
	public void ExecuteQuery()
	{
		
	}
}