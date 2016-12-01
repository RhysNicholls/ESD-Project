<%-- 
    Document   : userPage
    Created on : 29-Nov-2016, 12:32:03
    Author     : Rhys, Jack, Mark, Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Members page </title>
        <style>
            .options {
                float: left;
                margin: 200px;
                padding: 15px;
                width: 300px;
                max-height: 800px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8;  
            } 
            .options:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
        <style>
            .options2 {
                float: left;
                margin: 200px;
                padding: 15px;
                width: 400px;
                max-height: 800px;
                border: 1px solid black;
                border-radius: 25px;
                background-color: white; opacity: 0.8; 
            } 
            .options2:hover {
                opacity: 1.0;
                background-color: white;
            }
        </style>
    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue w3-hover-light-blue"> 
            <center>
                <h1>XYZ Drivers Association</h1>
                <h2>Welcome <%=(String) (session.getAttribute("userID"))%> </h2>
                <h3>Members page</h3>
            </center>
        </div>

    <center>

        <div class ="options">
            <form action="User.do" method="POST">
                Outstanding Balance: <br/>
                <%=(String) (request.getAttribute("balance"))%> <br />

                Make Payment: <br />
                <input type="hidden" name="sub_form" val="form_pay"> <br />
                <input type="number" name="payment" step="0.01"> <br />
                <input type=submit name="makePayment" value="Make Payment"> <br />
                All Payments: <br />
                <%=(String) (request.getAttribute("allPayments"))%> <br />


            </form>
        </div>



        <div class ="options2">

            <form action="User.do" method ="POST">
                Submit Claim: <br />
                Amount: <br />
                <input type="text" name ="amount"> <br />
                Rationale: <br />
                <input type="text" name="reason"> <br />
                <input type=submit name="claim" value="Submit Claim"> <br />
                
            </form>


            All Claims: <br />
            <%=(String) (request.getAttribute("allClaims"))%> <br />
        </div>
    </center>

    <jsp:include page="userFoot.jsp"/>
</body>
</html>
