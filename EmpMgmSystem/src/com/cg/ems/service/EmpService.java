package com.cg.ems.service;


import java.util.ArrayList;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmpService {
	public ArrayList<Employee> getAllEmp() throws EmployeeException;
	
	public int addEmp(Employee ee)  throws EmployeeException;
	
	public boolean validateEmpName(String eName) throws EmployeeException;
	
	
}
