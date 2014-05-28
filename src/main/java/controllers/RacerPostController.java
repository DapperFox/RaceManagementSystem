package controllers;

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
        //todo Greg fill in all of the post info from his jsp
        Racer racer = null;
        ModelAndView modelAndView = new ModelAndView(racer, "/");

        return modelAndView;
    }
}
