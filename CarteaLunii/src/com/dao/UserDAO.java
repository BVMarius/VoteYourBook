package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Location;
import com.model.User;

public class UserDAO {
	
	
	private static void performCreateUser(String firstName,String lastName, String password,
			String email,
			int locationId, int t){
			
		String sqlCreateUser = "INSERT INTO FQP56733.USER (USERID, "
				+ "FIRSTNAME, LASTNAME, PASSWORD, EMAIL,LOCATIONID, TYPE)"
				+ "VALUES (NEXTVAL FOR USER_ID_SEQ,?,?,?,?,?,?)";
		
		try(Connection conn = AppConnection.getDSConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlCreateUser)){
			
			stmt.setString(1, firstName.toUpperCase());
			stmt.setString(2, lastName.toUpperCase());
			stmt.setString(3, password);
			stmt.setString(4, email);
			stmt.setInt(5, locationId);
			stmt.setInt(6, t);
			
			int i = stmt.executeUpdate();
			if(i>0){
				System.out.println("Update executed successfully. Record created");
			}
			else{
				System.out.println("Any record was created");
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static void createUser(User u, int locationId, Type t){
		
		performCreateUser(u.getFirstName(),u.getLastName(),
				u.getPassword(),u.getEmail(),locationId, t.getLevelCode());
	}

}
