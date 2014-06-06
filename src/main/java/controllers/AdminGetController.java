package controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import models.Admin;
import models.ModelAndView;
import models.RaceService;
import models.Racer;
import models.RequestInjectingServletRequestListener;

public class AdminGetController {

	@Inject private RaceService raceService;
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
		HttpSession session = request.getInstance().getSession();
		Long id = (Long)session.getAttribute("accountID");
		Admin admin = raceService.getAdmin(id);
		
		ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/admindashboard.jsp");
		
		return modelAndView;
	} 
}
