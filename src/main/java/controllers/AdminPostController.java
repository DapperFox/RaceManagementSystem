package controllers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import models.Account;
import models.Address;
import models.Admin;
import models.ModelAndView;
import models.RaceService;
import models.Racer;
import models.RequestInjectingServletRequestListener;
import models.Role;
import security.*;

@Stateless
@LocalBean
public class AdminPostController {
	@Inject
    private RaceService raceService;
    @Inject private RequestInjectingServletRequestListener request;
    @Inject PasswordEncoder passwordEncoder;

    public ModelAndView createNewAdmin() {
				    	
        String email = request.getInstance().getParameter("email");
		String password = request.getInstance().getParameter("password");
		
		Account account = new Account();
		account.setEmail(email);
		account.setPassword(passwordEncoder.encode(password));
		account.setRole(Role.ADMIN);
		
		Admin admin = new Admin();
		account.setAdmin(admin);		
		raceService.createAccount(account);
		//Don't pass in the the admin
		//...use the admin to get all their races and pass in that list
		HttpSession session = request.getInstance().getSession();
		session.setAttribute("adminID", admin.getId());
		ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/admindashboard.jsp");

        return modelAndView;
    }

	public ModelAndView adminLogin() {
		//get account id and authenticate it
		HttpSession session = request.getInstance().getSession();
		String id = (String) session.getAttribute("accountID");
		Admin admin = new Admin();
		/*Account acount = 
		if(id == id){
			
		}*/
		
		ModelAndView modelAndView = new ModelAndView(admin, "/WEB-INF/admindashboard.jsp");

        return modelAndView;
	}
}
