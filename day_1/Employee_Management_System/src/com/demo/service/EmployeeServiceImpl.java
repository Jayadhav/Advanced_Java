package com.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDaoI;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeServiceI
{

	private EmployeeDaoI edao;
	
	public EmployeeServiceImpl()
	{
		this.edao = new EmployeeDaoImpl();
	}

	@Override
	public boolean addEmployee() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id. ");
		int eid = sc.nextInt();
		sc.nextLine();
		
		System.out.println("ENter Employee Name");
		String ename = sc.nextLine();
		
		sc.nextLine();
		System.out.println("Enter Employee Job");
		String job=sc.nextLine();
		
		System.out.println("Enter Employee Salary.. ");
		Double salary=sc.nextDouble();
		
		sc.nextLine();
		System.out.println("enter date of joining..(dd/MM/yyyy)");
		String jdt=sc.nextLine();
		LocalDate ldt = LocalDate.parse(jdt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Date sqldate = Date.valueOf(ldt);
		
		
		Employee emp = new Employee(eid,ename,job,salary,sqldate);
		return edao.save(emp);
		
		
		
		
		
		
		
	}

	@Override
	public List<Employee> display()
	{
		
		return edao.displayAll();
	}

	@Override
	public boolean deleteEmployee(int id) {
		
		return edao.removeEmployee(id);
	}



	@Override
	public boolean updateSalary(int id, Double salary) {
		
		return edao.updateSalary(id,salary);
	}

	@Override
	public Employee finbById(int id)
	{
		
		return edao.findById(id);
	}

	@Override
	public List<Employee> sortBySalary()
	{
		
		return edao.sortBySalary();
	}


	
	
	
	
	
	
}


