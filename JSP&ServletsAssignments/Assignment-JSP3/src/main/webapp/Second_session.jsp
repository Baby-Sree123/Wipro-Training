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
String name = (String) session.getAttribute("username");
String password = (String) session.getAttribute("userpassword");
%>

<h2>Session Data:</h2>
    <p>Name: <%= name %></p>
    <p>Password: <%= password %></p>
</body>
</html>