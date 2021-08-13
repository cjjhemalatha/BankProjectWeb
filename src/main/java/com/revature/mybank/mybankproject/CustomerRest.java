package com.revature.mybank.mybankproject;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mybank.dboperations.DbConnections;
import com.revature.mybank.model.Customer;
import com.revature.mybank.model.CustomerValidation;
import com.sun.istack.logging.Logger;


@Path("/customer")
public class CustomerRest  {
	private static final Logger log=Logger.getLogger(CustomerRest.class);
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/newcustomer")	
	@POST
	public String customerAdd(@FormParam("name") String name, @FormParam("email") String email, @FormParam("phn-no") String phnNo, @FormParam("pancard") String pancard, @FormParam("address") String address, @FormParam("initialBalance") int iniBalance,@FormParam("dob") String dob, @FormParam("age") int age, @FormParam("Gender") String gender, @FormParam("password") String password ) {
		System.out.println("heloooo");
		Customer cust=new Customer();
		
		cust.setName(name);
		cust.setEmail(email);
		cust.setPhnNo(phnNo);
		cust.setPanCard(pancard);
		cust.setAddress(address);
		cust.setInitialBalance(iniBalance);
		cust.setDob(dob);
		cust.setAge(age);
		cust.setPassword(password);
		cust.setGender(gender);
		DbConnections db=new DbConnections();
		db.addToCustTable(cust);
		
		log.info(" Customer added to db");
		return "added successfully";
	}
	
	
	
	
//	@Path("/custLogin")
//	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
//	@Consumes(MediaType.APPLICATION_JSON)
//	
//	@POST
//	public String customerLogin(String toValidate) throws JsonMappingException, JsonProcessingException {
//		 ObjectMapper obj=new ObjectMapper();
//		 System.out.println(toValidate);
//		 CustomerValidation cv=obj.readValue(toValidate, CustomerValidation.class);
//		 
//		Customer cust= db.custDataToValidate(cv.getCustId());
//		if(cust!=null && cust.getId()==cv.getCustId() && cust.getName().equals(cv.getCustName()) && cust.getName().equals(cv.getCustName())) {
//			return "True";
//		}
//		else if(cust!=null && cust.getId()!=cv.getCustId() && !(cust.getName().equals(cv.getCustName())) && !(cust.getName().equals(cv.getCustName()))) {
//				return "False";
//		}
//		return "False";
//	}
//	

}
