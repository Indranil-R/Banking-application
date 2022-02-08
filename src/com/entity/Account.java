package com.entity;

public class Account {
	
	private long account_number;
	private String name;
	private String password;
	private String email_id;
	private long mobile_number;
	private float amount;
	private String address;
	
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Account(long account_number, String name, String password, String email_id, long mobile_number, float amount,
			String address) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.password = password;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.amount = amount;
		this.address = address;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", name=" + name + ", password=" + password + ", email_id="
				+ email_id + ", mobile_number=" + mobile_number + ", amount=" + amount + ", address=" + address + "]";
	}
	

}
