package data;

import java.sql.*;

public class Data {
	
	 public Connection con;
	 public Statement smt;
	
	public Data()
	{
		
		openConnection();
	}
	
	public Connection openConnection() {
		try
		{
//		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false","root","root");
		smt=con.createStatement();
		}
		catch(Exception e)
		{
		System.out.println("hi "+e);
		}
		return con;
	}
	
	public ResultSet executeQuery(String sql) throws SQLException
	{
		openConnection();
		ResultSet rs = smt.executeQuery(sql);
		return rs;
	}
	
	public int executeUpdate(String sql) throws SQLException
	{
		openConnection();
		smt.executeUpdate(sql);
		return 0;
		
	}
	
}
