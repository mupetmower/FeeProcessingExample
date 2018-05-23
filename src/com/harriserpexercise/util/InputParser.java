package com.harriserpexercise.util;

/**
 * 
 * @author Alex Frye
 *
 */
public class InputParser {
	
	
	public static int ParsePositiveInt(String num) throws NumberFormatException, Exception {
		if (CheckEmpty(num))
			throw new Exception("Number cannot be empty.");
			
		num = num.trim();
		int n = -1;	
		
		n = Integer.parseInt(num);
		
		if (n <= 0)
			throw new Exception("Number must be a positive Integer.");
		
		return n;
	}
	
	public static float ParsePositiveFloat(String num) throws NumberFormatException, Exception {
		if (CheckEmpty(num))
			throw new Exception("Number cannot be empty.");
		
		num = num.trim();
		float n = -1;
		
		n = Float.parseFloat(num);
		
		if (n <= 0)
			throw new Exception("Number must be positive.");
		
		return n;
	}
	
	/**
	 * Parses a y/n String and returns boolean.
	 * @param yn - String to check.
	 * @return true for y, false for n.
	 * @throws Exception If String is empty or not y or n.
	 */
	public static boolean ParseYesNo(String yn) throws Exception {
		if (CheckEmpty(yn)) 
			throw new Exception("y/n answer cannot be empty.");
		
		yn = yn.trim().toLowerCase();
		
		if (yn.equals("y"))
			return true;
		else if (yn.equals("n"))
			return false;
		else
			throw new Exception("Your answer must be y or n.");
	}
	
	
	public static boolean CheckEmpty(String s) {
		return (s == null || s.isEmpty() || s.equals("")) ? true : false;
	}

	/**
	 * Parses a String for q and returns boolean.
	 * @param s - String to check
	 * @return If the String is not empty and equals q, return true.
	 */
	public static boolean CheckQuit(String s) {
		return (!CheckEmpty(s) && s.trim().toLowerCase().equals("q")) ? true : false;
	}
}
