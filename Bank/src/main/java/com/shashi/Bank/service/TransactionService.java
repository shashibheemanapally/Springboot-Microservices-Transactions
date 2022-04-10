package com.shashi.Bank.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shashi.Bank.client.TransactionQClient;
import com.shashi.Bank.model.Transaction;
import com.shashi.Bank.util.ObjectEncryptionDecryption;

@Service
public class TransactionService {
	
	@Autowired
	TransactionQClient client;
	
	@Autowired
	private ObjectEncryptionDecryption edUtil;

	public void addTransactionToQ(Transaction txn) throws InvalidKeyException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		SealedObject encTxn = edUtil.encryptObject(txn);
		client.create(encTxn);
		
	}

}
