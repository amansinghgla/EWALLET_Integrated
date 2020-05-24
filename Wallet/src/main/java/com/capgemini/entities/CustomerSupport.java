/**
* Created by:Aman Singh
* Description: This is an entity class used to define variables that are going to be used in the application.
*              This also contains getter and setter methods for retrieving and updating the values of the variables.
*/

package com.capgemini.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;




@Entity
@Table(name="customersupport10")
public class CustomerSupport {
	@Id
	@Column(name="cust_user_id")
	private Integer CustomerUserId;
	
	@Column(name="cust_user_name" ,length=25)
	private String CustomerUserName;
	
	@Column(name="cust_phone_number")
	private String CustomerPhoneNumber;
	
	
	@Column(name="cust_issue")
	private String  CustomerIssue;
	
	@Column(name="dateof_issue" )
	@JsonDeserialize(using=DateDeserializer .class)
	private Date DateOfIssue;

	public Integer getCustomerUserId() {
		return CustomerUserId;
	}

	public void setCustomerUserId(Integer customerUserId) {
		CustomerUserId = customerUserId;
	}

	public String getCustomerUserName() {
		return CustomerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		CustomerUserName = customerUserName;
	}

	public String getCustomerPhoneNumber() {
		return CustomerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		CustomerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerIssue() {
		return CustomerIssue;
	}

	public void setCustomerIssue(String customerIssue) {
		CustomerIssue = customerIssue;
	}

	public Date getDateOfIssue() {
		return DateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		DateOfIssue = dateOfIssue;
	}

	public CustomerSupport(Integer customerUserId, String customerUserName, String customerPhoneNumber,
			String customerIssue, Date dateOfIssue) {
		super();
		CustomerUserId = customerUserId;
		CustomerUserName = customerUserName;
		CustomerPhoneNumber = customerPhoneNumber;
		CustomerIssue = customerIssue;
		DateOfIssue = dateOfIssue;
	}

	public CustomerSupport() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerSupport [CustomerUserId=" + CustomerUserId + ", CustomerUserName=" + CustomerUserName
				+ ", CustomerPhoneNumber=" + CustomerPhoneNumber + ", CustomerIssue=" + CustomerIssue + ", DateOfIssue="
				+ DateOfIssue + "]";
	}
	
	 
	
	
	
	
	

}
