package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class TestJdbc {

	@Test
	public void testJDBC() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/instructor_student?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "root";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
