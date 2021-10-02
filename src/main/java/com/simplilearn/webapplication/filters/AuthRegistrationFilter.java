package com.simplilearn.webapplication.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns="/registerauth")
public class AuthRegistrationFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("---FILTER INITIALIZED----");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request params
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		String userPassword = request.getParameter("userpassword");
		String cnfPassword = request.getParameter("cnfuserpassword");

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.print("<html><body>");
		if(userName.equals("")&&userEmail.equals("")&& userPassword.equals("")) {
			out.println("<h1 style='color:red'>Registration Failed * Required fields are missing! </h1>");
		}else {
			if(userPassword.equalsIgnoreCase(cnfPassword)) {
				chain.doFilter(request, response);
				out.println("Succesfully Registered!!!");
				}else {
				out.println("<h1 style='color:red'>Registration Failed * Miss Match wrong! </h1>");

			}
		}
		
	}
  
	public void destroy() {
		System.out.println("---FILTER DESTROYED---");
	}
	
	

}
