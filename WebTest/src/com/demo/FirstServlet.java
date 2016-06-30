package com.demo;

import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException	
	{
		request.setCharacterEncoding("GBk");
		response.setContentType("text/html;charset=GBK");
		String name=request.getParameter("username");
		String age=request.getParameter("age");
		PrintStream out=new PrintStream(response.getOutputStream());
		out.println(name);
		out.println("<hr>");
		out.print(age);
	}
}
