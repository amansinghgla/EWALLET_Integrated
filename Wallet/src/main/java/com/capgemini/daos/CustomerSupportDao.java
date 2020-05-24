package com.capgemini.daos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entities.CustomerSupport;



public interface CustomerSupportDao extends JpaRepository<CustomerSupport,Integer>  { 
	
	
	

}
