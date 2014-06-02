package web;

import controllers.RacerGetController;
import controllers.RacerPostController;
import models.ModelAndView;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by blakebishop on 5/28/14.
 */

@WebServlet("/racer/*")
public class RacerServlet extends HttpServlet {
    @Inject
    RacerPostController racerPostController;
    @Inject
    RacerGetController racerGetController;

    String regexRegister = "/racer/register";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriString = request.getRequestURI();
        ModelAndView modelAndView = null;

        Pattern pattern = Pattern.compile(regexRegister);
        Matcher matcher = pattern.matcher(uriString);

        if(matcher.matches()){
            modelAndView = racerGetController.createNewRacer();
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
            modelAndView = racerPostController.createNewRacer();
            //todo fix this so it persists the user information
            request.setAttribute("model", modelAndView.getModel());
            RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
            view.forward(request, response);
        }
    }
}
