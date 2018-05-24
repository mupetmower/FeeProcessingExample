package com.harriserpexercise.entities;

/**
 * 
 * @author Alex Frye
 *
 */
public class Fee {
	
	private String name;	
	private float amount;
	
	
	public Fee() {}
	
	public Fee(String name, float amount) {		
		this.name = name;
		if (amount > 0)
			this.amount = amount;
	}
	
	
	public void DeductPayment(float paymentAmount) {
		if (paymentAmount <= amount)
			amount -= paymentAmount;		
	}
		
	public void ExcessPayment(float paymentAmount) {
		amount -= paymentAmount;
	}
	
	
	public Fee Clone() {
		return new Fee(this.name, this.amount);
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
		if (amount >= 0)
			this.amount = amount;
	}

}
