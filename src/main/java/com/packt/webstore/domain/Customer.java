package com.packt.webstore.domain;

public class Customer {

	private String firstName;
	private String lastName;
	private long customerId;
	private String address;
	private int numberOfOrdersMade;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public int getNumberOfOrdersMade() {
		return numberOfOrdersMade;
	}
	public void setNumberOfOrdersMade(int numberOfOrdersMade) {
		this.numberOfOrdersMade = numberOfOrdersMade;
	}
	
	public Customer(){
		super();
	}
	
	public Customer(String firstName, String lastName, long customerId, String adress, int numberOfOrdersMade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.address = adress;
		this.numberOfOrdersMade = numberOfOrdersMade;
	}
	
}
