package com.synergy.training.entities.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Hilda on 10/15/2017.
 */
public class LoginFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);
		String loginURI = request.getContextPath() + "/LoginServlet";

		boolean isLoggedIn = session != null && session.getAttribute("user") !=null;
		boolean isInLoginPage = request.getRequestURI().equals(loginURI);

		if(isLoggedIn || isInLoginPage) {
			chain.doFilter(request, response);
		}
		else {
			System.out.println("request.getRequestURI(): " + request.getRequestURI());
			response.sendRedirect(loginURI);
		}
	}

	public void init(FilterConfig config)
			throws ServletException {

	}

}
