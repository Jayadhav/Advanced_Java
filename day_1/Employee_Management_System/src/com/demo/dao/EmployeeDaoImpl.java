package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDaoI
{
	private static Connection con;
	
	static PreparedStatement insertEmp, displayAll,removeEmployee,updateSalary,findById,sortBySalary;
	
	static 
	{
		con= DBUtil.getMyConnection();
		
		try 
		{
			insertEmp = con.prepareStatement("insert into employee values (?,?,?,?,?)");
			displayAll= con.prepareStatement("select * from employee");
			removeEmployee=con.prepareStatement("delete from employee where eid =?");
			updateSalary=con.prepareStatement("update employee set salary=? where eid=?");
			findById=con.prepareStatement("select * from employee where eid=? ");
			sortBySalary=con.prepareStatement("select* from employee order by salary");
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public boolean save(Employee emp) 
	{
		try 
		{
			insertEmp.setInt(1, emp.getEid());
			insertEmp.setString(2, emp.getEname());
			insertEmp.setString(3, emp.getJob());
			insertEmp.setDouble(4, emp.getSalary());
			insertEmp.setDate(5, emp.getJdt());
			int n = insertEmp.executeUpdate();
			return n>0;
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public List<Employee> displayAll()
	{
		List<Employee> elist= new ArrayList<>();
		try 
		{
			ResultSet rs = displayAll.executeQuery();
			while (rs.next() )
			{
				elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5) )   );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(elist.size()>0)
		{
			return elist;
		}
		else
		{
			return null;
		}
		
		
	}




	@Override
	public boolean removeEmployee(int id)
	{
		try {
			removeEmployee.setInt(1,id);
			
			int n = removeEmployee.executeUpdate();
			if(n>0)
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}




	@Override
	public boolean updateSalary(int id, Double salary) 
	{
		try {
			updateSalary.setDouble(1,salary);
			updateSalary.setInt(2,id);
			
			int n = updateSalary.executeUpdate();
			if(n>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}




	@Override
	public Employee findById(int id)
	{
		Employee emp=null;
		
		try 
		{
			ResultSet rs = findById.executeQuery();
			
			if(rs.next())
			{
				emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5));
			}
			
			
			
		} catch (SQLException e) {


			e.printStackTrace();
		}
		
		
		
		return emp;
	}




	@Override
	public List<Employee> sortBySalary() 
	{
		List<Employee>elist= new ArrayList<>();
		
		try 
		{
			ResultSet rs = sortBySalary.executeQuery();
			while(rs.next())
			{
				elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDate(5)));
			}
			
			
		} 
		catch (SQLException e)
		{
		
			e.printStackTrace();
		}
		
		if(elist.size() > 0) 
		{
			return elist;
		}
		else
		{
			return null;
		}
	}
	


}
