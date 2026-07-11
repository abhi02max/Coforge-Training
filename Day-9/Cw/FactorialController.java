package com.coforge.servlet1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FactorialController
 */
@WebServlet("/FactorialController")
public class FactorialController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("FactorialOutput.jsp");
		request.setAttribute("n", n);
		request.setAttribute("fact", fact);
		dispatcher.forward(request, response);
		//response.sendRedirect("FactorialOutput.jsp?n="+n+"&fact="+fact);
	}

}
