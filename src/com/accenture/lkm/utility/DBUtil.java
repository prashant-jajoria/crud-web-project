package com.accenture.lkm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/sampledb?verifyServerCertificate=false&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
	private static Connection connection = null;

	  	private DBUtil() {}

	  	public static Connection getDbConnection() throws ClassNotFoundException, SQLException, Exception
	    {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			return connection;
	    }

	    public static void closeConnection()
	    {
	        try
	        {
	            if(connection!= null)
	                connection.close();
	        }
	        catch(SQLException ex)
	        {
	            ex.printStackTrace();
	        }   
	    }
	  
}