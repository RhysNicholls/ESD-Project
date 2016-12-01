<%-- 
    Document   : Admin
    Created on : 28-Nov-2016, 15:30:21
    Author     : Rhys, Jack, Mark, Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <style>
            .admin {
                float: top;
                align-content: center;
                margin: 25px;
                padding: 15px;
                max-width: 300px;
                height: 575px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;  
            } 
            .admin:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue w3-hover-light-blue"> 

            <center>
                <h1>XYZ Drivers Association </h1>
                <h1>Admin Page</h1>

        </div>
        <div class ="admin">
            <center>
                <form action="Admin.do" method="post">

                    Current Members 
                    <input type=submit name="members" value="List all members"> <br />
                    <br/>

                    Outstanding Balances: <br/>
                    <input type=submit name="outstanding" value="List all outstanding balances"> <br /> <br />

                    Check Claims <br />
                    <input type=submit name="checkClaims" value="List all claims"> <br />
                    <br />

                    Member Applications <br />
                    <input type=submit name="applications" value="List all applications"> <br /> 
                    <br />

                    Individual Claims <br />
                    <input type=submit name="processClaims" value="Process individual claims"> <br />
                    <br />

                    Member Applications <br />
                    <input type ="text" name="memberApplicationText">
                    <input type ="submit" name="memberApplicationButton" value ="Approve"> <br />    
                    
                    
                    <br />

                    Suspend/Resume Memberships
                    <input type=text name="suspendOrRemove">
                    <input type=submit name="suspendButton" value ="Suspend">
                    <input type=submit name="resumeButton" value ="Resume"> <br />
                    <br />
                    
                    Annual Turnover
                    <%=(String) (request.getAttribute("query"))%> 
                    <br />
                    </div>

            </center>

                    </form>

            <jsp:include page="userFoot.jsp"/>
        </center>
</body>
</html>
