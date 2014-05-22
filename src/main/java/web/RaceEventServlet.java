package web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ModelAndView;
import models.RaceEvent;
import models.RaceGetController;
import models.RacePostController;


@WebServlet("/race/*")
public class RaceEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String regexCreatePattern = "/race/create";
	String regexRacePattern = "(/race/)([0-9]+)(/[A-Za-z]*)?";
	String regexRaceDetails = "/race/[0-9]+/RaceDetails";
	String regexRaceList = "/race/events";
	
	
    public RaceEventServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		ModelAndView modelAndView = null;
		RaceGetController raceController = new RaceGetController(request, response);
		
				
		Pattern pattern = Pattern.compile(regexCreatePattern);
		Matcher matcher = pattern.matcher(uriString);
		
		if(matcher.matches()){
			modelAndView = raceController.createNewRaceEvent();
			
		}
		
		pattern = Pattern.compile(regexRaceList);
		matcher = pattern.matcher(uriString);
		
		if(matcher.matches()){
		
			modelAndView = null;//raceController.createNewRaceEvent();
			
		}
		
		pattern = Pattern.compile(regexRacePattern);
		matcher = pattern.matcher(uriString);
		
		if(matcher.find()){
			
		}
		
		request.setAttribute("raceEventModel", modelAndView.getModel());
		RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		ModelAndView modelAndView = null;
		Pattern pattern = Pattern.compile(regexCreatePattern);
		Matcher matcher = pattern.matcher(uriString);
		RacePostController raceController = new RacePostController(request, response);
		
		if(matcher.matches()){
			modelAndView = raceController.createNewRaceEvent();
			
		}
	}
}
