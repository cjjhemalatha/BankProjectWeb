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
 * Servlet implementation class TransferAmount
 */
public class TransferAmount extends HttpServlet {

   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session=request.getSession();
		
		int id=  (int) session.getAttribute("name");
		
		
		DbConnections db= new DbConnections();
		Customer cust= db.custDataToValidate(id);
		int money=Integer.parseInt(request.getParameter("money"));
		
		
		
		

			PrintWriter out= response.getWriter();
			int newBalance=cust.getInitialBalance()-money;
			if(newBalance>5000) {
			
			cust.setInitialBalance(newBalance);
			db.updateInDB(cust);
			out.println("<html>"
					+ "<head><title>Transfer Amount</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your current balance is:"+cust.getInitialBalance()+"</h1>"
					+ "</body>"
					+ "</html>");
			}
			else {
				out.println("<html>"
						+ "<head><title>Error</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Sorry Insufficient balance</h1>"
						+ "</body>"
						+ "</html>");
			}
		
   
				
		}
		
	}
	

