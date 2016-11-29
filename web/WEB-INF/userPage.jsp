<%-- 
    Document   : userPage
    Created on : 29-Nov-2016, 12:32:03
    Author     : Jack
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
        <h1>Members page</h1>
        
        
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
        
        
        
        <jsp:include page="foot.jsp"/>
    </body>
</html>
