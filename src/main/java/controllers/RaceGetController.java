package controllers;

import models.ModelAndView;
import models.RaceEvent;
import models.RaceResult;
import models.IRaceService;
import models.RequestInjectingServletRequestListener;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

public class RaceGetController {
	
	@Inject private IRaceService raceService;
	@Inject private RequestInjectingServletRequestListener request;
	
	public ModelAndView createNewRaceEvent(){
		RaceEvent race = null;
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/createrace.jsp");
		return modelAndView;
	}
	
	public ModelAndView retrieveRace(Long id){
		RaceEvent race = raceService.getRaceEvent(id);
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/racedetails.jsp");
		return modelAndView;
	}
	
	public ModelAndView retrieveRaceEventList() {
		List raceEventList = raceService.getAllRaceEvents();
		
		ModelAndView eventsModelAndView = new ModelAndView(raceEventList, "/WEB-INF/racelist.jsp");
		return eventsModelAndView;
	}
	
	public ModelAndView retrieveSpecificRaceEventList(String raceType) {
		List raceEventList = raceService.getAllRaceEvents(raceType);
		
		ModelAndView eventsModelAndView = new ModelAndView(raceEventList, "/WEB-INF/racelist.jsp");
		return eventsModelAndView;
	}
	
		
	public ModelAndView getResultsList(Long id){
		//Get the list from the service
		
		RaceEvent raceEvent = raceService.getRaceEvent(id);
		Set<RaceResult> results = raceEvent.getResults();
		ModelAndView modelAndView = new ModelAndView(results, "/WEB-INF/raceresultslist.jsp");
		return modelAndView;
	}

	
}
