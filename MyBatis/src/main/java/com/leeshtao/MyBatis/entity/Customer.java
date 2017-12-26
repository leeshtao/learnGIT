package com.leeshtao.MyBatis.entity;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

	private static final long serialVersionUID = 451949797460417653L; 
	  private int id; 
	  private String address; 
	  private String postcode; 
	  private String sex; 
	  private String cname; 
	  private List<Orders> orders;  
	  
	  public int getId() { 
	    return id; 
	  } 
	  public void setId(int id) { 
	    this.id = id; 
	  } 
	  public String getAddress() { 
	    return address; 
	  } 
	  public void setAddress(String address) { 
	    this.address = address; 
	  } 
	  public String getPostcode() { 
	    return postcode; 
	  } 
	  public void setPostcode(String postcode) { 
	    this.postcode = postcode; 
	  } 
	  public String getSex() { 
	    return sex; 
	  } 
	  public void setSex(String sex) { 
	    this.sex = sex; 
	  } 
	  public String getCname() { 
	    return cname; 
	  } 
	  public void setCname(String cname) { 
	    this.cname = cname; 
	  } 
	  public List<Orders> getOrders() { 
	    return orders; 
	  } 
	  public void setOrders(List<Orders> orders) { 
	    this.orders = orders; 
	  } 

}
