package com.harriserpexercise.util;

public class NumberParser {
	
	
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
	
	public static float ParsePositiveIFloat(String num) throws NumberFormatException, Exception {
		float n = -1;		
		num = num.trim();

		if (num == null || num.isEmpty() || num.equals("")) 
			throw new Exception("Number cannot be empty.");
		
		n = Float.parseFloat(num);
		
		if (n <= 0)
			throw new Exception("Number must be positive.");
		
		return n;
	}
	

}
