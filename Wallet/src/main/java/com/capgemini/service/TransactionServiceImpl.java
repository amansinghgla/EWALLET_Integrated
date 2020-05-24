package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.capgemini.daos.WalletTransactionDao;
import com.capgemini.daos.WalletAccountDao;
import com.capgemini.entities.WalletTransaction;
import com.capgemini.entities.WalletAccount;
import com.capgemini.exception.ApplicationException;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService
{
	
	@Autowired
	WalletAccountDao accountdao;
	
	@Autowired
	WalletTransactionDao transactionDao;
	
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
	public List<WalletTransaction> transactionHistory(int senderId) {
		// TODO Auto-generated method stub
		List<WalletTransaction>history = transactionDao.findBySenderAccId(senderId);
		System.out.println(history.get(0));
		return history;
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Boolean TransferAmount(WalletTransaction t) {
		// TODO Auto-generated method stub
		if(t.getAmount()<=0) {
		throw new ApplicationException("Transfer Can't be happen due to invalid amount ")			;
		}
			
			
			
			WalletAccount sender = findAccount(t.getSenderAccId());
			WalletAccount receiver = findAccount(t.getReceiverAccId());
			double sender_new_balance = sender.getBalance()-t.getAmount();
			double receiver_new_balance = receiver.getBalance() +t.getAmount();
			
			
			updateBalance(sender.getAccountId(),sender_new_balance);
			updateBalance(receiver.getAccountId(),receiver_new_balance);
		
			transactionDao.save(t);
		return true;
	}
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

	

}
