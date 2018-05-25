package com.harriserpexercise.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.harriserpexercise.entities.Fee;
import com.harriserpexercise.entities.Payment;
import com.harriserpexercise.entities.Transaction;

/**
 * Manages all Fee, Payment, and Transaction creation, processing, and display.
 * 
 * @author Alex Frye
 *
 */
public class TransactionManager {

	//Normally, I would probably add some fields to the entities for originalAmount, etc.
	//However, I wanted to try to stick to the criteria and spirit of the exercise as much as possible
	
	//Lists with copies of the original Fees and Payments for display purposes
	private List<Fee> allFees = new ArrayList<Fee>();
	private List<Payment> allPayments = new ArrayList<Payment>();
	private List<Transaction> allTransactions = new ArrayList<Transaction>();
	
	private Queue<Fee> unpaidFees = new LinkedList<Fee>();
	private Queue<Payment> unusedPayments = new LinkedList<Payment>();
	private Queue<Transaction> unprocessedTransactions = new LinkedList<Transaction>();
	
	
	
	public TransactionManager() {}
		
	
	/**
	 * Create Transactions until either Fees or Payments are depleted, process each Transaction
	 * in order, and display the results.
	 */
	public void CreateAndProcessTransactions() {
		//Again, to keep the criteria without adding new fields, I am going to keep an
		//index of the fee and payment we are on so I can pass the original fee and 
		//payment amount per transaction
		int feeI = 0;
		int paymentI = 0;
		
		System.out.println("Processing Transactions...");
		
		//Display headers for display table
		System.out.println("\n"
				+ "Fee Name\tFee Original Amount\tFee Unpaid Amount\tTransaction Amount\tPayment Number\tPayment Unused Amount\tPayment Original Amount\n"
				+ "------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		
		//Get first fee entered in for later processing in case there is extra Payments left over
		Fee firstFeeEntered = unpaidFees.peek();
		
		//While there are still unpaid Fee amounts,
		while (unpaidFees.size() > 0 && unusedPayments.size() > 0) {
			//Pay some fees with payments, if there are still payments to use
			Fee currentFee = unpaidFees.peek();
			if (unusedPayments.size() > 0) {
				Payment currentPayment = unusedPayments.peek();
				Transaction t = CreateTransaction(currentFee, currentPayment);
				
				ProcessTransaction(t, feeI, paymentI);
				
				//If either Fee is fully paid or Payment is full used, remove them from Queue
				if (t.getFee().getAmount() <= 0) {
					unpaidFees.poll();
					feeI++;
				}
				if (t.getPayment().getAmount() <= 0) {
					unusedPayments.poll();
					paymentI++;
				}
				
				unprocessedTransactions.poll();
				
			}
			
		}
		
		
		//If there are still any Payments with unused amounts, create transactions that add their payment to
		//the first fee entered by user
		if (unusedPayments.size() > 0) {
			System.out.println("\nAll Fees paid. Unused Payments reamin.\n"
					+ "\nUnused Payment Transactions, applied to first entered Fee\n\n"
					+ "Fee Name\tFee Original Amount\tFee Unpaid Amount\tTransaction Amount\tPayment Number\tPayment Unused Amount\tPayment Original Amount\n"
					+ "------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			
			//Since I am actually "processing" these amounts, and updating each object to have its
			//new amount, I got the first Fee at the start of the method. This will be passed to the overloaded
			//CreateTransaction as its Fee, so that the actual Fee Object will have it's amount of 0 deducted further in the event of extra
			//Payments
			
			while (unusedPayments.size() > 0) {
				//Apply each unused amount to the first created Fee
				Payment p = unusedPayments.poll();
				
				Transaction t = CreateTransaction(firstFeeEntered, p, p.getAmount());
				
				ProcessExcessTransaction(t, 0, paymentI);
				paymentI++;
			}
			
			//Show the First Fee's new info after all excess Payments went into it.
			//NOTE - using Math.Abs to show it as a positive number
			System.out.println(String.format("First Fee new data after excess Payments -- Name: %s, Original Amount: $%.2f, Excess Paid Amount: $%.2f",
					firstFeeEntered.getName(), allFees.get(0).getAmount(), Math.abs(firstFeeEntered.getAmount())));
			
		}	
		
		//If any unpaid Fees remain after payments are depleted, display them
		if (unpaidFees.size() > 0) {
			System.out.println("\nAll Payments used. Unpiad Fees remain.\n"
					+ "\nUnpaid Fees\n\n"
					+ "Fee Name\tFee Original amount\tFee Unpaid Amount\n"
					+ "-----------------------------------------------------------");
			
			while (unpaidFees.size() > 0) {
				Fee f = unpaidFees.poll();
				System.out.println(String.format("%s\t\t$%.2f\t\t\t$%.2f",
						f.getName(), allFees.get(feeI).getAmount(), f.getAmount()));
				feeI++;
			}			
			
		}
		
		
		//Display sum of Fees, Transactions, and Payments
		double fSum = allFees.stream().mapToDouble(f -> f.getAmount()).sum();
		double pSum = allPayments.stream().mapToDouble(p -> p.getAmount()).sum();
		double tSum = allTransactions.stream().mapToDouble(t -> t.getAmount()).sum();
		
		System.out.println(String.format("\n"
				+ "Fee Amount Total\tTransaction Amount Total\tPayment Amount Total\n"
				+ "---------------------------------------------------------------------------\n"
				+ "$%.2f\t\t\t$%.2f\t\t\t\t$%.2f",
				fSum, pSum, tSum));
		
	}
	
	
	/**
	 * Process the transaction and display the results. Results include the Transaction's Fee, the Fee's original and unpaid Amount,
	 * the Transaction's Amount, and the Payment's unused and original Amount. For each processed transaction, the Transaction Amount 
	 * is deducted from the Fee's unpaid Amount and from the Payments unused Amount.
	 * 
	 * @param transaction - the transaction to process
	 * @param feeI - the index of the transaction's Fee in allFees. Used for determining Fee's original amount
	 * @param paymentI - the index of the transaction's Payment in allPayments. Used for determining Payments's original amount
	 */
	public void ProcessTransaction(Transaction transaction, int feeI, int paymentI) {
		Fee fee = transaction.getFee();
		Payment payment = transaction.getPayment();
		
		System.out.println(String.format("%s\t\t$%.2f\t\t\t$%.2f\t\t\t$%.2f\t\t\t%d\t\t$%.2f\t\t\t$%.2f",
				fee.getName(), allFees.get(feeI).getAmount(), fee.getAmount(), transaction.getAmount(), paymentI+1, payment.getAmount(), allPayments.get(paymentI).getAmount()));
		
		transaction.PerformTransaction();
		//System.out.println("Transaction Processed!\n"
				//+ "-----------------------");
	}
	
	public void ProcessExcessTransaction(Transaction transaction, int feeI, int paymentI) {
		Fee fee = transaction.getFee();
		Payment payment = transaction.getPayment();
		
		System.out.println(String.format("%s\t\t$%.2f\t\t\t$%.2f\t\t\t$%.2f\t\t\t%d\t\t$%.2f\t\t\t$%.2f",
				fee.getName(), allFees.get(feeI).getAmount(), fee.getAmount(), transaction.getAmount(), paymentI+1, payment.getAmount(), allPayments.get(paymentI).getAmount()));
		
		transaction.PerformExcessTransaction();
		//System.out.println("Transaction Processed!\n"
				//+ "-----------------------");
	}
	
	
	public Fee CreateFee(String feeName, float feeAmount) {
		Fee newFee = new Fee(feeName, feeAmount);
		addToAllFees(newFee.Clone());
		addToUnpaidFees(newFee);
		return newFee;
	}	
	
	public Payment CreatePayment(float paymentAmount) {
		Payment newPayment = new Payment(paymentAmount);
		addToAllPayments(newPayment.Clone());
		addToUnusedPayments(newPayment);
		return newPayment;
	}
	
	public Transaction CreateTransaction(Fee fee, Payment payment) {
		Transaction newTransaction = new Transaction(fee, payment);
		addToAllTransactions(newTransaction);
		addToUnprocessedTransactions(newTransaction);
		return newTransaction;
	}
	
	private Transaction CreateTransaction(Fee fee, Payment payment, float amount) {
		Transaction newTransaction = new Transaction(fee, payment, amount);
		addToAllTransactions(newTransaction);
		addToUnprocessedTransactions(newTransaction);
		return newTransaction;
	}
	
	public List<Fee> getAllFees() {
		return allFees;
	}
	public void setAllFees(List<Fee> allFees) {
		this.allFees = allFees;
	}
	public void addToAllFees(Fee ...fees) {
		for (Fee fee : fees) {
			allFees.add(fee);
		}
	}
	
	public List<Payment> getAllPayments() {
		return allPayments;
	}
	public void setAllPayments(List<Payment> allPayments) {
		this.allPayments = allPayments;
	}
	public void addToAllPayments(Payment ... payments) {
		for (Payment payment : payments) {
			allPayments.add(payment);
		}
	}

	public List<Transaction> getAllTransactions() {
		return allTransactions;
	}
	public void setAllTransactions(List<Transaction> allTransactions) {
		this.allTransactions = allTransactions;
	}
	public void addToAllTransactions(Transaction ... transactions) {
		for (Transaction transaction : transactions) {
			allTransactions.add(transaction);
		}
	}

	public Queue<Fee> getUppaidFees() {
		return unpaidFees;
	}
	public void setUppaidFees(Queue<Fee> unpaidFees) {
		this.unpaidFees = unpaidFees;
	}
	public void addToUnpaidFees(Fee ...unpaidFees) {
		for (Fee fee : unpaidFees) {
			this.unpaidFees.add(fee);
		}
	}	
	
	public Queue<Payment> getUnusedPayments() {
		return unusedPayments;
	}
	public void setUnusedPayments(Queue<Payment> unusedPayments) {
		this.unusedPayments = unusedPayments;
	}
	public void addToUnusedPayments(Payment ... unusedPayments) {
		for (Payment payment : unusedPayments) {
			this.unusedPayments.add(payment);
		}
	}

	public Queue<Transaction> getUnprocessedTransactions() {
		return unprocessedTransactions;
	}
	public void setUnprocessedTransactions(Queue<Transaction> unprocessedTransactions) {
		this.unprocessedTransactions = unprocessedTransactions;
	}
	public void addToUnprocessedTransactions(Transaction ... unprocessedTransactions) {
		for (Transaction transaction : unprocessedTransactions) {
			this.unprocessedTransactions.add(transaction);
		}
	}
	
	
	
}
