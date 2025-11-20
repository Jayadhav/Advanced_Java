package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDaoI {

	boolean save(Employee emp);

	List<Employee> displayAll();

	boolean removeEmployee(int id);

	boolean updateSalary(int id, Double salary);

	Employee findById(int id);

	List<Employee> sortBySalary();

	
}
