package com.model;

public class Location {
	
	private int locationId;
	private String city;
	
	public Location(int locationId, String city) {
		super();
		this.locationId = locationId;
		this.city = city;
	}
	
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


}
