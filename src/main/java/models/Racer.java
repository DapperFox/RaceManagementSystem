package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="racer")

public class Racer {

	@Id
	@Column(name="id")
	@SequenceGenerator(name="RaceEventSequence", sequenceName="raceEvent_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RaceEventSequence")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@Column(name="address")
	private Address address;
	
	@Column(name="phone_number")
	private String phoneNumber;
}
