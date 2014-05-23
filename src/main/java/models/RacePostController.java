package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Stateless
@LocalBean
public class RacePostController {

    @Inject private RaceService raceService;
    private @Autowired HttpServletRequest request;

	public ModelAndView createNewRaceEvent(){
		RaceEvent race = new RaceEvent();
		
		String dateAsString = request.getParameter("date");
		Date date = formatDate(dateAsString);
		
		race.setRaceName(request.getParameter("name"));
		race.setRaceType(request.getParameter("type"));
		race.setRaceLocation(request.getParameter("location"));
		race.setRaceDate(date);
		race.setRaceTime(request.getParameter("time"));
		race.setRaceCost(Double.parseDouble(request.getParameter("cost")));
		race.setRaceDescription(request.getParameter("description"));
		race.setRaceTwitterPage(request.getParameter("twitterPage"));
		race.setRaceFaceBookPage(request.getParameter("facebookPage"));
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
}
