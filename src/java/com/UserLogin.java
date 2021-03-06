/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Jdbc;

/**
 *
 * @author Rhys
 */
public class UserLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        Jdbc jdbc = new Jdbc();
        jdbc.connect((Connection) request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", jdbc);

        if (jdbc == null) {
            request.getRequestDispatcher("/WEB-INF/conErr.jsp");
        } else {

            String id = request.getParameter("id");
            String password = request.getParameter("password");

            if (jdbc.checkUser(id, password)) {
                if (id.equals("admin") && password.equals("admin")) {

                    session.setAttribute("userID", "admin");
                    request.getRequestDispatcher("/Admin.do").forward(request, response);

                } else {
                    session.setAttribute("userID", id);
                    request.getRequestDispatcher("/User.do").forward(request, response);

                }

            } else {
                JOptionPane.showMessageDialog(null, "You have entered an invalid Username and/or Password, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            }
        }

    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
