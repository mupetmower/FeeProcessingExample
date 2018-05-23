package com.harriserpexercise.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.harriserpexercise.entities.Fee;
import com.harriserpexercise.entities.Payment;
import com.harriserpexercise.entities.Transaction;

/**
 * 
 * @author Alex Frye
 *
 */
public class TransactionManager {
	
	private List<Fee> allFees = new ArrayList<Fee>();
	private List<Payment> allPayments = new ArrayList<Payment>();
	private List<Transaction> allTransactions = new ArrayList<Transaction>();
	
	//To try to stick to the criteria as much as possible, i didn't want to add an extra "flag" field 
	//to the entities for whether they had been processed
	private Queue<Fee> unpaidFees = new LinkedList<Fee>();
	private Queue<Payment> unusedPayments = new LinkedList<Payment>();
	private Queue<Transaction> unprocessedTransactions = new LinkedList<Transaction>();
	
	
	
	public TransactionManager() {
		
	}
		
	
	public void CreateTransactions() {
		//While there are still unpaid Fee amounts,
		while (unpaidFees.size() > 0) {
			//Pay some fees with payments until they are out
			Fee currentFee = unpaidFees.poll();
			
		}
		
		
		//If there are still any Payments with unused amounts,
		while (unusedPayments.size() > 0) {
			//Apply each unused amount to the first created Fee
			Payment p = unusedPayments.poll();
			CreateTransaction(allFees.get(0), p, p.getAmount());
			
			
		}
		
	}
	
	public Fee CreateFee(String feeName, float feeAmount) {
		Fee newFee = new Fee(feeName, feeAmount);
		addToAllFees(newFee);
		addToUnpaidFees(newFee);
		return newFee;
	}	
	
	public Payment CreatePayment(float paymentAmount) {
		Payment newPayment = new Payment(paymentAmount);
		addToAllPayments(newPayment);
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
