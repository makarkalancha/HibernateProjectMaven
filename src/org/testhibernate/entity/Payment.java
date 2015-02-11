package org.testhibernate.entity;

import java.io.Serializable;

/**
 * @author makar
 * Date: Feb 11, 2015
 * Time: 2:40:23 PM
 */
public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char paymentID;
	private float paymentAmount;
	
	public Payment(){
		
	}

	public char getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(char paymentID) {
		this.paymentID = paymentID;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
}


