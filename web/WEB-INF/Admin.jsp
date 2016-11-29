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
        
        
        
        <jsp:include page="foot.jsp"/>
    </center>
    </body>
</html>
