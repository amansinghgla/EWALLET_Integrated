/**
* @author:Aman Singh
* Description: This is a service class which is providing the functionality like validating user(login),
* registering a new user and creating account for him.
*/


package com.capgemini.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entities.WalletUser;
import com.capgemini.entities.Login;
import com.capgemini.service.WalletUserService;
import com.capgemini.daos.WalletUserDao;

import com.capgemini.exception.ApplicationException;

@Service
@Transactional
public class WalletUserServiceImpl implements WalletUserService {

	
	@Autowired
	private WalletUserDao walletuserdao;

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return walletuserdao.findAll();
	}
	
	@Override
	public WalletUser saveUser(WalletUser user) {
		return walletuserdao.save(user);
	}
	
/**
* Method: addAccount
* Description: Registers a new wallet user.
* @param walletuser:object containing data about user
*/
	
	
	@Override
	public boolean addAccount(WalletUser walletuser) {
	
		WalletUser accountResult= walletuserdao.save(walletuser);
		if(accountResult!=null) {
			return true;
		}
		else
			return false;
	}
	
/**
* Method: validateUser
* Description: To Validate the user data so that the user can login if credentials exists in database.
*/
	
	
	@Override
	public WalletUser validateUser(Login userLogin) throws ApplicationException{
		
		Optional<WalletUser> optionalUser= walletuserdao.LoginDetails(userLogin.getUsername());
		WalletUser user;
		if(optionalUser.isPresent()) {
			user=optionalUser.get();
			if(user.getPass().equals(userLogin.getPass())){
				return user;
			}
			throw new ApplicationException("Incorrect Password");
			
		}
		else
			throw new ApplicationException("Incorrect User Name");
			
		

	}

	

	
	
}
