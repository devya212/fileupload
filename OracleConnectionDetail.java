package com.nucleus.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class OracleConnectionDetail implements ConnectionDetail
{
	Connection con=null;
	InputStream inputStream=null;
	Properties prop = new Properties();
	static Logger logger=Logger.getLogger(OracleConnectionDetail.class.getName());

	public Connection createConnection() //Function to create Oracle connection.
	{
		try
		{	
			//inputStream = new FileInputStream("ConnectionProperty.properties");
			//prop.load(inputStream);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
			System.out.println("Oracle Connection");
		}
		catch(Exception e)
		{
			System.out.println("Error in Database");
			logger.info("Error in Database");
		    logger.error(e);
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
