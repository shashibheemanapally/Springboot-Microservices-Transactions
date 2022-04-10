package com.shashi.TransactionQ.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
	String AccountNumber;
	String Type;
	Double Amount;
	String Currency;
	String AccountFrom;
}
