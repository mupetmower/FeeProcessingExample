package com.harriserpexercise.entities;

public class Payment {
	
	private float amount;
	
	
	public Payment() {}	
	
	public Payment(float amount) {
		this.amount = amount;
	}

	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
