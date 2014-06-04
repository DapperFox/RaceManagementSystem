package web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ModelAndView;
import controllers.AdminGetController;
import controllers.AdminPostController;
import controllers.RacerGetController;
import controllers.RacerPostController;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
	@Inject
    AdminPostController adminPostController;
    @Inject
    AdminGetController adminGetController;

    String regexRegister = "/admin/register";
    String regexLogin = "/admin/login";
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriString = request.getRequestURI();
        ModelAndView modelAndView = null;

        Pattern pattern = Pattern.compile(regexRegister);
        Matcher matcher = pattern.matcher(uriString);
        
        if(matcher.matches()){
            modelAndView = adminGetController.createNewAdmin();        
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
            modelAndView = adminPostController.createNewAdmin();
            
        }
        
        request.setAttribute("model", modelAndView.getModel());
        RequestDispatcher view = request.getRequestDispatcher(modelAndView.getViewName());
        view.forward(request, response);
        
        
    }
    
    
}
