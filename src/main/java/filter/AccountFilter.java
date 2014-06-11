package filter;


import models.Account;
import models.IRaceService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by blakebishop on 6/10/14.
 */
@WebFilter("/*")
public class AccountFilter implements Filter {
    @Inject
    IRaceService raceService;
    
    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ( request instanceof HttpServletRequest) {
            HttpServletRequest req = ((HttpServletRequest)request);
            try {
                // get what we want from the request
                Principal p = req.getUserPrincipal();

                if ( p != null ) {
                    Account account = raceService.getAccountByEmail(p.getName());
                    // store it in the ThreadLocal bean
                    CurrentUser.setUser(account);
                }

                // proceed with the request
                chain.doFilter(request, response);
            } finally {
                // remove user from the ThreadLocal bean so that this
                // thread is ready for the next request
                CurrentUser.setUser(null);
            }
        } else {
            // this almost never happens, but we have it here for completeness
            chain.doFilter(request, response);
        }
    }

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
