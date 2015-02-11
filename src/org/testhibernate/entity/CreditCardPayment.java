package org.testhibernate.entity;

import java.io.Serializable;

/**
 * @author makar
 * Date: Feb 11, 2015
 * Time: 2:42:07 PM
 */
public class CreditCardPayment extends Payment implements Serializable{
	private String creditCardName;
	
	public CreditCardPayment(){
		
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}
	
	

}


