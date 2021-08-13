package com.revature.mybank.mybankproject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mybank.dboperations.DbConnections;
import com.revature.mybank.model.Employee;
import com.revature.mybank.model.Status;

//@JsonIgnoreProperties
//@Path("/employee")
public class EmployeeOperations {
	
//	@Path("/employeeLogin")
//	@POST
//	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
//	@Consumes(MediaType.APPLICATION_JSON)
	
//	public String empLogin(String toValidate) throws JsonMappingException, JsonProcessingException {
//		System.out.println("hello");
//		
//		ObjectMapper obj=new ObjectMapper();
//		Employee emp=obj.readValue(toValidate, Employee.class);
//		int uid=emp.getEmpId();
//		String uemail=emp.getEmpMail();
//		String password=emp.getEmpPassword();
//		System.out.println(uid+" "+uemail+" "+password);
//		Status s=new Status();
//		DbConnections empDb= new DbConnections();
//		Employee empDetails=empDb.getEmpForValidation(uid);
//		System.out.println(empDetails);
//		if(empDetails!=null) {
//			if(empDetails.getEmpMail().equals(uemail) && empDetails.getEmpPassword().equals(password)) {
//				s.setStatusSend("true");
//				System.out.println(s.getStatusSend());
//				return obj.writeValueAsString(s);
//			}
//			else {
//				s.setStatusSend("false");
//				return obj.writeValueAsString(s);
//			}
//			
//		}
//		return null;	
//		
//	}
}
