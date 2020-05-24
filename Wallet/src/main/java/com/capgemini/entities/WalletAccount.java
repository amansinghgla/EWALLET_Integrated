package com.capgemini.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wallet10")
public class WalletAccount {

	@NotNull(message="AccountId is Mandatory")
	@Id
	@Column(name="accid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="acc_seq")
	@SequenceGenerator(sequenceName="acc_seq",initialValue=2020200000,allocationSize=1,name="acc_seq")
	private int accountId;

	@NotNull(message="Balance is Mandatory")
	@Min(value=1000, message= "Your Opening amount must be Rs. 1000")
	@Column(name="account_balance")
	private double balance;

	//@OneToOne(mappedBy = "wallet")
	private WalletUser account;

	
	public WalletAccount() {
		super();
	}
	
	

	public WalletAccount(@NotNull(message = "AccountId is Mandatory") int accountId,
			@NotNull(message = "Balance is Mandatory") @Min(value = 1000, message = "Your Opening amount must be Rs. 1000") double balance,
			WalletUser account) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.account = account;
	}



	public WalletAccount(double balance) {
		super();
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public WalletUser getAccount() {
		return account;
	}

	public void setAccount(WalletUser account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Wallet [accountId=" + accountId + ", balance=" + balance + ", account=" + account + "]";
	}
	
	

}
