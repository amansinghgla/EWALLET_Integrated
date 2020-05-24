package com.capgemini.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
@Entity
@Table(name = "wallettransaction10")
public class WalletTransaction implements Serializable  {

	

	@Id
	@NotNull(message="id is mandatory")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trans_seq")
	@SequenceGenerator(sequenceName="trans_seq",initialValue=05000,allocationSize=1,name="trans_seq")
	@Column(name="traid")
	private int tranId;
	
	@NotNull(message="should not be null")
	@Column(name="senderid")
	private int senderAccId;
	
	@NotNull(message="Should not be null")
	@Column(name="receiverid")
	private int receiverAccId;
	
	@NotNull(message="Amount is mandatory")
	@Min(value=1000, message="Can transfer minimum Rs. 1000")
	@Max(value=50000, message="Can transfer maximum Rs. 50000")
	@Column(name="amt")
	private double amount;
	
	@Column(name="transactiondate")
	@JsonDeserialize(using=DateDeserializer .class)
	private Date dateofTransaction;
	
	
	
	public WalletTransaction() {
		super();
	}



	public WalletTransaction(@NotNull(message = "id is mandatory") int tranId,
			@NotNull(message = "should not be null") int senderAccId,
			@NotNull(message = "Should not be null") int receiverAccId,
			@NotNull(message = "Amount is mandatory") @Min(value = 1000, message = "Can transfer minimum Rs. 1000") @Max(value = 50000, message = "Can transfer maximum Rs. 50000") double amount,
			Date dateofTransaction) {
		super();
		this.tranId = tranId;
		this.senderAccId = senderAccId;
		this.receiverAccId = receiverAccId;
		this.amount = amount;
		this.dateofTransaction = dateofTransaction;
	}



	public int getTranId() {
		return tranId;
	}



	public void setTranId(int tranId) {
		this.tranId = tranId;
	}



	public int getSenderAccId() {
		return senderAccId;
	}



	public void setSenderAccId(int senderAccId) {
		this.senderAccId = senderAccId;
	}



	public int getReceiverAccId() {
		return receiverAccId;
	}



	public void setReceiverAccId(int receiverAccId) {
		this.receiverAccId = receiverAccId;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Date getDateofTransaction() {
		return dateofTransaction;
	}



	public void setDateofTransaction(Date dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}



}