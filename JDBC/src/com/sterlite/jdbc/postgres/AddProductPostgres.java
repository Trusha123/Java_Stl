package com.sterlite.jdbc.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.sterlite.jdbc.connection.DBConnection;

public class AddProductPostgres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection con = DBConnection.getDBConnectivity();
				Scanner sc = new Scanner(System.in);)
		{
			//get statement from connection
			//Statement stmt = con.createStatement();
			
			//parameter index is passed 
			PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?,?)");
			System.out.println("Enter ProductId: ");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			
			sc.nextLine();
			System.out.println("Enter Product Name: ");
			String name = sc.nextLine();
			pstmt.setString(2, name);
			
			
			System.out.println("Enter Brand Name: ");
			String brand = sc.nextLine();
			pstmt.setString(3, brand);
			
								
			System.out.println("Enter Price: ");
			float price = sc.nextFloat();
			pstmt.setFloat(4, price);
			
			//precompile query/parametrized sql query
			//int updateCnt = stmt.executeUpdate("insert into product values(4398,'TV','LG',35600.00)");
			//submit query to databse and fetch values
			int updateCnt = pstmt.executeUpdate();//dynamic sql query
			if(updateCnt>0)
				System.out.println("New product inserted successfully");
			else
				System.out.println("Insert proper record");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
