package com.harriserpexercise.entities;

/**
 * 
 * @author Alex Frye
 *
 */
public class Transaction {
	
	private float amount;
	
	private Fee fee;
	private Payment payment;
	
	boolean paymentLeft = false;
	
	public Transaction() {}
	
	public Transaction(float amount) {
		if (amount > 0)
			this.amount = amount;
	}
	
	public Transaction(Fee fee, Payment payment) {
		this.fee = fee;
		this.payment = payment;
		
		DetermineTransactionAmount();
	}
	
	/**
	 * For last Transactions to create when there are excess payments
	 * @param fee
	 * @param payment
	 * @param amount - overridden amount for new transaction
	 */
	public Transaction(Fee fee, Payment payment, float amount) {
		this.fee = fee;
		this.payment = payment;		
		this.amount = amount;
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
	* Deducts Payment from Fee.
	* @return If payment has money left, return true.
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
		if (amount > 0)
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
