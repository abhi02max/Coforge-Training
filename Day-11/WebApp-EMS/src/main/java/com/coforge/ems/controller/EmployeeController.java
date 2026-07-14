package com.coforge.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int eid = Integer.parseInt(request.getParameter("eid"));
		PrintWriter out = response.getWriter();
		String result = "";
		try {
			Employee employee = service.showEmployee(eid);
			result  = employee.getEname() + " " + employee.getEsalary() + " " + employee.getDno();
			out.println(result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidEmployeeObjectException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("emsButton");
		// common name different value depends on value choose action
		int eid = 0;
		String ename = "";
		int esalary = 0;
		int dno = 0;
		Employee employee = null;
		String result = "";
		// int n = 0;

		switch (action) {

		case "Insert":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary = Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			employee = new Employee(eid, ename, esalary, dno);
			try {
				int n = service.createEmployee(employee);
				if (n == 1) {
					result = ApplicationProperties.insertSuccess;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.DBfail;
			} catch (SQLException e) {
				result = ApplicationProperties.DBfail;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.DBfail;
			}
			
			//response.sendRedirect("index.jsp?result=" + result);
			
			break;
		case "Delete":
			eid = Integer.parseInt(request.getParameter("eid"));
			try {
				int n = service.deleteEmployee(eid);
				if(n == 1) {
					result = ApplicationProperties.deleteSuccess;
				}
				
				if(n == 0) {
					result = ApplicationProperties.notFound;
				}
			} 
			catch (ClassNotFoundException e) {
				result = ApplicationProperties.DBfail;
			}
			catch(SQLException e) {
				result = ApplicationProperties.DBfail;
			}
			catch(InvalidEmployeeObjectException e) {
				result = ApplicationProperties.DBfail;
			}
			
			//response.sendRedirect("index.jsp?result=" + result);
			
			break;
		case "Update":
				eid = Integer.parseInt(request.getParameter("eid"));
				ename = request.getParameter("ename");
				esalary = Integer.parseInt(request.getParameter("esalary"));
				dno = Integer.parseInt(request.getParameter("dno"));
				employee = new Employee(eid, ename, esalary, dno);
			try {
				int n = service.updateEmployee(employee);
				
				if(n == 1) {
					result = ApplicationProperties.updateSuccess;
				}
				if(n == 0) {
					result = ApplicationProperties.notFound;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.DBfail;
				
			} catch (SQLException e) {
				result = ApplicationProperties.DBfail;
				
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.DBfail;
				
			}
			
			//response.sendRedirect("index.jsp?result=" + result);
			
			break;
		case "Find":
				eid = Integer.parseInt(request.getParameter("eid"));
			try {
				employee = service.showEmployee(eid);
				if (employee != null) {
				result = service.showEmployee(eid).toString();
				}
				else {
					result = ApplicationProperties.notFound;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.DBfail;
			} catch (SQLException e) {
				result = ApplicationProperties.DBfail;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.DBfail;
			}
			
			//String encodedResult = java.net.URLEncoder.encode(result, java.nio.charset.StandardCharsets.UTF_8);
		    //response.sendRedirect("index.jsp?result=" + encodedResult);
			break;
		case "FindAll":
			try {
				result = service.showAllEmployees().toString();
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.DBfail;
			} catch (SQLException e) {
				result = ApplicationProperties.DBfail;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.DBfail;
			}
			//response.sendRedirect("index.jsp?result=" + result);
			break;

		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("index.jsp").forward(request, response);
}

}
