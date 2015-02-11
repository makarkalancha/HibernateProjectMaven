package org.testhibernate.entity;

import java.io.Serializable;

/**
 * @author makar
 * Date: Feb 11, 2015
 * Time: 2:43:40 PM
 */
public class WirePayment extends Payment implements Serializable{
	
	private String bankName;
	private String bankRef;
	
	public WirePayment(){
		
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankRef() {
		return bankRef;
	}

	public void setBankRef(String bankRef) {
		this.bankRef = bankRef;
	}
	
	

}


