package models;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RaceGetController {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public RaceGetController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

	}
	
	public ModelAndView createNewRaceEvent(){
		RaceEvent race = null;
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/CreateRace.jsp");
		return modelAndView;
	}
	
	public ModelAndView retrieveRace(Long id){
		//Get model by id
		RaceEvent race = null;
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/RaceEvent.jsp");
		return modelAndView;
	}
	
	public ModelAndView retrieveRaceEventList() {
		ArrayList<RaceEvent> raceEventList = new ArrayList<RaceEvent>();
		
		
		ModelAndView eventsModelAndView = new ModelAndView(raceEventList, "/WEB-INF/RaceList.jsp");
		return eventsModelAndView;
	}

	
}
