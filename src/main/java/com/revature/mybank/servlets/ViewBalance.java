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
 * Servlet implementation class ViewBalance
 */
public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		
		HttpSession session=request.getSession();
		
		int id=  (int) session.getAttribute("name");
		DbConnections db= new DbConnections();
		Customer cust= db.custDataToValidate(id);
		
		

			PrintWriter out= response.getWriter();
			int newBalance=cust.getInitialBalance();
			
			
			cust.setInitialBalance(newBalance);
			db.updateInDB(cust);
			out.println("<html>"
					+ "<head><title>Check balance</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your current balance is:"+cust.getInitialBalance()+"</h1>"
					+ "</body>"
					+ "</html>");   
			
			
		      
				
		}
	
	}


