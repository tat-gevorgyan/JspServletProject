package com.synergy.training.entities.servlets;

import com.synergy.training.entities.Holder;
import com.synergy.training.entities.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hilda on 10/15/2017.
 */
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			System.out.println("mtav if");
			response.setContentType("text/html");
			response.getWriter().println("one of the inputs is empty try again");
			request.getRequestDispatcher("/loginPage.jsp").include(request, response);
		}
		else {
			System.out.println("mtav else");
			Boolean  isUser = User.findUser(username, password);
			if(isUser) {
				System.out.println("mtav elsi meji if");
				User user = new User(++Holder.userId,username,password);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/ProjectList.jsp");
			}
			else{
				System.out.println("mtav elsi meji else");
				response.setContentType("text/html");
				response.getWriter().println("username or password are incorrect");
				request.getRequestDispatcher("/loginPage.jsp").include(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/loginPage.jsp").forward(request,response);
	}
}
