package com.harriserpexercise.entities;

public class Transaction {
	
	private float amount;
	
	private Fee fee;
	private Payment payment;
	
	boolean paymentLeft = false;
	
	public Transaction() {}
	
	public Transaction(float amount) {
		this.amount = amount;
	}
	
	public Transaction(Fee fee, Payment payment) {
		this.fee = fee;
		this.payment = payment;
		
		DetermineTransactionAmount();
	}
	
	public void DetermineTransactionAmount() {
		if (payment.getAmount() <= fee.getAmount()) {
			amount = payment.getAmount();
		} else {
			amount = fee.getAmount();
			paymentLeft = true;
		}
	}
	
	/**
	**Deduct Payment from Fee. If payment has money left, return true
	**/
	public boolean PerformTransaction() {
		DeductPayment();		
		
		return paymentLeft;
	}
	
	public void DeductPayment() {
		fee.DeductPayment(amount);
		payment.UsePayment(amount);
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
