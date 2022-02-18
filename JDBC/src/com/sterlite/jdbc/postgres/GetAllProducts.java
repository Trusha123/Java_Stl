
package com.sterlite.jdbc.postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sterlite.jdbc.connection.DBConnection;

public class GetAllProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try( Connection con = DBConnection.getDBConnectivity();)
		{
			//database operations logic 
			//create Statement using connection
			Statement stmt = con.createStatement();
			
			//fire the static SQL and obtain ResultSet
			ResultSet rs = stmt.executeQuery("select * from product");
			
			//navigate over resultSet using cursor
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String brand = rs.getString("Brand");
				float price = rs.getFloat("price");
				System.out.println("Product ID:" +id+
									"\tName: " + name+
									"\tbrand: " + brand +
									"\tPrice: " + price);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
