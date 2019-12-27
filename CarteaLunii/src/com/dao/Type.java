package com.dao;

public enum Type {
	
	NORMAL(1), ADMIN(0);
	
	private final int accessLevel;
	
	Type(int accessLevel){
		this.accessLevel=accessLevel;
	}
	
	public int getLevelCode(){
		return this.accessLevel;
	}
}
