package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class AppConnection {
	
	
	private AppConnection(){
		
	}
	
	public static Connection getDSConnection() {
		Connection conn = null;
		try {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("jdbc/bookdb2");
		conn = ds.getConnection();
		} 
		catch (NamingException | SQLException ex) {
		ex.printStackTrace();
		}
		return conn;
		}

	
	
}
