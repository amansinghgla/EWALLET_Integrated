package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.daos.WalletUserDao;
import com.capgemini.daos.WalletTransactionDao;
import com.capgemini.daos.WalletAccountDao;
import com.capgemini.entities.WalletUser;
import com.capgemini.entities.WalletAccount;
import com.capgemini.exception.ApplicationException;


@Service
@Transactional
public class WalletAccountServiceImpl implements WalletAccountService{
	
	@Autowired
	WalletUserDao userdao;
	@Autowired
	WalletAccountDao accountdao;
	@Autowired
	WalletTransactionDao transferdao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBalance(int accId, double amount) {
		// TODO Auto-generated method stub
		WalletAccount w;
		Optional<WalletAccount> p = accountdao.findById(accId);
		if (p.isPresent())
			w = p.get();
		else
			throw new ApplicationException("Account not found!"); 

		w.setBalance(amount);

	}
    @Override
	@Transactional(propagation = Propagation.REQUIRED)
	public double deposite(WalletAccount w, double amount) {
		// TODO Auto-generated method stub
		if (amount >= 0) {
			double new_balance = w.getBalance() + amount;			
			updateBalance(w.getAccountId(),new_balance);
			System.out.println("deposite");
			return new_balance;
		}

		return w.getBalance();
	}
	
	@Override
	@Transactional(readOnly = true)
	public WalletAccount findAccount(int accId) {
		// TODO Auto-generated method stub
		Optional<WalletAccount> a = accountdao.findById(accId);
		
		if (a.isPresent()) 
			return a.get();
		else
			throw new ApplicationException("AccountId  not found!"); // throwing custom exception if account doesn't exist
		
	}
	@Override
	@Transactional(readOnly = true)
	public WalletUser userProfile(int userId) {
		// TODO Auto-generated method stub
		WalletUser a = userdao.findById(userId).orElse(new WalletUser());
		
		if(a.getId() == 0) {
			throw new ApplicationException("Account not found!");
			
		}
		else {
			System.out.println(a.getWallet().getBalance()+" =================== ");
			return a;
		}

	}


}