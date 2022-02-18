/*
 * @ author trusha.patel@stltech.in
 * @version 1.0
 * @date 16-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved
 * @description: Testing jdbc connection with oracle
 * */
package com.sterlite.jdbc.oracle;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sterlite.jdbc.connection.DBConnection;

public class GetAllProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Connection con = null;
		try (
				//with resource ARM
				Connection con = DBConnection.getDBConnectivity();
			)
		{
			//database operation logic 
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
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
