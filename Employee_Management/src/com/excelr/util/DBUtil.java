package com.excelr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection con =null;

	public  static Connection getConnetion() {
		String url = "jdbc:mysql://localhost:3306/employee_management";
		String username = "springDataJPA";
		String password = "springDataJPA";

		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established");

		} catch (SQLException e) {

			e.printStackTrace();
			//System.out.println("username or password is incorrect");
		}
		
		return con;
	}

}
