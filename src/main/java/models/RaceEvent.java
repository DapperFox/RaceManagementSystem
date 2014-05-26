package models;

import java.text.NumberFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="raceEvent")

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
	
	public RaceEvent(){

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

	
	
	
}
