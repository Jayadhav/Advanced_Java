package com.demo.beans;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Employee 
{
	private int eid;
	private String ename;
	private String job;
	private double salary;
	private Date jdt;
	
	
	public Employee() {
		super();
	}


	public Employee(int eid, String ename, String job, double salary, Date jdt) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.job = job;
		this.salary = salary;
		this.jdt = jdt;
	}


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Date getJdt() {
		return jdt;
	}


	public void setJdt(Date jdt) {
		this.jdt = jdt;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", job=" + job + ", salary=" + salary + ", jdt=" + jdt
				+ "]";
	}
	
	
	
	
	

}
