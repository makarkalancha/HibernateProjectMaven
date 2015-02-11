package org.testhibernate.entity;

import java.io.Serializable;

/**
 * @author makar
 * Date: Feb 11, 2015
 * Time: 2:42:07 PM
 */
public class CreditCardPayment extends Payment implements Serializable{
	private String creditCardNumber;
	
	public CreditCardPayment(){
		
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardName) {
		this.creditCardNumber = creditCardName;
	}
	
	

}


