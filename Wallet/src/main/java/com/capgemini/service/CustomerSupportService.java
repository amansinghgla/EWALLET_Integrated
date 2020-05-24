package com.capgemini.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Service;

import com.capgemini.exception.WalletUserException;
import com.capgemini.entities.CustomerSupport;

import com.capgemini.daos.CustomerSupportDao;



public interface CustomerSupportService {
	
	boolean addIssue(CustomerSupport customersupport);
	List<CustomerSupport> getAllIssue();
	
	CustomerSupport saveIssue(CustomerSupport customersupport);

}
	
