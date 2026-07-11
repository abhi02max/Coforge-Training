package com.coforge.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PasswordStrengthServlet
 */
@WebServlet("/PasswordStrengthServlet")
public class PasswordStrengthServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String password = "";
		password = request.getParameter("pwd");
		
		if(password!=null && password.length()<3) {
			out.println("<font color = 'red'><b>WEAK</b></font>");
		}
		if(password!=null && password.length()>3 && password.length()<6) {
			out.println("<font color = 'orange'><b>GOOD</b></font>");
		}
		if(password!=null && password.length()>6) {
			out.println("<font color = 'green'><b>STRONG</b></font>");
		}
		out.close();
	}
}
