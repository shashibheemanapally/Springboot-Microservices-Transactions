package com.shashi.Bank.client;

import javax.crypto.SealedObject;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shashi.Bank.model.Transaction;

@FeignClient(name = "transaction-q", url = "http://localhost:8082")
public interface TransactionQClient {
	@RequestMapping(method = RequestMethod.POST, value = "/transactions", consumes = "application/json")
    void create(SealedObject enctxn);
}
