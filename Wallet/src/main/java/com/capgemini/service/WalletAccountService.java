package com.capgemini.service;

import com.capgemini.entities.WalletUser;
import com.capgemini.entities.WalletAccount;

public interface WalletAccountService {
	
	
	public double deposite(WalletAccount w, double amount);
	public void updateBalance(int accId, double amount);
	public WalletAccount findAccount(int accId);
	public WalletUser userProfile(int userId);
	

}
