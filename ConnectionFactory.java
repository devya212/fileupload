package com.nucleus.connection;

public class ConnectionFactory 
{
	public static ConnectionDetail connectionFactory(String connect)
	{
		ConnectionDetail connectionDetail = null;
		if(connect.equalsIgnoreCase("oracle"))
		{
			OracleConnectionDetail oracleConnectionDetail= new OracleConnectionDetail();
			connectionDetail = (ConnectionDetail)oracleConnectionDetail;
			return connectionDetail;
		}
		else if(connect.equalsIgnoreCase("mysql"))
		{
			MySQLConnectionDetail mySQLConnectionDetail= new MySQLConnectionDetail();
			connectionDetail = (ConnectionDetail)mySQLConnectionDetail;
			return connectionDetail;
	
		}
		return null;
	}
	
}
