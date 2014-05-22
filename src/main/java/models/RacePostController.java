package models;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class RacePostController {

    @Inject private RaceService raceService;

	public ModelAndView createNewRaceEvent(){
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
		ModelAndView model = new ModelAndView(race, "/WEB-INF/RaceDetails.jsp");
		return model;
	}

}
