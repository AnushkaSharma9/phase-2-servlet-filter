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

@WebFilter(filterName="auth1", urlPatterns="/auth")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("---FILTER INITIALIZED----");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//request params
		String userEmail = request.getParameter("useremail");
		String userPassword = request.getParameter("userpassword");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.print("<html><body>");
		if(userEmail.equals("")&& userPassword.equals("")) {
			out.println("<h1 style='color:red'>Login Failed * Required fields are missing! </h1>");
		}else {
			if(userEmail.equals("admin@gmail.com") && userPassword.equals("admin@123")) {
				//next pass to servlet program
				chain.doFilter(request, response);
				}else {
				out.println("<h1 style='color:red'>Login Failed * Invalid Credentials </h1>");			
			}
		}
		//out.print("</body></html>");
	}


	@Override
	public void destroy() {
		System.out.println("---FILTER DESTROYED---");
	}

	

}
