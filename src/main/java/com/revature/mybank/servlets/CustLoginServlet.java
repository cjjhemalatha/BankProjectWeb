package com.revature.mybank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.mybank.dboperations.DbConnections;
import com.revature.mybank.model.Customer;

/**
 * Servlet implementation class CustLoginServlet
 */
public class CustLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		String name=request.getParameter("name");
		//String ids=request.getParameter("id");
		int id= Integer.parseInt(request.getParameter("id"));
		String password= request.getParameter("password");
		DbConnections db= new DbConnections();
		Customer cust= db.custDataToValidate(id);
		String pan=cust.getPanCard();
		
		if(cust!=null && cust.getId()==id && cust.getName().equals(name) && cust.getPassword().equals(password)) {
			
			HttpSession ses=request.getSession();  
	           ses.setAttribute("name",id);  
	           
	           response.sendRedirect("customerL.html");
		}
		else if(cust!=null && cust.getId()!=id && !(cust.getName().equals(name)) && !(cust.getPassword().equals(password))) {
				PrintWriter out=response.getWriter();
				out.println("<html>"
						+ "<head><title>Error Page</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Login Failed Invalid Credentials </h1>"
						+ "</body>"
						+ "</html>");
		}
		
		
	}

}
