package com.obsqura.model;

public class Person {

	public String phoneNumber, email, address,deliveryTime, deliveryCharge;

	public Person(String phoneNumber, String email, String address, String deliveryTime, String deliveryCharge) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.deliveryTime = deliveryTime;
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "Person [phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", deliveryTime="
				+ deliveryTime + ", deliveryCharge=" + deliveryCharge + "]";
	}
	
	
	
	
}
