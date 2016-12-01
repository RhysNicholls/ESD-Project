    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import static java.awt.SystemColor.window;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class User extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);

        response.setContentType("text/html;charset=UTF-8");

        Jdbc dbBean = new Jdbc();
        dbBean.connect((Connection) request.getServletContext().getAttribute("connection"));

        
            try {
                String balance = dbBean.retrieve("select balance from members where id='" + session.getAttribute("userID") + "'");
                request.setAttribute("balance", balance);

                String allPayments = dbBean.retrieve("select * from payments where mem_id='" + session.getAttribute("userID") + "'");
                if (allPayments != null) {
                    request.setAttribute("allPayments", allPayments);
                } else {
                    request.setAttribute("allPayments", "No payments made yet");
                }

                String allClaims = dbBean.retrieve("select * from claims where mem_id='" + session.getAttribute("userID") + "'");
                if (allClaims != null) {
                    request.setAttribute("allClaims", allClaims);
                } else {
                    request.setAttribute("allClaims", "No claims made yet");
                }

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (request.getParameter("makePayment") != null) {
        
            String[] query = new String[3];

            query[0] = (String)session.getAttribute("userID");
            query[1] = "FEE";
            query[2] = (String) request.getParameter("payment");
            
            if(query[2].isEmpty()) {
                JOptionPane.showMessageDialog(null, "You have entered an invalid payment, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
            } else {
                dbBean.insertNewPayment(query);
                request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
                
            }
            
        
            
            }
         
         if (request.getParameter("claim") != null) {
            
            String[] query = new String[3];

            query[0] = (String) session.getAttribute("userID");
            query[1] = (String) request.getParameter("reason");
            query[2] = (String) request.getParameter("amount");
            
            if(query[1].isEmpty()) {
                JOptionPane.showMessageDialog(null, "You have entered an invalid reason, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
            } else if(query[2].isEmpty() || query[2].matches(".*[a-z].*")) {
                JOptionPane.showMessageDialog(null, "You have entered an invalid amount, please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
            } else {
                dbBean.insertNewClaim(query);
            }
            
            
        }
         
         
         
            request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
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
