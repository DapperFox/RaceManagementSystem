package models;

import java.util.Date;

public class RaceEvent {

	private String raceName;
	private String raceDescription;
	private String imageFilePath;
	private Date raceDate;
	private String raceTime;
	private Double raceCost;
	private String raceType;
	private String raceLocation;
	private String raceTwitterPage;
	private String raceFaceBookPage;
	
	public RaceEvent(String raceName){
		this.raceName = raceName;
	}
	
	
}
