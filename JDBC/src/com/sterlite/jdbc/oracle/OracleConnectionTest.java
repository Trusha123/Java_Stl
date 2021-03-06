/*
 * @ author trusha.patel@stltech.in
 * @version 1.0
 * @date 16-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved
 * @description: Testing jdbc connection with oracle
 * */
package com.sterlite.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		try {
			//step:1 Load JDBC Driver:::Optional Step
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("JDBC driver loaded");
			
			
			//Step2: To establish the connection 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			System.out.println("Oracle database connection is established ");
			//logic to perform database operations
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
