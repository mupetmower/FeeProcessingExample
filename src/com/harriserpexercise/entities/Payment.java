package com.harriserpexercise.entities;

/**
 * 
 * @author Alex Frye
 *
 */
public class Payment {
	
	private float amount;
	
	
	public Payment() {}	
	
	public Payment(float amount) {
		if (amount > 0)
			this.amount = amount;
	}
	
	
	public void UsePayment(float amountToUse) {
		if (amountToUse <= amount)			
			amount -= amountToUse;
	}
	
	
	public Payment Clone() {
		return new Payment(this.amount);
	}

	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		if (amount > 0)
			this.amount = amount;
	}
	
}
