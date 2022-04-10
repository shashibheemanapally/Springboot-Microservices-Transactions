package com.shashi.Bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.Bank.client.TransactionQClient;
import com.shashi.Bank.model.Transaction;

@Service
public class TransactionService {
	
	@Autowired
	TransactionQClient client;

	public void addTransactionToQ(Transaction txn) {
		client.create(txn);
		
	}

}
