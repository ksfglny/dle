<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>struts2</title>
</head>
<body>
	<s:form action="login">
		<s:textfield name="username" key="user"/>
		<s:textfield name="password" key="pass"/>
		<s:submit key="login"/>
	</s:form>
</body>
</html>