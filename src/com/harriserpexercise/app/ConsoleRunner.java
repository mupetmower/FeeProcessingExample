package com.harriserpexercise.app;

import java.util.Scanner;

import com.harriserpexercise.util.Numbers;

public class ConsoleRunner {
	
	private Scanner input;
	
	
	public ConsoleRunner() {
		Init();
	}
	
	public void Init() {
		input = new Scanner(System.in);
	}
	
	public void Run() {
		
		
		PromptForFees();
		
		
	}
	
	
	public int PromptForFees() {
		int numFees = -1;
		
		try {
			//Prompt for amount of Fees to enter until a positive integer is given or q is entered
			while (numFees <= 0) {
				try {
					System.out.print("Enter the number of Fees you want to process or q to quit: ");
					String strNumFees = input.nextLine();
					if (strNumFees.trim().toLowerCase().equals("q")) {
						numFees = 1;
						throw new Exception("q has been entered. Quitting Application.");
					}
					//Parse to integer, check to make sure it is positive
					numFees = Numbers.ParsePositiveInt(strNumFees);
				} catch (Exception ex) {
					System.out.println("Error - " + ex.getMessage() + "\n");
				}				
			}
			
		} catch (Exception ex) {
			System.out.println("Error - PromptForFees");
			ex.printStackTrace();
		}
				
		return numFees;
	}

}
