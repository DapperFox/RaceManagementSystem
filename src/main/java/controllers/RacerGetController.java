package controllers;

import filter.CurrentUser;
import models.IRaceService;
import models.ModelAndView;
import models.RaceEvent;
import models.Racer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blakebishop on 5/28/14.
 */
public class RacerGetController {

    @Inject
    IRaceService raceService;
    public ModelAndView createNewRacer() {
        Racer racer = null;
        ModelAndView modelAndView = new ModelAndView(racer, "/WEB-INF/register.jsp");

        return modelAndView;
    }

    public ModelAndView loginRacer() {
        return new ModelAndView(null, "/WEB-INF/loginsuccess.jsp");
    }

    public ModelAndView getRaces() {
        Racer racer = CurrentUser.getUser().getRacer();
        racer.getRacerEvents();
        List<RaceEvent> raceList = new ArrayList<>();
        raceList.addAll(racer.getRacerEvents());

        return new ModelAndView(raceList, "/WEB-INF/races.jsp");
    }
}
