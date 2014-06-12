package controllers;

import filter.CurrentUser;
import models.Admin;
import models.ModelAndView;
import models.RaceEvent;
import models.IRaceService;
import models.Racer;
import models.RequestInjectingServletRequestListener;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Stateless
@LocalBean
public class RacePostController {

    @Inject private IRaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;

	public ModelAndView createNewRaceEvent(){
		RaceEvent race = new RaceEvent();
        Admin adminCurrent = CurrentUser.getUser().getAdmin();

		Admin admin = raceService.getAdmin(adminCurrent.getId());
		String dateAsString = request.getInstance().getParameter("date");
		Date date = formatDate(dateAsString);
		
		race.setRaceName(request.getInstance().getParameter("name"));
		race.setRaceType(request.getInstance().getParameter("type"));
		race.setRaceLocation(request.getInstance().getParameter("location"));
		race.setRaceDate(date);
		race.setRaceTime(request.getInstance().getParameter("time"));
		race.setRaceCost(Double.parseDouble(request.getInstance().getParameter("cost")));
		race.setRaceDescription(request.getInstance().getParameter("description"));
        race.setImageFilePath(request.getInstance().getParameter("image"));
		race.setRaceTwitterPage(request.getInstance().getParameter("twitterPage"));
		race.setRaceFaceBookPage(request.getInstance().getParameter("facebookPage"));

        race.setAdmin(admin);
		
        raceService.createRaceEvent(race);
		ModelAndView model = new ModelAndView(race, "/WEB-INF/racedetails.jsp");
		return model;
	}
	
	
	public ModelAndView registerForRace(Long raceId){
        Racer racer = CurrentUser.getUser().getRacer();
        RaceEvent race = raceService.getRaceEvent(raceId);
        racer.addRaceEvents(race);
        raceService.updateRacer(racer);

		List<RaceEvent> raceList = new ArrayList<>();
		raceList.addAll(racer.getRacerEvents());
		
		ModelAndView modelAndView = new ModelAndView(raceList, "/WEB-INF/races.jsp");

		return modelAndView;
	}

	public ModelAndView getSearchedRaces() {
		
		String query = request.getInstance().getParameter("search");
		List<RaceEvent> searchedRaces = raceService.getRaceSearchResults(query);
		ModelAndView modelAndView = new ModelAndView(searchedRaces, "/WEB-INF/racelist.jsp");
		return modelAndView;
	}
	
	private Date formatDate(String dateAsString){	
		
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try{
			date = simpleDateFormat.parse(dateAsString);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return date;
	}
}
