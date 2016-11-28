<%-- 
    Document   : index
    Created on : 09-Mar-2016, 16:52:19
    Author     : me-aydin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Homepage</h1>
    </center>
        <form action="First" method="post">
            <center>
            <p />
            
            User Sign in <br />
            Username: <input type="text" name="username"><br />
            Password: <input type="text" name="password" ><br />
            <input type ="checkbox" name = "admin"> Sign in as Admin <br />
             <input type=submit value="Enter"> <br />
            
            <br />
            <br />
            
            Register as new user <br />
            Name   : <input type="text" name="name" ><br />
            DOB    : <input type="date" name="dob" ><br />
            Address: <input type="text" name="address" ><br />
            
            <input type=submit value="Register"> <br />
            </center>
        </form>
        
       
    </body>
</html>

