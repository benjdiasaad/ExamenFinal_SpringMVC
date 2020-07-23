package com.humains.filter;

import com.humains.entities.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/MonFilter")
public class filter implements Filter {

    private static final Logger logger = Logger.getLogger(filter.class.getName());
    private FilterConfig filterConfig ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req1 = (HttpServletRequest) request;
        HttpServletResponse res1 = (HttpServletResponse) response;

        //Recuperer la session de user connecter
        Employee sessionUser = (Employee) req1.getSession().getAttribute("ConnectedUser");
        String currentPath = req1.getRequestURL().toString();
        String webOrigen = req1.getServletPath();
        System.out.println("URL that is Mapped by Filter is: "+currentPath);
        //resp.sendRedirect(req.getContextPath() + "/");
        if (sessionUser != null) {
            if (currentPath.contains("/login")) {

                res1.sendRedirect(req1.getContextPath() + "/article/");
            } else if (currentPath.contains("/register"))  {

                res1.sendRedirect(req1.getContextPath() + "/article/");
            } else {
                chain.doFilter(request, response);
                logger.info("Filter works like a charm !\n");
            }
        } else {
            if (currentPath.contains("article") || currentPath.contains("user") || currentPath.contains("tag")  || webOrigen.startsWith("/*")) {
                res1.sendRedirect(req1.getContextPath() + "/");
                logger.info("Filter redirected you!");
            } else {
                chain.doFilter(request, response);
            }
        }

    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
