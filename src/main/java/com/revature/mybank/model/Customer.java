package com.revature.mybank.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cust_id")
	private int id;
	@Column(name="name_col", nullable=false)
	private String name;
	@Column(name="pass",nullable=false)
	private String password;
	@Column(name="genderV")
	private String gender;
	@Column(name="address_col",nullable=false)
	private String address;
	@Column(name= "email_col")
	private String email;
	@Column(name="phnNo_col",nullable=false)
	private String phnNo;
	@Column(name="dob_col",nullable=false)
	private String dob;
	@Column(name="age_col")
	private int age;
	@Column(name="panCard_col", nullable=false)
	private String panCard;
	@Column(name="initial_Balance",nullable=false)
	private int initialBalance;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="customer")
	private List<Transaction>transac=new ArrayList<Transaction>();
	public List<Transaction> getTransac() {
		return transac;
	}
	public void setTransac(List<Transaction> transac) {
		this.transac = transac;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public int getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(int initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnNo() {
		return phnNo;
	}
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", address="
				+ address + ", email=" + email + ", phnNo=" + phnNo + ", dob=" + dob + ", age=" + age + ", panCard="
				+ panCard + ", initialBalance=" + initialBalance + ", transac=" + transac + "]";
	}
	public Customer() {
		super();
	}
	public Customer(int id, String name, String password, String gender, String address, String email, String phnNo,
			String dob, int age, String panCard, int initialBalance, List<Transaction> transac) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phnNo = phnNo;
		this.dob = dob;
		this.age = age;
		this.panCard = panCard;
		this.initialBalance = initialBalance;
		this.transac = transac;
	}
	
	
	
}
