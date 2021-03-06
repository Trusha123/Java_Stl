package com.sterlite.jdbc.postgres;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.sterlite.jdbc.connection.DBConnection;

public class CallProcedurePostgresDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try( Connection con = DBConnection.getDBConnectivity())
		{
			CallableStatement cstmt = con.prepareCall("CALL update_price(?,?)");
			cstmt.setInt(1,3001);
			cstmt.setInt(2,1000);
			cstmt.execute();
			System.out.println("PL/SQL procedure executed successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}