package com.leeshtao.MyBatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.leeshtao.MyBatis.dao.CustomerDao;
import com.leeshtao.MyBatis.dao.OrdersDao;
import com.leeshtao.MyBatis.entity.Customer;
import com.leeshtao.MyBatis.entity.Orders;
import com.leeshtao.MyBatis.util.MyBatisUtil;

public class OrdersMapperTest {

	  private SqlSessionFactory sqlSessionFactory=null; 
	  private SqlSession session=null; 
	    
	  @Before 
	  public void before(){ 
	    sqlSessionFactory=MyBatisUtil.getInstance(); 
	    session=sqlSessionFactory.openSession(); 
	  } 
	    
	  @Test 
	  public void testInsertOrders(){ 
	    Orders orders=new Orders(); 
	    orders.setCode("code__1"); 
	    orders.setCustomerId(1); 
	     
	    OrdersDao ordersMapper=session.getMapper(OrdersDao.class); 
	    ordersMapper.insertOrders(orders); 
	    session.commit();     
	  } 
	    
	  @Test 
	  public void testInsertCustomerOneToMany(){ 
		  Customer customer=new Customer();
		  customer.setCname("Lixing5");
		  customer.setPostcode("518105");
		  customer.setSex("男");
		  customer.setAddress("广东省深圳市5");
	     
		  CustomerDao customerMapper=session.getMapper(CustomerDao.class); 
		  customerMapper.insertCustomer(customer); 
		  System.out.println(customer.getId()); 
	     
		  Orders orders1=new Orders(); 
		  orders1.setCode("code__5_1"); 
		  orders1.setCustomerId(customer.getId()); 
	     
		  Orders orders2=new Orders(); 
		  orders2.setCode("code__5_2"); 
		  orders2.setCustomerId(customer.getId()); 
	     
		  Orders orders3=new Orders(); 
		  orders3.setCode("code__5_3"); 
		  orders3.setCustomerId(customer.getId()); 
	     
		  OrdersDao ordersMapper=session.getMapper(OrdersDao.class); 
		  ordersMapper.insertOrders(orders1); 
		  ordersMapper.insertOrders(orders2); 
		  ordersMapper.insertOrders(orders3); 
	     
		  session.commit();    
	  } 
	    
	     
	  @Test 
	  public void testGetOrdersManyToOne(){ 
	    OrdersDao ordersMapper=session.getMapper(OrdersDao.class); 
	    List<Orders> list=ordersMapper.getOrdersById(1); 
	    for(int i=0;i<list.size();i++){ 
	      Orders orders=list.get(i); 
	      Customer customer=orders.getCustomer(); 
	      System.out.println(orders.getId()+"\t"+orders.getCode()+"\t"+orders.getCustomerId()); 
	      System.out.println("\t \t--:"+customer.getId()+"\t"+customer.getCname()); 
	    }     
	    session.commit(); 
	  } 
	    
	    
	  @Test 
	  public void testGetCustomerOneToMany(){ 
	    CustomerDao customerMapper=session.getMapper(CustomerDao.class); 
	    Customer customer=customerMapper.getCustomer(1); 
	    List<Orders> orders=customer.getOrders(); 
	    System.out.println(customer.getId()+"\t"+customer.getCname()+"\t"+customer.getPostcode()+"\t"+customer.getAddress()); 
	    for(int i=0;i<orders.size();i++){ 
	      Orders order=orders.get(i); 
	      System.out.println("\t \t --:"+order.getId()+"\t"+order.getCode()+"\t"+order.getCustomerId()); 
	    } 
	    session.commit(); 
	  } 
	    
	  @After 
	  public void after(){ 
	    session.close(); 
	  } 

}
