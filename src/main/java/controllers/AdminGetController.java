package controllers;

import javax.inject.Inject;

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
}
