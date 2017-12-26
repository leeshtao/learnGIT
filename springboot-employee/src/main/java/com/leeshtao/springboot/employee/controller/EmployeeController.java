package com.leeshtao.springboot.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leeshtao.springboot.employee.dao.EmployeeRepository;
import com.leeshtao.springboot.employee.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/queryAll",method = RequestMethod.GET)
    public List<Employee> queryAll(){
        List<Employee> list = new ArrayList<Employee>();
        list = employeeRepository.findAll();
        return list;
    }
    
	@RequestMapping(value="/save/{name}/{gender}/{age}",method = RequestMethod.GET)
	public Employee createEmployee(@PathVariable("name") String name,@PathVariable("gender") String gender,@PathVariable("age") int age){
		Employee employee = new Employee();
		employee.setName(name);
		employee.setGender(gender);
		employee.setAge(age);
		
		return employeeRepository.save(employee);
	}
	
	@RequestMapping(value="/findOne/{id}", method = RequestMethod.GET)  
    public ResponseEntity<Employee> findOne(@PathVariable("id") Long id) throws Exception{  
        Employee employee = employeeRepository.findOne(id);  
        if(employee == null){  
        	throw new RuntimeException("The user doesnot exist!"); 
//            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);  
        }  
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);  
    }  
       
      
    @RequestMapping(value="/update/{id},{age}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id,
    					   @PathVariable("age") int age) throws Exception{
    	Employee employee = employeeRepository.findOne(id); 
        if(employee == null){  
            throw new Exception("The user doesnot exist!");  
        }else {
        	//使用自定义update进行更新
			//employeeRepository.update(age, id);
			//使用save()进行更新
			employee.setAge(age);
			employeeRepository.save(employee);
		}  
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }
    
    @RequestMapping(value="/delete/{id}")  
    public void deleteEmployee(@PathVariable("id") Long id) throws Exception { 
    	Employee employee = employeeRepository.findOne(id); 
        if(employee == null){  
            throw new Exception("The user doesnot exist!"); 
        }
        employeeRepository.deleteLogic(0, id);  
    }  
}












