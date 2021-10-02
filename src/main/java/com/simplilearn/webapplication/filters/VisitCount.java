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


@WebFilter(filterName="auth2", urlPatterns="/auth")
public class VisitCount implements Filter {

   static int count;
    public VisitCount() {}
    
	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		
		++count;
		out.print("<h1>Total Visit Count: "+count+"</h1>");
		out.print("</body></html>");
		chain.doFilter(request, response);
		out.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
