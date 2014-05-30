package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="address")

public class Address {
	
	@Column(name="address_one")
	private String address1;
	@Column(name="address_two")
	private String address2;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipCode")
	private String zipCode;
	
	public Address(){
		
	}
	
	public Address(String address1, String address2, String city, String state, String zipCode){
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getAddress1() {
		return address1;
	}
	
	public String getAddress2() {
		return address2;
	} 
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
}
