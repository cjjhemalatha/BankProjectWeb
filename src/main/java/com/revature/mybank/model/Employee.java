package com.revature.mybank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Employee_table")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	@Column(name="empname")
	private String empName;
	@Column(name="empPassword")
	private String empPassword;
	@Column(name="empPhnNo")
	private String empPhnNo;
	@Column(name="empMail")
	private String empMail;
	
	public Employee() {
		super();
	}
	public Employee(String empName, String empPassword, String empPhnNo, String empMail) {
		super();
	
		this.empName = empName;
		this.empPassword = empPassword;
		this.empPhnNo = empPhnNo;
		this.empMail = empMail;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpPhnNo() {
		return empPhnNo;
	}
	public void setEmpPhnNo(String empPhnNo) {
		this.empPhnNo = empPhnNo;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPassword=" + empPassword + ", empPhnNo="
				+ empPhnNo + ", empMail=" + empMail + "]";
	}
	
}
