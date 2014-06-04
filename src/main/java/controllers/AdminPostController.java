package controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import models.Address;
import models.Admin;
import models.ModelAndView;
import models.RaceService;
import models.Racer;
import models.RequestInjectingServletRequestListener;
import security.*;

@Stateless
@LocalBean
public class AdminPostController {
	@Inject
    private RaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;
    @Inject PasswordEncoder passwordEncoder;

    public ModelAndView createNewAdmin() {
				    	
        String username = request.getInstance().getParameter("username");
		String password = request.getInstance().getParameter("password");
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(passwordEncoder.encode(password));
		
		raceService.createAdmin(admin);
		//Don't pass in the the admin
		//...use the admin to get all their races and pass in that list
				
		ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/admindashboard.jsp");

        return modelAndView;
    }
}
