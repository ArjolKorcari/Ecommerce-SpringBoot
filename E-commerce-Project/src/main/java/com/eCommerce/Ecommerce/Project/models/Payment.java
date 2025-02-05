package com.eCommerce.Ecommerce.Project.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Payment {
	@Id
	private UUID id;
	private String name;
	private String cvv;
	private String expiration;
	
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	 
	 
	 
	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCvv() {
		return cvv;
	}



	public void setCvv(String cvv) {
		this.cvv = cvv;
	}



	public String getExpiration() {
		return expiration;
	}



	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}



	public PaymentType getPaymentType() {
		return paymentType;
	}



	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}



	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public enum PaymentType {
	    CREDIT_CARD,
	    DEBIT_CARD,
	    PAYPAL,
	    BANK_TRANSFER
	}
}
