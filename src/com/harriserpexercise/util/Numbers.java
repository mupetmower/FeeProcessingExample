package com.harriserpexercise.util;

public class Numbers {
	
	
	public static int ParsePositiveInt(String num) throws NumberFormatException, Exception {
		int n = -1;		
		num = num.trim();

		if (num == null || num.isEmpty() || num.equals("")) 
			throw new Exception("Number cannot be empty.");
		
		n = Integer.parseInt(num);
		
		if (n <= 0)
			throw new Exception("Number must be positive.");
		
		return n;
	}
	
	
	

}
