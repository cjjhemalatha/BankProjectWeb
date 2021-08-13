package com.revature.mybank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TransactionDetails_table")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="custId")
	private int id;
	
	@Column (name="transac_details",nullable=false)
	private String transactionDetail;
	
	@Column (name="transac_date",nullable=false)
	private String transac_date;
	
	@Column (name="transac_time",nullable=false)
	private String transac_time;
	
	@ManyToOne
	 @JoinColumn(name = "cust_id")
	private Customer customer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactionDetail() {
		return transactionDetail;
	}
	public void setTransactionDetail(String transactionDetail) {
		this.transactionDetail = transactionDetail;
	}
	
}
