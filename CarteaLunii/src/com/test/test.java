package com.test;

public class test {
	
	public static void main(String...strings){
		String ala = "marius";
		String[] ar = ala.split("\\s+");
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0; i<ar.length; i++){
			System.out.println(ar[i]);
			sb.append(ar[i]);
			if(i!=ar.length-1){
				sb.append("+");
			}
		}
		
		System.out.println(sb);
	}

}
