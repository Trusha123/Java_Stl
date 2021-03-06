/*
 * @ author trusha.patel@stltech.in
 * @version 1.0
 * @date 16-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved
 * @description: Database connectivity code
 * */
package com.sterlite.jdbc.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	public static Connection getDBConnectivity() throws IOException, ClassNotFoundException, SQLException {
		
		//create an object of properties class
		Properties props = new Properties();
		
		//create fileReader to open properties file in read mode
		FileReader fr = new FileReader("dbconfig.properties");
		
		//load database properties from file into prop object
		props.load(fr);
	
		//retrive JDBC properties stored in properties object
		//String driverClassName = props.getProperty("jdbc-driver");
		String jdbcUrl = props.getProperty("jdbc-url");
		String dbUsername = props.getProperty("db-username");
		String dbPassword = props.getProperty("db-password");
		
		//Load jdbc driver;
		//Class.forName(driverClassName);
		System.out.println("JDBC Driver loaded");
		
		Connection con =DriverManager.getConnection(jdbcUrl,dbUsername,dbPassword);
		System.out.println("Database connection established");
		
		//establish database connection
		return con;
	}

}
