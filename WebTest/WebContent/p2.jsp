<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for(int i=0;i<10;i++){
		out.println("value"+i);
	}

	%>
	
	<%--
	<jsp:forward page="p3.jsp">
		<jsp:param value="11" name="age"/>
	</jsp:forward> 
	
	<jsp:include page="p3.jsp">
		<jsp:param value="11" name="age"/>
	</jsp:include> 
	
	--%>
	哈哈哈哈哈

	
	<form action="login.action">
	
	请输入用户名：<input	type="text" name="username"/>
	<input type=submit value="submit"/>	
	</form>
	
	</body>
</html>