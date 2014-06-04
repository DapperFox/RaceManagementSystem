package controllers;


import models.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import security.PasswordEncoder;

/**
 * Created by blakebishop on 5/28/14.
 */
@Stateless
@LocalBean
public class RacerPostController {
    @Inject
    private RaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;
    @Inject PasswordEncoder passwordEncoder;
    
    public ModelAndView createNewRacer() {
		Racer racer = new Racer();
		
		String address1 = request.getInstance().getParameter("address_one");
		String address2 = request.getInstance().getParameter("address_two");
		String city = request.getInstance().getParameter("city");
		String state = request.getInstance().getParameter("state");
		String zipCode = request.getInstance().getParameter("zip");
		
		String password = request.getInstance().getParameter("password");
		
		racer.setFirstName(request.getInstance().getParameter("firstName"));
		racer.setLastName(request.getInstance().getParameter("lastName"));
		racer.setEmail(request.getInstance().getParameter("email"));
		racer.setGender(request.getInstance().getParameter("gender"));
		racer.setBirthDate(request.getInstance().getParameter("birthDate"));
		racer.setPhoneNumber(request.getInstance().getParameter("phoneNumber"));
		
		Address address = new Address(address1, address2, city, state, zipCode);
		
		racer.setAddress(address);
		racer.setPassword(passwordEncoder.encode(password));
    	raceService.createRacer(racer);
    	
        ModelAndView modelAndView = new ModelAndView(racer, "/index.jsp");

        return modelAndView;
    }
}
