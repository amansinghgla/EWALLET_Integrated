/**
* @author:Aman Singh
* Description: This is a service class which is providing the functionality like adding issue by cutomer,
* and fetching list of all issues faces by customer.
*/


package com.capgemini.service;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.CustomerSupport;
import com.capgemini.daos.CustomerSupportDao;
import com.capgemini.exception.WalletUserException;

@Service

	
	

public class CustomerSupportServiceImpl implements CustomerSupportService {
	
	
	@Autowired
	private CustomerSupportDao customersupportdao;

	@Override
	public List<CustomerSupport> getAllIssue() {
		// TODO Auto-generated method stub
		return customersupportdao.findAll();
	}
	
	@Override
	public CustomerSupport saveIssue(CustomerSupport customersupport) {
		return customersupportdao.save(customersupport);
	}

	@Override
	public boolean addIssue(CustomerSupport customersupport) {
	
		CustomerSupport supportResult= customersupportdao.save(customersupport);
		if(supportResult!=null) {
			return true;
		}
		else
			return false;
	}
	}
