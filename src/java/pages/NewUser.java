/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.sql.Connection;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Jdbc;
import org.apache.commons.lang3.RandomStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author me-aydin
 */
public class NewUser extends HttpServlet {

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

        Random rn = new Random();

        String[] query = new String[5];
        String firstname = (String) request.getParameter("firstname");
        String lastname = (String) request.getParameter("lastname");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");

        Jdbc jdbc = new Jdbc();
        jdbc.connect((Connection) request.getServletContext().getAttribute("connection"));
        session.setAttribute("dbbean", jdbc);

        if (jdbc == null) {

            JOptionPane.showMessageDialog(null, "Names can't have numbers in, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } else if (firstname.matches(".*\\d+.*") || lastname.matches(".*\\d+.*") || (lastname.isEmpty() || firstname.isEmpty())) {

            JOptionPane.showMessageDialog(null, "You have entered an invalid Firstname and Lastname, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have entered an invalid Address, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } else if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have entered an invalid date of birth, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } else {

          
            
            query[0] = firstname.substring(0, 1).toLowerCase() + "-" + lastname.toLowerCase();
            query[1] = (String) request.getParameter("firstname") + " " + (String) request.getParameter("lastname");
            query[2] = (String) request.getParameter("address");
            query[3] = (String) request.getParameter("dob");
            //query[4] = RandomStringUtils.randomAlphabetic(10).toLowerCase();
            query[4] = dob.replaceAll("\\D+", "");
            

            
            jdbc.insertNewUser(query);
            request.setAttribute("username", query[0]);
            request.setAttribute("password", query[4]);
            session.setAttribute("userID", query[0]);
            session.setAttribute("Login", "yes");

            request.getRequestDispatcher("/WEB-INF/regSuccess.jsp").forward(request, response);
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
