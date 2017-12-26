package com.leeshtao.springboot.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.leeshtao.springboot.employee.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	@Query(value = "select * from employee where is_valid=1 ", nativeQuery = true)  
	@Transactional
	List<Employee> findAll();
	
	@Query(value = "select * from employee where is_valid=1 and id=?1", nativeQuery = true)  
	@Transactional
	Employee findOne(Long id);
	
	
	/**
	 * 自定义update格式
	 * 增,删操作,要使用"@Modifying"
	 * @param gender
	 * @param id
	 */
	@Query(value = "update Employee set age=?1 where id=?2 ", nativeQuery = true)  
	@Modifying  
	@Transactional
	void update(int age, Long id);
	
	@Query(value = "update Employee set is_valid=?1 where id=?2 ", nativeQuery = true)  
	@Modifying  
	@Transactional
	void deleteLogic(int isvalid, Long id);
	
}
