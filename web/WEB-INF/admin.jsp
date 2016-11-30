<%-- 
    Document   : Admin
    Created on : 28-Nov-2016, 15:30:21
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        .logins {
        float: left;
        margin: 200px;
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
        <h1>XYZ Drivers Association </h1>
        <h1>Admin Page</h1>
        
        <div class ="logins">
        Current Members <br/>
        <%=(String)(request.getAttribute("query"))%> <br />
        
        
        
        Outstanding Balances: <br/>
        <input type=submit value="Check"> <br />
        
        
        
        Check Claims <br />
        <input type=submit value="Check"> <br />
        
        
        
        Member Applications <br />
        <input type=submit value="Check"> <br />
        
        
        
        Individual Claims <br />
        <input type=submit value="Check"> <br />
        
        
        
        Member Applications <br />
        <%=(String)(request.getAttribute("query"))%> <br />
        <input type=submit value="Approve">
        <input type=submit value="Deny"> <br />
       
        
        
        Suspend/Resume Memberships
        <%=(String)(request.getAttribute("query"))%> <br />
        <input type=submit value="Suspend">
        <input type=submit value="Resume"> <br />
        
        
        
        Annual Turnover
        <%=(String)(request.getAttribute("query"))%> <br />
        </div>
        
        
        <jsp:include page="foot.jsp"/>
    </center>
    </body>
</html>
