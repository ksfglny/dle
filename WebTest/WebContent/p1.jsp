<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>p1</title>
</head>
<body>
<%@include file="haha.html" %>
	<%="hello"+"world" %>
	<br>
	
	<p>getservletinfo</p>
	<%=getServletInfo() %>
	<br>
	
			
	
	<%out.print(new Date()); %>>
	<p>this is error page</p>
	<%@include file="error.jsp" %>
	<%@include file="p2.jsp" %>
</body>
</html>