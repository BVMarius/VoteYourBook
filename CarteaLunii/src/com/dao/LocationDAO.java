package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LocationDAO {
	
	
	public static Map<Integer, String> retriveAvailableLocations(){
		
		String sqlLocation = "SELECT LOCATIONID, CITY FROM FQP56733.LOCATION";
		int locationId;
		String city;
		Map<Integer,String> map = new HashMap<Integer, String>();
		
		try(Connection conn = AppConnection.getDSConnection()){
			
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlLocation);
			
			while(rs.next()){
				locationId = rs.getInt("locationid");
				city = rs.getString("city");
				map.put(locationId, city);
				System.out.println(String.format("Added location with id %d and city %s", locationId,city));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
		
	}
	
	public static void main(String...strings){
		Map<Integer,String> map = retriveAvailableLocations();
		for(Map.Entry<Integer, String>entry:map.entrySet()){
			System.out.println(entry.getValue()+" "+entry.getKey());
		}
		
	}

}
