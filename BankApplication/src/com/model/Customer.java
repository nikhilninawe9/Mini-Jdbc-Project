package com.model;

public class Customer {
	private int id;
	private String name;
	private String address;
	private Long accountNumber;
	private String email;
	private Long mobileNumber;
	private String password;
	private Long balance;

	public Customer() {
		super();
	}

	public Customer(int id, String name, String address, Long accountNumber, String email, Long mobileNumber,
			String password, Long balance) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.accountNumber = accountNumber;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", accountNumber=" + accountNumber
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", password=" + password + ", balance="
				+ balance + "]";
	}

}
