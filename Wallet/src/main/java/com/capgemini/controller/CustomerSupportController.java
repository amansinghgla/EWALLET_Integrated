/**
* @author:Aman Singh
* Description: This is a controller class which handles the web requests made by the user and then maps it according to the required handler method.
*/

package com.capgemini.controller;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.entities.CustomerSupport;
import com.capgemini.service.CustomerSupportService;
import com.capgemini.exception.WalletUserException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CustomerSupportController {
	
	@Autowired
	private CustomerSupportService ser;

/**
* Method:getAllIssue
* Description:It shows all the issues that is faced by cutomer along with their detail
* Created By-Aman Singh
*/	

	@GetMapping("/viewallissue")
	public ResponseEntity<List<CustomerSupport>> getAllissue(){
		List<CustomerSupport> issueList= ser.getAllIssue();
		return new ResponseEntity<List<CustomerSupport>>(issueList,HttpStatus.OK);
	}
	
/**
* Method:addIssue
* Description:To map the request of user for adding customer issue along with user deatails
* @param customersupport:Customer details and its  issue
* Created By-Aman Singh
*/	
	
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addissue")
	public ResponseEntity<String> addIssue(@Valid @RequestBody CustomerSupport customersupport, BindingResult br) throws WalletUserException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors= br.getFieldErrors();
			for(FieldError error:errors)
				err +=error.getDefaultMessage() +"<br/>";
			throw new WalletUserException(err);
		}
		try {
			ser.addIssue(customersupport);
			return new ResponseEntity<String>("New Issue added", HttpStatus.OK);
			
		}
		catch(DataIntegrityViolationException ex) {
			throw new WalletUserException("Same issue for same user already exists");
		}
	}
	
	
	
	
	
	

}

    


