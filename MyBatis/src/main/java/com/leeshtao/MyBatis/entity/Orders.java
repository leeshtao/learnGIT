package com.leeshtao.MyBatis.entity;

import java.io.Serializable;

public class Orders implements Serializable{

	private static final long serialVersionUID = 8215977396669780567L; 
	  private int id; 
	  private String code; 
	  private int customerId; 
	  private Customer customer; 
	    
	  public int getId() { 
	    return id; 
	  } 

	  public void setId(int id) { 
	    this.id = id; 
	  } 

	  public String getCode() { 
	    return code; 
	  } 

	  public void setCode(String code) { 
	    this.code = code; 
	  } 

	  public int getCustomerId() { 
	    return customerId; 
	  } 

	  public void setCustomerId(int customerId) { 
	    this.customerId = customerId; 
	  } 

	  public Customer getCustomer() { 
	    return customer; 
	  } 

	  public void setCustomer(Customer customer) { 
	    this.customer = customer; 
	  } 

}
