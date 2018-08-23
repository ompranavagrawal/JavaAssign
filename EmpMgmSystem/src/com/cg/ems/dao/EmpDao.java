package com.cg.ems.dao;

import java.util.ArrayList;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmpDao {
	public ArrayList<Employee> getAllEmp() throws EmployeeException;
	
	public int addEmp(Employee ee)  throws EmployeeException;
	
}
