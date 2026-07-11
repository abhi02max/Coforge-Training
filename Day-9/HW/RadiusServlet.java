package com.coforge.servlet1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RadiusServlet
 */
@WebServlet("/RadiusServlet")
public class RadiusServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int radius = Integer.parseInt(request.getParameter("radius"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("AreaServlet");
		request.setAttribute("radius", radius);
		dispatcher.forward(request, response);
	}

}
