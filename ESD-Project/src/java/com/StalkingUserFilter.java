package test;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

public class StalkingUsersFilter implements Filter {

    private FilterConfig fc;
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }
    
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain, String status)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        Jdbc jdbc = new Jdbc();
        jdbc.connect((Connection) request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", jdbc);

        
        
        
        HttpServletRequest httpReq = (HttpServletRequest) request;
        
        String name = httpReq.getRemoteUser();
       
        if(name != null) {
            fc.getServletContext().log("User " + name + " is updating");
        }
        //Can chain this
        chain.doFilter(request,response);
    }
    
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}