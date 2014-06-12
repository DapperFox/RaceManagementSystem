package models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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

    //racers is contained in RaceEvent

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinTable(name="raceEvent_racer",
            joinColumns=@JoinColumn(name="racer_id"),
            inverseJoinColumns=@JoinColumn(name="raceEvent_id"))
    private Set<RaceEvent> racerEvents = new HashSet<RaceEvent>();

    //results is contained in RaceEvent
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="racer")
    private Set<RaceResult> raceResults = new HashSet<RaceResult>();

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
	
    public Set<RaceEvent> getRacerEvents() {
		return racerEvents;
	}

	public void setRacerEvents(Set<RaceEvent> racerEvents) {
		this.racerEvents = racerEvents;
	}
}
