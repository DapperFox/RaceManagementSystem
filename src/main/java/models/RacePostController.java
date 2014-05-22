package models;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RacePostController {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private RaceService raceService;

	public RacePostController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

	}
	
	public ModelAndView createNewRaceEvent(){
		//request.getParameters("....");
		//Create raceEvent
		//Add to database
		
		Date date = new Date();
		RaceEvent race = new RaceEvent();
		race.setRaceName("The Great upside-down crab walk");
		race.setRaceCost(5.00);
		race.setImageFilePath("ImageFilePath");
		race.setRaceDate(date);
		race.setRaceDescription("describo");
		race.setRaceFaceBookPage("facebookPageDawg");
		race.setRaceLocation("race location");
		race.setRaceTime("4 A.M.");
		race.setRaceTwitterPage("Tweet");
		race.setRaceType("Crab Walk");
		
		raceService.createRaceEvent(race);
		ModelAndView model = new ModelAndView(race, "/WEB-INF/CreateRace.jsp");
		return model;
	}
	
	
	
}
