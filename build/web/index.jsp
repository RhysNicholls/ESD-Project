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
        <title>login Page</title>
    </head>
    
        
        
        <form action="UserLogin.do" method="post">
            <center>
            <p />
            
            User Sign in <br />
            Username: <input type="text" name="id"><br />
            Password: <input type="text" name="password" ><br />
            <input type ="checkbox" name = "admin"> Sign in as Admin <br />
             <input type=submit value="Login"> <br />
            
            <br />
        </form>
      <form method="POST" action="NewUser.do">     
            Register as new user <br />
            First Name   : <input type="text" name="firstname" ><br />
            Last Name: <input type="text" name="lastname" ><br />
            DOB    : <input type="date" name="dob" ><br />
            Address: <input type="text" name="address" ><br />
            
            <input type=submit value="Register"> <br />
            </center>
        </form> 
    
</html>
