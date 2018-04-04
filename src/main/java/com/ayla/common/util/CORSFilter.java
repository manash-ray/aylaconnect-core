package com.ayla.common.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	public CORSFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpresponse = ((HttpServletResponse) response);
		if (httpresponse.containsHeader("Access-Control-Allow-Origin")) {
			httpresponse.setHeader("Access-Control-Allow-Origin", "*");
		} else {
			httpresponse.addHeader("Access-Control-Allow-Origin", "*");
		}
		if (httpresponse.containsHeader("Access-Control-Allow-Credentials")) {
			httpresponse.setHeader("Access-Control-Allow-Credentials", "true");
		} else {
			httpresponse.addHeader("Access-Control-Allow-Credentials", "true");
		}

		if (httpresponse.containsHeader("Access-Control-Allow-Methods")) {
			httpresponse.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
		} else {
			httpresponse.addHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
		}

		if (httpresponse.containsHeader("Access-Control-Allow-Headers")) {
			httpresponse.setHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Headers,Access-Control-Allow-Methods, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Origin,Accept,Content-Length, X-Requested-With, Content-Type, Authorization, Access-Control-Request-Method, Access-Control-Request-Headers");

		} else {
			httpresponse.addHeader("Access-Control-Allow-Headers",
					"Access-Control-Allow-Headers, Access-Control-Allow-Methods, Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Origin,Accept,Content-Length, X-Requested-With, Content-Type, Authorization, Access-Control-Request-Method, Access-Control-Request-Headers");

		}


		chain.doFilter(request, httpresponse);

	}
}
