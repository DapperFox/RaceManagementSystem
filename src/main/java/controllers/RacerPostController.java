package controllers;


import models.Address;
import models.ModelAndView;
import models.RaceService;
import models.Racer;
import models.RequestInjectingServletRequestListener;

import javax.inject.Inject;

/**
 * Created by blakebishop on 5/28/14.
 */
public class RacerPostController {
    @Inject
    private RaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;

    public ModelAndView createNewRacer() {
		Racer racer = new Racer();
		
		String address1 = request.getInstance().getParameter("address_one");
		String address2 = request.getInstance().getParameter("address_two");
		String city = request.getInstance().getParameter("city");
		String state = request.getInstance().getParameter("state");
		String zipCode = request.getInstance().getParameter("zip");
		
		racer.setFirstName(request.getInstance().getParameter("firstName"));
		racer.setLastName(request.getInstance().getParameter("lastName"));
		racer.setEmail(request.getInstance().getParameter("email"));
		racer.setGender(request.getInstance().getParameter("gender"));
		racer.setBirthDate(request.getInstance().getParameter("birthDate"));
		
		Address address = new Address(address1, address2, city, state, zipCode);
		
		racer.setAddress(address);
		
    	raceService.createRacer(racer);
    	
        ModelAndView modelAndView = new ModelAndView(racer, "/index.jsp");

        return modelAndView;
    }
}
