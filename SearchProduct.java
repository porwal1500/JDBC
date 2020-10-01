package com.application;

import java.sql.*;
import java.util.Scanner;

public class SearchProduct {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID of Product : ");
		int prdid =sc.nextInt(); 
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = 
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/MyData", "root", "root");
			
			PreparedStatement pst = 
con.prepareStatement("select * from Product where pid = ?");
			
			pst.setInt(1,prdid);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				rs.next();
				
				System.out.println(rs.getInt("pid")+ " : "+
				rs.getString("pname") +" : "+rs.getInt("price"));
			}
			else
			{
				System.out.println("No such record found !!!");
			}
			
			con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}




