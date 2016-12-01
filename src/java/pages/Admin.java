/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;

/**
 *
 * @author Rhys
 */
public class Admin extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        Jdbc dbBean = new Jdbc();
        String user = null;
        dbBean.connect((Connection) request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", dbBean);

        String msg;

        if (request.getParameter("members") != null) {

            try {

                msg = dbBean.retrieve("select * from members");
                request.setAttribute("msg", msg);

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("title", "List of all current members");
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);

        }
        if (request.getParameter("applications") != null) {

            try {

                msg = dbBean.retrieve("select id, name from members where status ='APPLIED'");
                request.setAttribute("msg", msg);

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("title", "List of all current applications");
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }

        if (request.getParameter("outstanding") != null) {

            try {

                msg = dbBean.retrieve("select mem_id, amount from payments where amount>='0'");
                request.setAttribute("msg", msg);

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("title", "List of all current members with outstanding balences");
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }

        if (request.getParameter("checkClaims") != null) {

            try {

                msg = dbBean.retrieve("select * from claims");
                request.setAttribute("msg", msg);

            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("title", "List of current claims");
            request.getRequestDispatcher("/WEB-INF/results.jsp").forward(request, response);
        }

        if (request.getParameter("memberApplicationButton") != null) {
            String[] hey = new String[2];
            hey[0] = (String) request.getParameter("memberApplicationText");
            hey[1] = "APPROVED";
            
                
            try {   
                dbBean.updateMemberStatus(hey);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
                
         
        }
        
        if (request.getParameter("suspendButton") != null) {
            String[] hey = new String[2];
            hey[0] = (String) request.getParameter("suspendOrRemove");
            hey[1] = "SUSPENDED";
            
                
            try {   
                dbBean.updateMemberStatus(hey);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
                
         
        }
        
        if (request.getParameter("resumeButton") != null) {
            String[] hey = new String[2];
            hey[0] = (String) request.getParameter("suspendOrRemove");
            hey[1] = "APPROVED";
            
                
            try {   
                dbBean.updateMemberStatus(hey);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
                
         
        }
        request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
