package com.jspider.book_management.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookConnection {
	
	public static Connection getBookConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/book-management-project","root","Roshani700");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return null;
		}
}
}
