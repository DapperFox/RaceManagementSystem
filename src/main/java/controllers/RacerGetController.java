package controllers;

import models.ModelAndView;
import models.Racer;

/**
 * Created by blakebishop on 5/28/14.
 */
public class RacerGetController {


    public ModelAndView createNewRacer() {
        Racer racer = null;
        ModelAndView modelAndView = new ModelAndView(racer, "/WEB-INF/register.jsp");

        return modelAndView;
    }

    public ModelAndView loginRacer() {
        return new ModelAndView(null, "/WEB-INF/loginsuccess.jsp");
    }
}
