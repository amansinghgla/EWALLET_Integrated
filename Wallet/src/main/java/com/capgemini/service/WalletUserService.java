package com.capgemini.service;

import com.capgemini.entities.WalletUser;


import java.util.List;

import com.capgemini.entities.Login;


public  interface WalletUserService {
		boolean addAccount(WalletUser walletuser);
		List<WalletUser> getAllWalletUser();
		
		WalletUser saveUser(WalletUser user);
		WalletUser validateUser(Login userLogin);
		
	
}

