package com.harriserpexercise.app;

import java.util.Scanner;

import com.harriserpexercise.services.TransactionManager;
import com.harriserpexercise.util.InputParser;

/**
 * A Console Runner for the Fee Processor Program
 * <br>
 * ConsoleRunner starts the program in the console. On instantiation, it will prompt for user input,
 * consume the input using the TransactionManager to create Fees and Payments, create and 
 * process Transactions, and display the results.
 * 
 * @author Alex Frye
 *
 */
public class ConsoleRunner {
	
	private Scanner input;
	private TransactionManager transactionMngr;
		
	
	public ConsoleRunner() {
		Init();
	}
	
	public void Init() {
		input = new Scanner(System.in);
		transactionMngr = new TransactionManager();
		
	}
	
	public void Run() {
		if (!PromptForBegin())
			return;
		
		int numFees = PromptForNumFees();
		if (numFees > 0)
			PromptForFees(numFees);
		
		int numPayments = PromptForNumPayments();
		if (numPayments > 0)
			PromptForPayments(numPayments);
		
		
		CreateAndProcessTransactions();
		
		//Run one last prompt so the application will not exit before letting user
		//see displayed results
		PromptQuit();
				
	}
	
	
	private boolean PromptForBegin() {
		System.out.print("\nWelcome to Fee Processor\n"
				+ "Enter q to quit at any time. Enter any key to begin: ");
		String strBegin = input.nextLine();
		
		if (InputParser.CheckQuit(strBegin)) {
			System.out.println("q entered. Quitting Application..");
			System.exit(0);
			return false;
		}
		
		return true;
	}
	
	
	
	
	public int PromptForNumFees() {
		int numFees = -1;
		System.out.println("First, you will enter the number of Fees you wish to process.");
		try {
			//Prompt for amount of Fees to enter until a positive integer is given or q is entered
			while (numFees <= 0) {
				try {
					System.out.print("Enter the number of Fees you want to process: ");
					String strNumFees = input.nextLine();
					if (InputParser.CheckQuit(strNumFees)) {
						System.out.println("q has been entered. Quitting Application..");
						System.exit(0);
						return -1;
					}
					//Parse to integer, check to make sure it is positive
					numFees = InputParser.ParsePositiveInt(strNumFees);
				} catch (NumberFormatException nfex) {
					System.out.println("Not a number - " + nfex.getMessage());
					continue;
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}				
			}
			
		} catch (Exception ex) {
			System.out.println("Error - PromptForNumFees");
			ex.printStackTrace();
		}
				
		return numFees;
	}
	
	
	
	public void PromptForFees(int numFees) {				
		boolean quitFlag = false;
		String strFeeName = "";				//For not losing fee name on error

		System.out.println("Next, you will enter a name and an amount for each fee.");
		System.out.println("Begin Fee Creation... ");
		
		try {				
			//Prompt for name and amount per Fee until a name and positive float is given or q is entered
			for (int i = 0; i < numFees; ) {
			//Quit Warning Logic
				if (quitFlag) {
					try {
						quitFlag = QuitWarning();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());		
					}
				} else {								
					try {
						
						
						//Check so that if there is an error on amount, they do not lose the name of the current fee						
						if (strFeeName.equals("")) {
							System.out.print(String.format("Enter the name for Fee %d, or leave empty for default name (Fee %d): ", i+1, i+1));
							strFeeName = input.nextLine();
							if (InputParser.CheckEmpty(strFeeName))
								strFeeName = String.format("Fee %d", i+1);
							
							if (InputParser.CheckQuit(strFeeName)) {
								quitFlag = true;
								strFeeName = "";
								throw new Exception("q has been entered..");
							}							
						}
						
						
						System.out.print(String.format("Enter the amount you want to process for Fee Name %s: ", strFeeName));
						String strFeeAmount = input.nextLine();
						if (InputParser.CheckQuit(strFeeAmount)) {
							quitFlag = true;
							throw new Exception("q has been entered..");
						}
						//Parse to float, check to make sure it is positive
						float feeAmount = InputParser.ParsePositiveFloat(strFeeAmount);
						
						
						transactionMngr.CreateFee(strFeeName, feeAmount);						
						System.out.println(String.format("Fee: %s, Amount: $%.2f Created.", strFeeName, feeAmount));
						//NOTE - Amounts are displayed as $x.xx but will keep their decimal places. No actual rounding is happening to the number
						//I realize that in financial cases, you do not want rounding. Double, or even BigDecimal may have been more appropriate
						//depending on what sort of applications this program would have.
						
						
					} catch (NumberFormatException nfex) {
						System.out.println("Not a number - " + nfex.getMessage());
						continue;
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
						continue;
					}
					
					
					i++;
					strFeeName = "";
				}
			}
		} catch (Exception ex) {
			System.out.println("Error - PromptForFees");
			ex.printStackTrace();
		}
	}
	
	public int PromptForNumPayments() {
		boolean quitFlag = false;
		int numPayments = -1;

		System.out.println("Next, you will enter the number of Payments you wish to process.");
		System.out.println("NOTE - when you are finished entering payments, each Fee will have Payments applied to their amounts\n"
				+ "in the order that each fee and payment was given.\n"
				+ "If there are any left over Payment amounts, all of the excess will be applied to the FIRST Fee that was created.");
		try {
			//Prompt for amount of Payments to enter until a positive integer is given or q is entered
			while (numPayments <= 0) {
				if (quitFlag) {
					try {
						quitFlag = QuitWarning();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());		
					}
				} else {	
					try {
						System.out.print("Enter the number of Payments you want to process: ");
						String strNumPayments = input.nextLine();
						if (InputParser.CheckQuit(strNumPayments)) {
							quitFlag = true;
							throw new Exception("q has been entered..");
						}
						//Parse to integer, check to make sure it is positive
						numPayments = InputParser.ParsePositiveInt(strNumPayments);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
			
		} catch (NumberFormatException nfex) {
			System.out.println("Not a number - " + nfex.getMessage());			
		} catch (Exception ex) {
			System.out.println("Error - PromptForNumPayments");
			ex.printStackTrace();
		}
				
		return numPayments;
	}
	
	public void PromptForPayments(int numPayments) {					
		boolean quitFlag = false;
		
		System.out.println("Begin Payment creation..");
		
		try {
			//Prompt for amount for each Payment until a positive float is given or q is entered
			for (int i = 0; i < numPayments; ) {
			//Quit Warning Logic
				if (quitFlag) {
					try {
						quitFlag = QuitWarning();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());		
					}
				} else {								
					try {												
						
						System.out.print(String.format("Enter the amount for Payment %d: ", i+1));
						String strPaymentAmount = input.nextLine();
						if (InputParser.CheckQuit(strPaymentAmount)) {
							quitFlag = true;
							throw new Exception("q has been entered..");
						}
						//Parse to float, check to make sure it is positive
						float paymentAmount = InputParser.ParsePositiveFloat(strPaymentAmount);
						
						
						transactionMngr.CreatePayment(paymentAmount);						
						System.out.println(String.format("Payment %d with Amount: $%.2f Created.", i+1, paymentAmount));
						
						
						
					} catch (NumberFormatException nfex) {
						System.out.println("Not a number - " + nfex.getMessage());
						continue;
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
						continue;
					}
					
					
					i++;
				}
			}
		} catch (Exception ex) {
			System.out.println("Error - PromptForPayments");
			ex.printStackTrace();
		}
	}	
	
	/**
	 * Call TransactionManager's CreateAndProcessTransaction method which will create, process, and display
	 * each transaction.
	 */
	public void CreateAndProcessTransactions() {
		System.out.println("All Fees and Payments entered.\n"
				+ "Creating Transactions...");
		
		transactionMngr.CreateAndProcessTransactions();
		
		
	}
	
	
	public void PromptQuit() {
		System.out.print("\nAll Transactions Processed.\n\n"
				+ "Enter any key to quit program: ");
		input.nextLine();
	}
	
	
	/**
	 * Make sure the user wants to quit
	 */
	private boolean QuitWarning() throws Exception {	
		System.out.print("WARNING - You are about to quit during Fee proccessing.\n"
				+ "If you quit, any unprocessed Fees and Payments will be lost. \nQuit anyway - y/n? ");
		if (InputParser.ParseYesNo(input.nextLine())) {
			//y entered - quit
			System.out.println("y entered. Quitting application..");
			System.exit(0);
			return true;
		} else {
			//n entered - don't quit, return to Fee entering for loop	
			System.out.println("n entered. Returning to application..");
			return false;
		}
		
	}
	

}
