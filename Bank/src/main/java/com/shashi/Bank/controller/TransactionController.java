package com.shashi.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.Bank.model.Transaction;
import com.shashi.Bank.service.TransactionService;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@RequestMapping(method = RequestMethod.POST)
	public void addTransaction(@RequestBody Transaction txn) {
		transactionService.addTransactionToQ(txn);
	}
}