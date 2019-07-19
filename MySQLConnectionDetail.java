package com.nucleus.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionDetail implements ConnectionDetail
{
	Connection con=null;
	public Connection createConnection() //Function to create MySQL connection.
	{
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makerbrd","root", "roger");
			System.out.println("MySQL Connection");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con) //Function to close connection.
	{
		try
		{
			con.close();
		} 
		catch (SQLException e)
		{
		
		e.printStackTrace();
		}
		
	}

}
