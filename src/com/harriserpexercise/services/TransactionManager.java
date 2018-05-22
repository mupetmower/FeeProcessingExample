package com.harriserpexercise.services;

import java.util.LinkedList;
import java.util.Queue;

import com.harriserpexercise.entities.Fee;
import com.harriserpexercise.entities.Payment;


public class TransactionManager {
	
	private Queue allFees = new LinkedList<Fee>();
	private Queue allPayments = new LinkedList<Payment>();
	
	
	public TransactionManager() {
		
	}
	
	
	public void ProcessPayment(Payment payment) {
		
	}
	
	
	
	
	
	public Queue getAllFees() {
		return allFees;
	}
	public void setAllFees(Queue allFees) {
		this.allFees = allFees;
	}
	public void addToAllFees(Fee ...fees) {
		for (Fee fee : fees) {
			allFees.add(fee);
		}
	}
	
	public Queue getAllPayments() {
		return allPayments;
	}
	public void setAllPayments(Queue allPayments) {
		this.allPayments = allPayments;
	}
	public void addToAllPayments(Payment ... payments) {
		for (Payment payment : payments) {
			allPayments.add(payment);
		}
	}

}
