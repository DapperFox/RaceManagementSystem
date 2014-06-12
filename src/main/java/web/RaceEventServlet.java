package web;

import controllers.RaceGetController;
import controllers.RacePostController;
import filter.CurrentUser;
import models.Account;
import models.ModelAndView;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/race/*")
public class RaceEventServlet extends HttpServlet {
	@Inject
	RacePostController racePostController;
	@Inject
	RaceGetController raceGetController;
	private static final long serialVersionUID = 1L;
	String regexCreatePattern = "/race/create";
	String regexRacePattern = "(/race/)([A-Za-z]*)/([0-9]+)";
	String regexRaceDetails = "/race/([0-9]+)(/)?";
	String regexRaceList = "/race/events";
	String regexSpecificRaceList = "(/race/)(events)(/[A-Za-z]*)";
	String regexRaceSearch = "/race/search";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		ModelAndView modelAndView = null;

		Pattern pattern = Pattern.compile(regexCreatePattern);
		Matcher matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			modelAndView = raceGetController.createNewRaceEvent();
		}

		pattern = Pattern.compile(regexRaceList);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {

			modelAndView = raceGetController.retrieveRaceEventList();
		}
		
		pattern = Pattern.compile(regexSpecificRaceList);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			if (matcher.group(3) != null) {
				if (matcher.group(3).equalsIgnoreCase("/running")) {
					modelAndView = raceGetController.retrieveSpecificRaceEventList("Running");
				} else if (matcher.group(3).equalsIgnoreCase("/cycling")) {
					modelAndView = raceGetController.retrieveSpecificRaceEventList("Cycling");
				} else if (matcher.group(3).equalsIgnoreCase("/triathlon")) {
					modelAndView = raceGetController.retrieveSpecificRaceEventList("Triathlon");
				} else if (matcher.group(3).equalsIgnoreCase("/special")) {
					modelAndView = raceGetController.retrieveSpecificRaceEventList("Special");
				}
			}
		}

		pattern = Pattern.compile(regexRacePattern);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			if (matcher.group(2) != null) {
				if (matcher.group(2).equalsIgnoreCase("/results")) {
					modelAndView = raceGetController.getResultsList(Long
							.parseLong(matcher.group(3)));
				}
			}
		}

		pattern = Pattern.compile(regexRaceDetails);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			Long id = Long.parseLong(matcher.group(1));
			modelAndView = raceGetController.retrieveRace(id);
			if(modelAndView.getModel() == null){
				modelAndView = null;
			}

		}
		if(modelAndView == null){
			response.setStatus(404);
			RequestDispatcher errorView = request.getRequestDispatcher("/WEB-INF/404.jsp");
			errorView.forward(request, response);
		}else{
		request.setAttribute("model", modelAndView.getModel());
		RequestDispatcher view = request.getRequestDispatcher(modelAndView
				.getViewName());
		view.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		ModelAndView modelAndView = null;
		Pattern pattern = Pattern.compile(regexCreatePattern);
		Matcher matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			modelAndView = racePostController.createNewRaceEvent();

		}

		pattern = Pattern.compile(regexRacePattern);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			if(matcher.group(2).equalsIgnoreCase("/register")){
                modelAndView = racePostController.registerForRace(Long
				.parseLong(matcher.group(3)));
				
			}
		}
		
		pattern = Pattern.compile(regexRaceSearch);
		matcher = pattern.matcher(uriString);
		
		if(matcher.matches()){
			modelAndView = racePostController.getSearchedRaces();
		}

		if(modelAndView == null){
			response.setStatus(404);
			RequestDispatcher errorView = request.getRequestDispatcher("/WEB-INF/404.jsp");
			errorView.forward(request, response);
		}else{
		request.setAttribute("model", modelAndView.getModel());
		RequestDispatcher view = request.getRequestDispatcher(modelAndView
				.getViewName());
		view.forward(request, response);
		}
	}
}
