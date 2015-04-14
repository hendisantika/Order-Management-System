package com.hendi.oms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="customerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int customerId;
//	@NotEmpty
//    @cusFirstname
//    @NotEmpty(message = "Please enter your password.")
//    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	String cusFirstname;
	String cusLastname;
	String cusEmail;
	String cusPhoneNo;
	String cusCity;
	String cusProvince;
	String cusCountry;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCusFirstname() {
		return cusFirstname;
	}
	public void setCusFirstname(String cusFirstname) {
		this.cusFirstname = cusFirstname;
	}
	public String getCusLastname() {
		return cusLastname;
	}
	public void setCusLastname(String cusLastname) {
		this.cusLastname = cusLastname;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	public String getCusPhoneNo() {
		return cusPhoneNo;
	}
	public void setCusPhoneNo(String cusPhoneNo) {
		this.cusPhoneNo = cusPhoneNo;
	}
	public String getCusCity() {
		return cusCity;
	}
	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}
	public String getCusProvince() {
		return cusProvince;
	}
	public void setCusProvince(String cusProvince) {
		this.cusProvince = cusProvince;
	}
	public String getCusCountry() {
		return cusCountry;
	}
	public void setCusCountry(String cusCountry) {
		this.cusCountry = cusCountry;
	}
	
	@Override
	public String toString(){
		return "customerId = " + customerId + " , cusFirstname = " + cusFirstname + " , cusLastname = " + cusLastname +
		" , cusEmail = " + cusEmail + " , cusPhoneNo = " + cusPhoneNo + " , cusCity = " + cusCity +
		", cusProvince = " + cusProvince + " , cusCountry = " + cusCountry;
	}
	

}
