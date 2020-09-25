package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter ID of Product : ");
		String prdid = sc.nextLine();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasedemo", "Tanishq",
					"tanishqporwal");

			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from Product where pid =" + prdid);
				

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					System.out.println(rs.getInt("pid") + " : " + rs.getString("pname") + " : " + rs.getInt("price"));
				}

			} else {
				System.out.println("No such record found !!!");
			}

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
