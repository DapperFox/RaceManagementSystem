package models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RaceGetController {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public RaceGetController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

	};
	
	public ModelAndView createNewRaceEvent(){
		RaceEvent race = null;
		ModelAndView model = new ModelAndView(race, "/WEB-INF/CreateRace.jsp");
		return model;
	}
	
	public ModelAndView retrieveRace(Long id){
		//Get model by id
		RaceEvent race = null;
		ModelAndView model = new ModelAndView(race, "/WEB-INF/RaceEvent.jsp");
		return model;
	}

	
}
