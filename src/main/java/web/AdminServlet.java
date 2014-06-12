package web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ModelAndView;
import controllers.AdminGetController;
import controllers.AdminPostController;
import controllers.RacerGetController;
import controllers.RacerPostController;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
	@Inject
    AdminPostController adminPostController;
    @Inject
    AdminGetController adminGetController;

    String regexRegister = "/admin/register";
    String regexLogin = "/admin/login";
    String regextAdminDashboard = "/admin";
    String regexAdminUDPattern = "(/admin/)([0-9]+)(/[A-Za-z]*)";
    String regextRacerResults = "/admin/([0-9]+)/results";
    String regextSubmitResults = "/admin/([0-9]+)/submitRaceResults";
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriString = request.getRequestURI();
        ModelAndView modelAndView = null;

        Pattern pattern = Pattern.compile(regexRegister);
        Matcher matcher = pattern.matcher(uriString);
        
        if(matcher.matches()){
            modelAndView = adminGetController.createNewAdmin();        
        }
        
        pattern = Pattern.compile(regexLogin);
        matcher = pattern.matcher(uriString);
        if(matcher.matches()){
        	modelAndView = adminGetController.adminLogin();
        }
        
        pattern = Pattern.compile(regextAdminDashboard);
        matcher = pattern.matcher(uriString);
        if(matcher.matches()){
        	modelAndView = adminGetController.adminDashboard();
        }
        
        pattern = Pattern.compile(regextRacerResults);
        matcher = pattern.matcher(uriString);
        if(matcher.matches()){
        	Long id = Long.parseLong(matcher.group(1));
        	modelAndView = adminGetController.inputResultsPage(id);
        }
        
        pattern = Pattern.compile(regexAdminUDPattern);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			if (matcher.group(3) != null) {
				if (matcher.group(3).equalsIgnoreCase("/update")) {
					modelAndView = adminGetController.updateRace(Long
							.parseLong(matcher.group(2)));
				} else if (matcher.group(3).equalsIgnoreCase("/delete")) {
					modelAndView = adminGetController.deleteRace(Long
							.parseLong(matcher.group(2)));
				} 
			}
		}
        
        request.setAttribute("model", modelAndView.getModel());
        RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriString = request.getRequestURI();
        ModelAndView modelAndView = null;
        
        Pattern pattern = Pattern.compile(regexRegister);
        Matcher matcher = pattern.matcher(uriString);
        if(matcher.matches()){
            modelAndView = adminPostController.createNewAdmin();
            
        }
        
        pattern = Pattern.compile(regexLogin);
        matcher = pattern.matcher(uriString);
        if(matcher.matches()){
        	modelAndView = adminPostController.adminLogin();
        }
        
        pattern = Pattern.compile(regextSubmitResults);
        matcher = pattern.matcher(uriString);
        if(matcher.matches()){
        	Long id = Long.parseLong(matcher.group(1));
        	modelAndView = adminPostController.submitResults(id);
        }
        
        pattern = Pattern.compile(regexAdminUDPattern);
		matcher = pattern.matcher(uriString);

		if (matcher.matches()) {
			if (matcher.group(3).equalsIgnoreCase("/update")) {
				modelAndView = adminPostController.updateRace(Long
						.parseLong(matcher.group(2)));
			}
		}
        
        request.setAttribute("model", modelAndView.getModel());
        RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
        view.forward(request, response);
        
        
    }
    
    
}
