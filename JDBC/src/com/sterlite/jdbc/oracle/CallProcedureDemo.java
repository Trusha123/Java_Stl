package com.sterlite.jdbc.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.sterlite.jdbc.connection.DBConnection;

public class CallProcedureDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try( Connection con = DBConnection.getDBConnectivity())
		{
			CallableStatement cstmt = con.prepareCall("{call update_price(?,?)}");
			cstmt.setInt(1,3001);
			cstmt.setFloat(2, 1000.00f);
			cstmt.execute();
			System.out.println("PL/SQL procedure executed successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}
		
	}

}
