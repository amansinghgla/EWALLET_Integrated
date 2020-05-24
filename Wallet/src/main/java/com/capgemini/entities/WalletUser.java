/**
* Created by:Aman Singh
* Description: This is an entity class used to define variables that are going to be used in the application.
*              This also contains getter and setter methods for retrieving and updating the values of the variables.
*/



package com.capgemini.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "walletuser10")
public class WalletUser implements Serializable {

	@NotNull(message="User Id is Mandatory")
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(sequenceName="user_seq",initialValue=1000,allocationSize=1,name="user_seq")
	private int id;

	@NotNull(message="UserName is Mandatory")
	@Size(min=3,max=25,message="Length must be from 3 to 25 character ")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank scpace is allowed" )
	@Column(name="username",length=25)
	private String username;

	@NotEmpty(message = "user password is mandatory")
	@Column(name="password")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$")
	private String pass;

	@NotNull(message="Phone number is Mandatory")
	@Size(max=10,message="Number must be of 10 digits")
	@Column(name="phonenumber")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phone;
	
	@NotNull(message="Login Name is Mandatory")
	@Size(min=3,max=25,message="Length can be betwwen 3 and 25 chars")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message="allow only alphabets and a blank scpace is allowed" )
	@Column(name="loginname" ,length=25)
	private String loginName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "accid")
	private WalletAccount wallet;

	public WalletUser() {
		super();
	}

	

	public WalletUser(@NotNull(message = "User Id is Mandatory") int id,
			@NotNull(message = "UserName is Mandatory") @Size(min = 3, max = 25, message = "Length must be from 3 to 25 character ") @Pattern(regexp = "([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message = "allow only alphabets and a blank scpace is allowed") String username,
			@NotEmpty(message = "user password is mandatory") @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,14}$") String pass,
			@NotNull(message = "Phone number is Mandatory") @Size(max = 10, message = "Number must be of 10 digits") @Pattern(regexp = "(^$|[0-9]{10})") String phone,
			@NotNull(message = "Login Name is Mandatory") @Size(min = 3, max = 25, message = "Length can be betwwen 3 and 25 chars") @Pattern(regexp = "([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message = "allow only alphabets and a blank scpace is allowed") String loginName,
			WalletAccount wallet) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.phone = phone;
		this.loginName = loginName;
		this.wallet = wallet;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public WalletAccount getWallet() {
		return wallet;
	}

	public void setWallet(WalletAccount wallet) {
		this.wallet = wallet;
	}
	

	public String getLoginName() {
		return loginName;
	}



	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}



	@Override
	public String toString() {
		return "WalletUser [id=" + id + ", username=" + username + ", pass=" + pass + ", phone=" + phone
				+ ", loginName=" + loginName + ", wallet=" + wallet + "]";
	}







	
}
