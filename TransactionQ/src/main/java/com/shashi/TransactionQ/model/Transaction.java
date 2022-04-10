package com.shashi.TransactionQ.model;

import java.io.Serializable;




public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String AccountNumber;
	String Type;
	Double Amount;
	String Currency;
	String AccountFrom;
	
	
	
	public Transaction() {
		super();
	}
	public Transaction(String accountNumber, String type, Double amount, String currency, String accountFrom) {
		super();
		AccountNumber = accountNumber;
		Type = type;
		Amount = amount;
		Currency = currency;
		AccountFrom = accountFrom;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public String getAccountFrom() {
		return AccountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		AccountFrom = accountFrom;
	}
	
	
}
