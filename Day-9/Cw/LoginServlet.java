package com.coforge.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username.equals("admin") && password.equals("123")) {
			//out.println("<b><font color = 'green'>Welcome Admin</font></b>");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			Cookie cookie = new Cookie("username",username);
			response.addCookie(cookie);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("LoginSuccess.jsp");
		}
		else {
			//out.println("<b><font color = 'red'>Invalid username or password</font></b>");
			response.sendRedirect("LoginFailure.jsp");
		}
	}

}
