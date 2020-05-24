package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.WalletUser;
import com.capgemini.exception.ApplicationException;
import com.capgemini.entities.WalletAccount;
import com.capgemini.service.TransactionService;
import com.capgemini.service.WalletAccountService;
import com.capgemini.service.WalletAccountServiceImpl;
import com.capgemini.service.WalletUserService;

@RestController
@RequestMapping("/wallet")
public class WalletAccountController {
	
	
	@Autowired 
	WalletAccountServiceImpl walletService;
	
	@Autowired WalletUserService account;
	@Autowired TransactionService transaction;
	@Autowired WalletAccountService wallet;
	
	@PostMapping(value = "/deposit", consumes = { "application/json" })
	public double deposit(@RequestBody WalletAccount input) {
		WalletAccount w = wallet.findAccount(input.getAccountId());
		double amount = input.getBalance();
		
		return wallet.deposite(w, amount);
	}
	
	@GetMapping(value = "/profile/{id}")
	public WalletUser userProfile(@PathVariable int id) {

		WalletUser a = wallet.userProfile(id);
		return a; 
	}

}
