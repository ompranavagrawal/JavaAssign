package com.cg.ems.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmpDao;
import com.cg.ems.dao.EmpDaoImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmpServiceImpl implements EmpService {
	
	EmpDaoImpl empDao=null;
	public EmpServiceImpl() {
		empDao=new EmpDaoImpl();
	}
	@Override
	public ArrayList<Employee> getAllEmp() throws EmployeeException{
		return empDao.getAllEmp();
	}
	@Override
	public int addEmp(Employee ee) throws EmployeeException{
		return empDao.addEmp(ee);
	}
	@Override
	public boolean validateEmpName(String eName) throws EmployeeException {
		
		String namePattern="[A-Z][a-z]+";
		if(Pattern.matches(namePattern, eName)) {
			return true;
		}
		else {
			throw new EmployeeException("Invalid Empl Name.Should start with capitals "
					+ "only Character allowed");
		}
		
	}
	
	

}
