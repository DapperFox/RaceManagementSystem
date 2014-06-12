package web;

import controllers.RacerGetController;
import controllers.RacerPostController;
import filter.CurrentUser;
import models.Account;
import models.ModelAndView;
import models.Racer;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    String regexLogin = "/racer/login";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriString = request.getRequestURI();
        ModelAndView modelAndView = null;

        Pattern pattern = Pattern.compile(regexRegister);
        Matcher matcher = pattern.matcher(uriString);

        if(matcher.matches()){
            modelAndView = racerGetController.createNewRacer();
        }
        pattern = Pattern.compile(regexLogin);
        matcher = pattern.matcher(uriString);
        if(matcher.matches()){
            Account account = CurrentUser.getUser();
            HttpSession session = request.getSession();
            Racer racer = account.getRacer();
            racer.setLoggedIn(true);
            session.setAttribute("user", racer);
            modelAndView = racerGetController.loginRacer();
        }
        request.setAttribute("model", modelAndView.getModel());
        RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
        view.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriString = request.getRequestURI();
        ModelAndView modelAndView;

        Pattern pattern = Pattern.compile(regexRegister);
        Matcher matcher = pattern.matcher(uriString);

        if(matcher.matches()){
            modelAndView = racerPostController.createNewRacer();

            request.setAttribute("model", modelAndView.getModel());
            RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
            view.forward(request, response);
        }
    }
}
