package com.revature.mybank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.mybank.dboperations.DbConnections;
import com.revature.mybank.model.Customer;
import com.revature.mybank.model.Employee;

/**
 * Servlet implementation class EmployeeLoginS
 */
public class EmployeeLoginS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name=request.getParameter("empName");
		int id= Integer.parseInt(request.getParameter("empID"));
		String password= request.getParameter("empPassword");
		DbConnections db= new DbConnections();
		Employee emp= db.getEmpForValidation(id);
		String ename=emp.getEmpName();
		
		if(emp!=null && emp.getEmpId() ==id && emp.getEmpName().equals(name) && emp.getEmpPassword().equals(password)) {
			HttpSession ses=request.getSession();  
	          ses.setAttribute("name",ename);  
			response.sendRedirect("employeeDashBoard.html");
		}
		else if(emp.getEmpId()!=id && !(emp.getEmpName().equals(name)) && !(emp.getEmpPassword().equals(password))) {
				PrintWriter out=response.getWriter();
				out.println("<h3>Bad Credentials</h3>"); 
				RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
		         rd.include(request, response);
		}
		else {
			PrintWriter out=response.getWriter();
			out.print("<h2 style=text-align:center;color:red>Wrong user id or Password</h2>");  
	           RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	           rd.include(request, response);
		}
		
	
	}

}
