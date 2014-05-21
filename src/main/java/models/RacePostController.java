package models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RacePostController {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public RacePostController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

	}
	
	public ModelAndView createNewRaceEvent(){
		//request.getParameters("....");
		//Create raceEvent
		//Add to database
		
		RaceEvent race = null;
		ModelAndView model = new ModelAndView(race, "/WEB-INF/CreateRace.jsp");
		return model;
	}
	
	
	
}
