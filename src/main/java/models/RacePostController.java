package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class RacePostController {

    @Inject private RaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;

	public ModelAndView createNewRaceEvent(){
		RaceEvent race = new RaceEvent();
		
		String dateAsString = request.getInstance().getParameter("date");
		Date date = formatDate(dateAsString);
		
		race.setRaceName(request.getInstance().getParameter("name"));
		race.setRaceType(request.getInstance().getParameter("type"));
		race.setRaceLocation(request.getInstance().getParameter("location"));
		race.setRaceDate(date);
		race.setRaceTime(request.getInstance().getParameter("time"));
		race.setRaceCost(Double.parseDouble(request.getInstance().getParameter("cost")));
		race.setRaceDescription(request.getInstance().getParameter("description"));
		race.setRaceTwitterPage(request.getInstance().getParameter("twitterPage"));
		race.setRaceFaceBookPage(request.getInstance().getParameter("facebookPage"));
//		race.setImageFilePath(request.getParameter("image"));
		
        raceService.createRaceEvent(race);
		ModelAndView model = new ModelAndView(race, "/WEB-INF/RaceDetails.jsp");
		return model;
	}
	
	private Date formatDate(String dateAsString){	
			
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

		try{
			date = simpleDateFormat.parse(dateAsString);
		} catch (ParseException e){
			e.printStackTrace();
		}
		return date;
	}
	
	public ModelAndView updateRace(Long id){
		RaceEvent race = raceService.getRaceEvent(id);
		
		String dateAsString = request.getInstance().getParameter("date");
		Date date = formatDate(dateAsString);
		
		race.setRaceName(request.getInstance().getParameter("name"));
		race.setRaceType(request.getInstance().getParameter("type"));
		race.setRaceLocation(request.getInstance().getParameter("location"));
		race.setRaceDate(date);
		race.setRaceTime(request.getInstance().getParameter("time"));
		race.setRaceCost(Double.parseDouble(request.getInstance().getParameter("cost")));
		race.setRaceDescription(request.getInstance().getParameter("description"));
		race.setRaceTwitterPage(request.getInstance().getParameter("twitterPage"));
		race.setRaceFaceBookPage(request.getInstance().getParameter("facebookPage"));
		
		raceService.createRaceEvent(race);
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/RaceDetails.jsp");
		return modelAndView;
		
	}
}
