package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import models.Account;
import models.Admin;
import models.ModelAndView;
import models.IRaceService;
import models.RaceEvent;
import models.RaceResult;
import models.Racer;
import models.RequestInjectingServletRequestListener;
import models.Role;
import security.*;

@Stateless
@LocalBean
public class AdminPostController {
	@Inject
    private IRaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;
    @Inject PasswordEncoder passwordEncoder;

    public ModelAndView createNewAdmin() {
				    	
        String email = request.getInstance().getParameter("email");
		String password = request.getInstance().getParameter("password");
		
		Account account = new Account();
		account.setEmail(email);
		account.setPassword(passwordEncoder.encode(password));
		account.setRole(Role.ADMIN);
		
		Admin admin = new Admin();
		account.setAdmin(admin);		
		raceService.createAccount(account);
		//Don't pass in the the admin
		//...use the admin to get all their races and pass in that list
		HttpSession session = request.getInstance().getSession();
		session.setAttribute("adminID", admin.getId());

		ModelAndView modelAndView = new ModelAndView(null, "/WEB-INF/admindashboard.jsp");

        return modelAndView;
    }

	public ModelAndView adminLogin() {
		//get account id and authenticate it
		HttpSession session = request.getInstance().getSession();
		Long id = (Long) session.getAttribute("adminID");
		Admin admin = new Admin();
		/*Account acount = 
		if(id == id){
			
		}*/
		
		ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/admindashboard.jsp");

        return modelAndView;
	}

	public ModelAndView submitResults(Long raceId) {
		//Insert a row into race result that has the racer id, race id, raceTime, racePosition
		List<RaceResult> resultsList = new ArrayList<RaceResult>();
		RaceEvent race = raceService.getRaceEvent(raceId);
		Map<String, String[]> arrayData = request.getInstance().getParameterMap();
		for(int i = 0; i < arrayData.size() - 1; i++){
			RaceResult result = new RaceResult();
			Long racerId = Long.parseLong(arrayData.get("racerId")[i]);//request.getInstance().getAttribute("racerId");
			String time = arrayData.get("raceTime")[i];
			int rank = Integer.parseInt(arrayData.get("rank")[i]);
			
			Racer racer = raceService.getRacer(racerId);
			//result.setRacePosition(rank);
			result.setRaceTime(time);
			result.setRacerEvents(race);
			result.setRacer(racer);
			resultsList.add(result);
		}
		ModelAndView modelAndView = new ModelAndView(resultsList, "/WEB-INF/raceresultlist.jsp");
		
		return modelAndView;
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
		ModelAndView modelAndView = new ModelAndView(race, "/WEB-INF/racedetails.jsp");
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
