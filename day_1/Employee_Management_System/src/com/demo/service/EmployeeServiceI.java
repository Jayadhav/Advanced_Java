package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeServiceI {

	boolean addEmployee();

	List<Employee> display();

	boolean deleteEmployee(int id);

	boolean updateSalary(int id, Double salary);

	Employee finbById(int id);

	List<Employee> sortBySalary();

	
}
