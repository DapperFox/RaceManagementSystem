package models;

import javax.persistence.*;

@Entity
@Table(name="address")

public class Address {

    @Id
    @Column(name="address_id")
    @SequenceGenerator(name="AddressSequence", sequenceName="address_seq", initialValue=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="AddressSequence")
    private Long id;
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
	
	public Long getId() {
		return id;
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
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
