/**
* @author:Aman Singh
* Description: This is a controller class which handles the web requests made by the user and then maps it according to the required handler method.
*/


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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.service.WalletUserService;
import com.capgemini.service.WalletUserServiceImpl;


import com.capgemini.entities.WalletUser;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.WalletUserException;
import com.capgemini.entities.Login;
import com.capgemini.entities.User;
import com.capgemini.entities.WalletAccount;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WalletUserController {

	@Autowired
	private WalletUserService walletuserservice;
	
	
	
	

	
	@GetMapping("/viewall")
	public ResponseEntity<List<WalletUser>> getAllUser(){
		List<WalletUser> accountList= walletuserservice.getAllWalletUser();
		return new ResponseEntity<List<WalletUser>>(accountList,HttpStatus.OK);
	}
	
/**
* Method:addAccount
* Description:To map the request of user for registering a new wallet user
* @param walletuser:User's Details
* Created By-Aman Singh
*/	

	
	@CrossOrigin(origins="http://localhost:4200")
		@PostMapping("/add")
		public ResponseEntity<String> addAccount(@Valid @RequestBody WalletUser walletuser, BindingResult br) throws WalletUserException
		{
			String err="";
			if(br.hasErrors()) {
				List<FieldError> errors= br.getFieldErrors();
				for(FieldError error:errors)
					err +=error.getDefaultMessage() +"<br/>";
				throw new WalletUserException(err);
			}
			try {
				walletuserservice.addAccount(walletuser);
				return new ResponseEntity<String>("New WalletUser added", HttpStatus.OK);
				
			}
			catch(DataIntegrityViolationException ex) {
				throw new WalletUserException("ID already exists");
			}
		}

/**
* Method:validateUser
* Description:To map the request of user for login into the application
* @param userLogin:user's username
* Created by- Aman Singh
*/	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/validateUser")
	public ResponseEntity<WalletUser> validateUser(@RequestBody Login userLogin) throws RecordNotFoundException {
		
		WalletUser b=walletuserservice.validateUser(userLogin);	
		return new ResponseEntity<WalletUser>(b, HttpStatus.OK);
	 }
	//return b;

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String>IdNotFoundException(RecordNotFoundException e){
	return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

	}

	
}
