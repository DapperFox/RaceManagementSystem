package controllers;

import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import filter.CurrentUser;
import models.Admin;
import models.ModelAndView;
import models.RaceEvent;
import models.IRaceService;
import models.RequestInjectingServletRequestListener;

public class AdminGetController {

	@Inject private IRaceService raceService;
	@Inject private RequestInjectingServletRequestListener request;
	
	public ModelAndView createNewAdmin() {
        Admin admin = null;
        ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/adminregister.jsp");

        return modelAndView;
    }

	public ModelAndView adminLogin() {
		Admin admin = null;
        ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/adminlogin.jsp");

        return modelAndView;
	}

	public ModelAndView adminDashboard() {
		Set<RaceEvent> list = null;
        Admin adminCurrent = CurrentUser.getUser().getAdmin();
        if(adminCurrent != null) {
            list = adminCurrent.getRaceList();
        }
		ModelAndView modelAndView = new ModelAndView(list, "/WEB-INF/admindashboard.jsp");
		
		return modelAndView;
	}

	public ModelAndView inputResultsPage(Long id) {
		RaceEvent race = raceService.getAllRacersFromRace(id);
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/inputraceresults.jsp");
		return modelAndView;
	} 
	
	public ModelAndView updateRace(Long id){
		RaceEvent race = raceService.getRaceEvent(id);
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/updaterace.jsp");
		return modelAndView;
	}
	
	public ModelAndView deleteRace(Long id){
		raceService.deleteRaceEvent(id);
		RaceEvent race = null;
		//What jsp do we want this to forward to?
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/racelist.jsp");
		return modelAndView;
	}
}
