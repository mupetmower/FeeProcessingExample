package com.harriserpexercise.entities;

public class Fee {
	
	private String name;	
	private float amount;
	
	
	public Fee() {}
	
	public Fee(String name, float amount) {		
		this.name = name;
		this.amount = amount;
	}
	
	
	public void DeductPayment(float paymentAmount) {
		amount -= paymentAmount;		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
