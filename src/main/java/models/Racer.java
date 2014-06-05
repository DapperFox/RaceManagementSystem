package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="racer")

public class Racer {

	@Id
	@Column(name="id")
	@SequenceGenerator(name="RacerSequence", sequenceName="racer_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RacerSequence")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birth_date")
	private String birthDate;
		
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL}, mappedBy="racer")
	private Set<RaceResult> results = new HashSet<>();
	
	@Transient
	private boolean isLoggedIn = false;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Racer(){
		
	}
	
	public Long getId() {
		return id;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    //racers is contained in RaceEvent
    @ManyToMany(mappedBy="racers")
    private Set<RaceEvent> racerEvents = new HashSet<RaceEvent>();

    //results is contained in RaceEvent
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy="racer")
//    @JoinTable(name="racer_raceResult",
//            joinColumns=@JoinColumn(name="racer_id"),
//            inverseJoinColumns=@JoinColumn(name="raceResult_id"))
    private Set<RaceResult> raceResults = new HashSet<RaceResult>();
}
