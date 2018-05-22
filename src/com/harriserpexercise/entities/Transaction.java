package com.harriserpexercise.entities;

public class Transaction {
	
	private float amount;
	
	private Fee fee;
	private Payment payment;
	
	
	public Transaction() {}
	
	public Transaction(float amount) {
		this.amount = amount;
	}
	
	public Transaction(Fee fee, Payment payment) {
		this.fee = fee;
		this.payment = payment;
	}
	
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Fee getFee() {
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}		
	
}
