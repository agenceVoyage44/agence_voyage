package fr.adaming.dao.tests;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		
		Date date = new Date();
		date.getTime();
		
		
		@SuppressWarnings("deprecation")
		Date date2 = new Date("2005/03/12");
		date2.getTime();
		
	
		
		System.out.println(date.getTime()- date2.getTime());
	
	
	}

}
