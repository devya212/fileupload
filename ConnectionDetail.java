package com.nucleus.connection;

import java.sql.Connection;

public interface ConnectionDetail
{
	public Connection createConnection();
	public void closeConnection(Connection con);
}
