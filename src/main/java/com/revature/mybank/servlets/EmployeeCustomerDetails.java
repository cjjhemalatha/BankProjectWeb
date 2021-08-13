package com.revature.mybank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.mybank.dboperations.DbConnections;
import com.revature.mybank.model.Customer;

/**
 * Servlet implementation class EmployeeCustomerDetails
 */
public class EmployeeCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCustomerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		DbConnections db=new DbConnections();
		List<Customer> li=db.getCustomer();
		 out.println("<table id=\"customers\">");  
         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");  
         
		for(int i=0;i<li.size();i++) {
			int cust_id=li.get(i).getId();
			String cust_name=li.get(i).getName();
			String cust_contact=li.get(i).getPhnNo();
			String cust_Pan=li.get(i).getPanCard();
			int cust_balance=li.get(i).getInitialBalance();
			
			out.println("<tr><td>" + cust_id + "</td><td>" + cust_name + "</td><td>" + cust_contact + "</td><td>" + cust_Pan + "</td><td>"+ cust_balance+ "</td></tr>"); 
			
		}
		 RequestDispatcher rd=request.getRequestDispatcher("/employeeDashBoard.html");  
         rd.include(request, response); 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				int id= Integer.parseInt(request.getParameter("cust_id"));
				String name= request.getParameter("cust_name");
				DbConnections db= new DbConnections();
				Customer cust= db.custDataToValidate(id);
				PrintWriter out= response.getWriter();
					if(cust!=null && cust.getId()==id && cust.getName()==name) {
						int cust_id=cust.getId();
						String cust_name=cust.getName();
						String contact_no=cust.getPhnNo();
						String pan=cust.getPanCard();
						int cust_balance=cust.getInitialBalance();
						out.println("<table id=\"customers\">");  
				         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");
				         out.println("<tr><td>" + cust_id + "</td><td>" + cust_name + "</td><td>" + contact_no + "</td><td>" + pan + "</td><td>"+ cust_balance+ "</td></tr>"); 
				         RequestDispatcher rd=request.getRequestDispatcher("/employeeDashBoard.html");  
				         rd.include(request, response); 
					
					}
						
						
						
//						out.println("<table id=\"customers\">");  
//				         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");
//				         out.println("<tr><td>" + cust_id + "</td><td>" + cust_name + "</td><td>" + contact_no + "</td><td>" + pan + "</td><td>"+ cust_balance+ "</td></tr>");
//				         RequestDispatcher rd=request.getRequestDispatcher("/employeeDashBoard.html");  
//				         rd.include(request, response);
//					}
					 
					
			}

		

}
	
