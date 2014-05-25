package models;

public class Address {

	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipCode;
	
	public Address(String address1, String address2, String city, String state, int zipCode){
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

	public int getZipCode() {
		return zipCode;
	}
	
	
}
