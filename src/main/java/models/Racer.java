package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable(name="racer_raceResult",
            joinColumns=@JoinColumn(name="racer_id"),
            inverseJoinColumns=@JoinColumn(name="raceResult_id"))
    private Set<RaceResult> raceResults = new HashSet<RaceResult>();
}
