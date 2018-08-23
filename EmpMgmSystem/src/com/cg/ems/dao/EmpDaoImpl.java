package com.cg.ems.dao;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;

public class EmpDaoImpl implements EmpDao {
	
	Logger daoLogger=null;
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public EmpDaoImpl() {
		
		daoLogger=Logger.getLogger(EmpDaoImpl.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Override
	public ArrayList<Employee> getAllEmp() throws EmployeeException
	{
		ArrayList<Employee> empList=null;
		try 
		{
			empList=new ArrayList<Employee>();
			con=DBUtil.getConn();
			System.out.println("*********CON IN DAO ...."+con);
			String selectqry="Select * from Emp_157889";
			
			st=con.createStatement();
			rs=st.executeQuery(selectqry);
			while(rs.next()) {
				empList.add(new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),
						rs.getFloat("emp_sal")));
				
			}
		} 
		catch (Exception e) 
		{	
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		} 
		finally {
			try {
				st.close();
				rs.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
				throw new EmployeeException(e.getMessage());
			}
		}
		daoLogger.info("All data Retrieved"+empList);
		return empList;
	}
	
	@Override
	public int addEmp(Employee ee)  throws EmployeeException{
		int data=0;
		try {
			con=DBUtil.getConn();
			String insertQry="INSERT INTO Emp_157889 VALUES(?,?,?)";
			pst=con.prepareStatement(insertQry);
			pst.setInt(1,ee.getEmpId());
			pst.setString(2, ee.getEmpName());
			pst.setFloat(3, ee.getEmpSal());
			data=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		} 
		
		return data;
	}
	
	
	
	
	
	
}
