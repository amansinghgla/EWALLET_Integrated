package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.WalletTransaction;
import com.capgemini.exception.ApplicationException;
import com.capgemini.exception.ApplicationException;
import com.capgemini.service.TransactionServiceImpl;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/transaction")

public class TransactionController {

	

	@Autowired TransactionServiceImpl transactionService;
	
	@PostMapping(value = "/transfer", consumes = { "application/json" })
	public boolean transferMoney(@RequestBody WalletTransaction t) {
		return transactionService.TransferAmount(t);
	}
	
	@GetMapping(value = "/history/{senderId}")
	public List<WalletTransaction> transactionHistory(@PathVariable int senderId) {
		// to find a account by id
		List<WalletTransaction> history = transactionService.transactionHistory(senderId);
		return history; 
	}
}
