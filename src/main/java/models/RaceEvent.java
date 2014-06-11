package models;

import java.text.NumberFormat;
import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="raceEvent")
@NamedQueries({
	@NamedQuery(name="searchQuery", query="Select r From RaceEvent r WHERE r.raceName LIKE :raceEvent")
})
public class RaceEvent {

	@Id
	@Column(name="id")
	@SequenceGenerator(name="RaceEventSequence", sequenceName="raceEvent_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RaceEventSequence")
	private Long id;
	
	@Column(name="name")
	private String raceName;
	
	@Column(name="description")
	private String raceDescription;
	
	@Column(name="filePath")
	private String imageFilePath;
	
	@Column(name="date")
	private Date raceDate;
	
	@Column(name="time")
	private String raceTime;
	
	@Column(name="cost")
	private Double raceCost;
	
	@Column(name="raceType")
	private String raceType;
	
	@Column(name="location")
	private String raceLocation;
	
	@Column(name="twitter")
	private String raceTwitterPage;
	
	@Column(name="faceBookPage")
	private String raceFaceBookPage;
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;
	
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinTable(name="raceEvent_racer",
            joinColumns=@JoinColumn(name="raceEvent_id"),
            inverseJoinColumns=@JoinColumn(name="racer_id"))
    private Set<Racer> racers = new HashSet<Racer>();

    public Set<Racer> getRacers() {
		return racers;
	}

	public void setRacers(Set<Racer> racers) {
		this.racers = racers;
	}

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST, mappedBy="racerEvent")
    private Set<RaceResult> results = new HashSet<RaceResult>();

	public RaceEvent(){

	}
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void addRacerToRaceEvent(Racer racer){
		racers.add(racer);
	}
	
	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getRaceDescription() {
		return raceDescription;
	}

	public void setRaceDescription(String raceDescription) {
		this.raceDescription = raceDescription;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public Date getRaceDate() {
		return raceDate;
	}

	public void setRaceDate(Date raceDate) {
		this.raceDate = raceDate;
	}
	
	public String getFormattedRaceDate(){
		String raceDay = "";
		if(raceDate.getDay()<10){
			raceDay = "0"+raceDate.getDay();
		}
		else{
			raceDay = ""+raceDate.getDay();
		}
		return ""+raceDate.getYear()+"-"+raceDate.getMonth() +"-"+ raceDay;
	
	}

	public String getRaceTime() {
		return raceTime;
	}

	public void setRaceTime(String raceTime) {
		this.raceTime = raceTime;
	}

	public Double getRaceCost() {
		return raceCost;
	}

	public void setRaceCost(Double raceCost) {
		this.raceCost = raceCost;
	}
	
	public String getFormattedCost() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(raceCost);
	}

	public String getRaceType() {
		return raceType;
	}

	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}

	public String getRaceLocation() {
		return raceLocation;
	}

	public void setRaceLocation(String raceLocation) {
		this.raceLocation = raceLocation;
	}

	public String getRaceTwitterPage() {
		return raceTwitterPage;
	}

	public void setRaceTwitterPage(String raceTwitterPage) {
		this.raceTwitterPage = raceTwitterPage;
	}

	public String getRaceFaceBookPage() {
		return raceFaceBookPage;
	}

	public void setRaceFaceBookPage(String raceFaceBookPage) {
		this.raceFaceBookPage = raceFaceBookPage;
	}

	public Long getId() {
		return id;
	}

    public Set<RaceResult> getResults() {
        return results;
    }

    public void setResults(Set<RaceResult> results) {
        this.results = results;
    }
}
