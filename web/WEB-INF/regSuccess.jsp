<%-- 
    Document   : regSuccess
    Created on : 29-Nov-2016, 12:48:48
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>

        <div class="container">
            <h1> Registration Successful </h1>
            <p><b>Your generated username is:  </b></p>
            <% out.println(request.getAttribute("username")); %>
            <br>
            <p><b>Your generated password is:</b></p>
            <% out.println(request.getAttribute("password"));%>
            <br>
            <p><b>Please write them down somewhere safe </b></p>
            <% out.println(session.getAttribute("userID"));%>
            <br>
            <br>
            <form action="index.jsp">
                <input type="submit" value="Go Back to Login Page" />
            </form>
        </div>
    </body>
</html>
