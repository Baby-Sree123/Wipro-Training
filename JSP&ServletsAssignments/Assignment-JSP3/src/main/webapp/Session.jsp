<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    String name = request.getParameter("username");
    String password = request.getParameter("password");
    
    session.setAttribute("username", name);
    session.setAttribute("userpassword", password);
   
%>
<h1> Session stored.. </h1>
<a href="Second_session.jsp"> Click Here</a>
</body>
</html>