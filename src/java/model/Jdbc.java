/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark, Rhys, Jack, Ryan
 */
public class Jdbc {

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    LocalDate ls = LocalDate.now();
    LocalDateTime lst = LocalDateTime.now();
    //String query = null;

    public Jdbc(String query) {
        //this.query = query;
    }

    public Jdbc() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void connect(Connection con) {
        connection = con;
    }

    public ArrayList rsToList() throws SQLException {
        ArrayList aList = new ArrayList();

        int cols = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            String[] s = new String[cols];
            for (int i = 1; i <= cols; i++) {
                s[i - 1] = rs.getString(i);
            }
            aList.add(s);
        } // while    
        return aList;
    } //rsToList

    private String makeTable(ArrayList list) {
        StringBuilder b = new StringBuilder();
        String[] row;
        b.append("<table>");
        for (Object s : list) {
            b.append("<tr>");
            row = (String[]) s;
            for (String row1 : row) {
                b.append("<td>");
                b.append(row1);
                b.append("</td>");
            }
            b.append("</tr>\n");
        } // for
        b.append("</table>");
        return b.toString();
    }//makeHtmlTable

    public void select(String query) {
        //Statement statement = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //statement.close();
        } catch (SQLException e) {
            System.out.println("way way" + e);
            //results = e.toString();
        }
    }

    public String retrieve(String query) throws SQLException {
        String results = "";
        select(query);
//        try {
//            
//            if (rs==null)
//                System.out.println("rs is null");
//            else
//                results = makeTable(rsToList());
//        } catch (SQLException ex) {
//            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return makeTable(rsToList());//results;
    }

    public void updateMemberStatus(String[] str) throws SQLException, ClassNotFoundException {

        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            ps = connection.prepareStatement("update members set status=? where id=?");
            ps.setString(1, str[1]);
            ps.setString(2, str[0]);

            ps.executeUpdate();

            ps2 = connection.prepareStatement("update users set status=? where id=?");
            ps2.setString(1, str[1]);
            ps2.setString(2, str[0]);

            ps2.executeUpdate();

            ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean exists(String user) {
        boolean bool = false;
        try {
            select("select username from users where username='" + user + "'");
            if (rs.next()) {
                System.out.println("TRUE");
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }

    public void insertNewClaim(String[] str) {

        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement("INSERT INTO claims (mem_id, date, rationale, status, amount) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[0]);
            ps.setDate(2, java.sql.Date.valueOf(ls));
            ps.setString(3, str[1]);
            ps.setString(4, "SUBMITED");
            ps.setFloat(5, Float.valueOf(str[2]));
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertNewPayment(String[] str) {

        PreparedStatement ps = null;

        long time = System.currentTimeMillis();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
        Date date = new Date(timestamp.getTime());
        System.out.println(date);
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);

        float amount = Float.parseFloat(str[2]);

        try {

            ps = connection.prepareStatement("INSERT INTO payments (mem_id, type_of_payment, amount, date) VALUES (?,?,?,?)");
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setFloat(3, amount);
            ps.setDate(4, date);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertNewUser(String[] str) {

        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {

            ps = connection.prepareStatement("INSERT INTO members(id, name, address, dob, dor, status, balance) VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setString(3, str[2]);
            ps.setDate(4, java.sql.Date.valueOf(str[3]));
            ps.setDate(5, java.sql.Date.valueOf(ls));
            ps.setString(6, "APPLIED");
            ps.setFloat(7, (float) 10.0);
            ps.executeUpdate();

            ps.close();

            ps2 = connection.prepareStatement("INSERT INTO users(id, password, status) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps2.setString(1, str[0]);
            ps2.setString(2, str[4]);
            ps2.setString(3, "APPLIED");
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean checkUser(String id, String password) {
        boolean st = false;
        try {

            PreparedStatement ps3 = connection.prepareStatement("select * from users where id=? and password=?");
            ps3.setString(1, id);
            ps3.setString(2, password);
            ResultSet rs = ps3.executeQuery();
            st = rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    public void update(String[] str, String table) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("Update users Set password=? where username=?", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, str[1].trim());
            ps.setString(2, str[0].trim());
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String user) {

        String query = "DELETE FROM Users "
                + "WHERE username = '" + user.trim() + "'";

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("way way" + e);
            //results = e.toString();
        }
    }

    public void closeAll() {
        try {
            rs.close();
            statement.close();
            //connection.close();                                         
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
