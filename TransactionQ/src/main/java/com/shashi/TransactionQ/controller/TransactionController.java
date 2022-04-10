package com.shashi.TransactionQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.TransactionQ.entity.TransactionEntity;
import com.shashi.TransactionQ.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@RequestMapping(method = RequestMethod.POST)
	public void addWord(@RequestBody TransactionEntity txn) {
		transactionService.addTransaction(txn);
	}
}
