package com.leeshtao.MyBatis.dao;

import com.leeshtao.MyBatis.entity.Customer;

public interface CustomerDao {

	void insertCustomer(Customer customer); 
	Customer getCustomer(int id); 

}
