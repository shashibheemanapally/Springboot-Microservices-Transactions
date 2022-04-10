package com.shashi.TransactionQ.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TRANSACTIONS")
public class TransactionEntity {

	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
		@Column(name = "accountNumber")
		private String accountNumber;
		@Column(name = "type")
		private String type;
		@Column(name = "amount")
		private Double amount;
		@Column(name = "currency")
		private String currency;
		@Column(name = "accountFrom")
		private String accountFrom;
		
		
		
		public TransactionEntity() {
			super();
		}
		public TransactionEntity(Long id, String accountNumber, String type, Double amount, String currency,
				String accountFrom) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.type = type;
			this.amount = amount;
			this.currency = currency;
			this.accountFrom = accountFrom;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getAccountFrom() {
			return accountFrom;
		}
		public void setAccountFrom(String accountFrom) {
			this.accountFrom = accountFrom;
		}
	
}
