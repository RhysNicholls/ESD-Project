<%-- 
    Document   : userPage
    Created on : 29-Nov-2016, 12:32:03
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
        .options {
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
        <div class ="w3-container w3-blue"> 
        <center>
            <h1>XYZ Drivers Association</h1>
            <h1>Members page</h1>
        
        <div class ="options">
        Outstanding Balance: <br/>
        <%=(String)(request.getAttribute("query"))%> <br />
        
        Make Payment: <br />
        <input type="text"> <br />
        <input type=submit value="Check"> <br />
        
        Submit Claim: <br />
        <input type="text"> <br />
        <input type=submit value="Check"> <br />
        
        All Claims: <br />
        <%=(String)(request.getAttribute("query"))%> <br />
        
        All Payments: <br />
        <%=(String)(request.getAttribute("query"))%> <br />
        </div>
        
        
        <jsp:include page="foot.jsp"/>
    </body>
</html>
