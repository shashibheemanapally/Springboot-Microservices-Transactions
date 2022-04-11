package com.shashi.TransactionQ.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.shashi.TransactionQ.entity.TransactionEntity;
import com.shashi.TransactionQ.model.Transaction;
import com.shashi.TransactionQ.repository.TransactionRepository;
import com.shashi.TransactionQ.util.ObjectEncryptionDecryption;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ObjectEncryptionDecryption edUtil;
	


	public void addTransaction(String encTxnString) throws Exception {
		
		String txnString = edUtil.decryptString(encTxnString);
		
		Gson gson = new Gson(); 
		Transaction txn = gson.fromJson(txnString, Transaction.class); 
		
		
		
		TransactionEntity te = new TransactionEntity();
		te.setAccountFrom(txn.getAccountFrom());
		te.setAccountNumber(txn.getAccountNumber());
		te.setAmount(txn.getAmount());
		te.setCurrency(txn.getCurrency());
		te.setType(txn.getType());
		
		transactionRepository.save(te);
	}

}
