<%-- 
    Document   : driver
    Created on : 01-Nov-2015, 15:18:08
    Author     : me-aydin
--%>

<%@page import="model.Jdbc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Main Page</title>
    </head>
    <body>
        <h2>User's details:</h2>
        <%! int i=0;
            String str="Register"; 
            String url = "NewUser.do";
        %>
        <%
            if((String)request.getAttribute("msg")=="del") {
                str = "Delete";
                url = "Delete.do";
            }
            else {
                str="Register";
                url = "NewUser.do";
            } 
        %>
        
        <%
            if (i++>0 && request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
                i--;
            }
        %>
        </br>
        <jsp:include page="foot.jsp"/>
    </body>
</html>
