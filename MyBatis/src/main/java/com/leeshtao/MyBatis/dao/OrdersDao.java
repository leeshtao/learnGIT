package com.leeshtao.MyBatis.dao;

import java.util.List;

import com.leeshtao.MyBatis.entity.Orders;

public interface OrdersDao {

	void insertOrders(Orders orders); 
	List<Orders> getOrders(int id);    
	List<Orders> getOrdersById(int customerId); 

}
