<%-- 
    Document   : results
    Created on : 30-Oct-2015, 10:02:53
    Author     : Rhys, Jack, Mark, Ryan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Results</title>
    </head>
    <body>
        <h1><%=(String)(request.getAttribute("title"))%></h1>

        <%=(String)(request.getAttribute("msg"))%>
        <jsp:include page="adminFoot.jsp"/>
    </body>
</html>
