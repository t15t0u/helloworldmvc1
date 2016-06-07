package org.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOHelloWorld {
	private static DAOHelloWorld INSTANCE = null;
	private static String URL = "jdbc:mysql://localhost:3306/wsjava1?autoReconnect=true&useSSL=false";
	private static String LOGIN = "root";
	private static String PASSWORD = "";
	private Connection connection;
	private Statement statement;
	
	private DAOHelloWorld() {

	}
	
	
	
public static DAOHelloWorld getInstance() {
		if(INSTANCE == null){
			INSTANCE = new DAOHelloWorld();
		}
		return INSTANCE;
}

public String getQuerySelectFirstHelloWorld() throws SQLException {
	String query = "SELECT * FROM `HelloWorld`;";
	ResultSet rs = this.executeQuery(query);
	if(rs.next()) {
		return rs.getString(1);
	}
	return null;
}



public Boolean open() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(DAOHelloWorld.URL, DAOHelloWorld.LOGIN, DAOHelloWorld.PASSWORD);
		this.statement = this.connection.createStatement();
	} catch (final ClassNotFoundException e) {
		e.printStackTrace();
		return false;
	} catch (final SQLException e) {
		e.printStackTrace();
		return false;
	}
		
 	return true;
} 

	
	
public void close() throws SQLException {
	this.connection.close();
}
	
	
	
	private ResultSet executeQuery(String query) {
		try {
			return this.statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
	


