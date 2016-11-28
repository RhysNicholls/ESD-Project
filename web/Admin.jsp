<%-- 
    Document   : Admin
    Created on : 28-Nov-2016, 15:30:21
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
        <h1>Admin Page</h1>
        
        Current Members
        <%=(String)(request.getAttribute("query"))%>
        
        
        
        
        
        
        
        <jsp:include page="foot.jsp"/>
    </center>
    </body>
</html>
