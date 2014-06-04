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
}
