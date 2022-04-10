package com.shashi.TransactionQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashi.TransactionQ.entity.TransactionEntity;
import com.shashi.TransactionQ.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public void addTransaction(TransactionEntity txn) {
		transactionRepository.save(txn);
	}

}
