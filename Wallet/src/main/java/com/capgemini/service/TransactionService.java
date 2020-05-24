package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.WalletTransaction;
import com.capgemini.entities.WalletAccount;

public interface TransactionService 
{
	public Boolean TransferAmount(WalletTransaction t);
	public List<WalletTransaction> transactionHistory(int id);
	public void updateBalance(int accId, double amount);
	public WalletAccount findAccount(int accId);
}
