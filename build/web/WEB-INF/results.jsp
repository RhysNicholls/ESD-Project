<%-- 
    Document   : results
    Created on : 30-Oct-2015, 10:02:53
    Author     : Rhys, Jack, Mark, Ryan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Results</title>

        <style>
            .memberResults {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                padding: 8px;
                text-align: left;
                border: 5px solid black;

            }
            tr:nth-child(even){background-color: #f2f2f2}
            tr:nth-child(odd){background-color: #b7b2b2}


        </style>

    </head>
    <body background = "${pageContext.request.contextPath}/resources/car.jpg">
        <div class ="w3-container w3-blue"> 

            <center>
                <h1>XYZ Drivers Association </h1>

        </div>

    <body>
        <div class ="memberResults"
             <h1><%=(String) (request.getAttribute("title"))%></h1>

            <%=(String) (request.getAttribute("msg"))%>
        </div>
        <jsp:include page="adminFoot.jsp"/>
    </body>
</html>
