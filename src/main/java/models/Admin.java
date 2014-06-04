package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin {

	@Id
	@Column(name="id")
	@SequenceGenerator(name="AdminSequence", sequenceName="admin_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AdminSequence")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="admin", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<RaceEvent> raceList = new HashSet<RaceEvent>();
	
	
	
	public Admin(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
