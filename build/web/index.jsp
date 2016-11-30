<%-- 
    Document   : index
    Created on : 09-Mar-2016, 16:52:19
    Author     : me-aydin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .logins {
                float: left;
                margin: 100px;
                padding: 15px;
                max-width: 300px;
                height: 300px;
                border: 1px solid black;
            } 
        </style>
        <style>
            .logins2 {
                float: right;
                margin: 100px;
                padding: 15px;
                max-width: 300px;
                height: 300px;
                border: 1px solid black;
            } 
        </style>
    </head>

    <body>
        <div class ="w3-container w3-blue w3-hover-light-blue">    
            <center>
                <h1>XYS Drivers Association </h1>
                <h1>Homepage</h1>
            </center>
        </div>
        <form action="UserLogin.do" method="post">
            <center>


                <div class ="logins">
                    User Sign in <br />
                    Username: <input type="text" name="id"><br />
                    Password: <input type="text" name="password" ><br />

                    <input type=submit value="Login"> <br />
                </div>           
        </form>

        <form method="POST" action="NewUser.do">     
            <div class = "logins2">
                Register as new user <br />
                First Name   : <br /> <input type="text" name="firstname" ><br />
                Last Name    : <br /> <input type="text" name="lastname" ><br />
                DOB          : <br /> <input type="date" name="dob" ><br />
                Address: <input type="text" name="address" ><br />

                <input type=submit value="Register"> <br />
                </center>
            </div>
        </form> 
    </body>
</html>
