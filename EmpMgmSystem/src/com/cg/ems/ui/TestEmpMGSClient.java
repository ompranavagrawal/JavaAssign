package com.cg.ems.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmpService;
import com.cg.ems.service.EmpServiceImpl;


public class TestEmpMGSClient {

	static EmpService empService=null;
	static Scanner sc;
	public static void main(String[] args) {
		empService=new EmpServiceImpl();
		sc=new Scanner(System.in);
		System.out.println("*************WELCOME TO EMPLOYEE MANAGEMENT SYSTEM**********");
		int choice=0;
		while(true) {
			System.out.println("What do u want to do?");
			System.out.println("\t1:AddEmo\t2:show All Emp\t3:Update Emp\t4:Delete Emp\t\n\t5:Exit");
			System.out.println("Enter ur choice:");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				insertEmp();
				break;
			
			case 2:
				dispAllEmp();
				break;	
				
			case 3:
				updateEmp();
				
				break;
			case 4:
				deleteEmp();
				break;
				
				
			default:
				System.exit(0);
			}
		}

	}
	private static void deleteEmp() {
		
		
	}
	private static void updateEmp() {
		
		
	}
	private static void dispAllEmp() {	
		ArrayList<Employee> empList=null;
		try {
			empList = empService.getAllEmp();
			//System.out.println(empList);
			System.out.println("  \tEMPID  \tEmpName  \tEMPSAL");
			for(Employee ee:empList) {
				System.out.println("\t"+ee.getEmpId()+"\t"+ee.getEmpName()+"\t"+ee.getEmpSal());
			}
		} catch (EmployeeException e) {
			
			e.printStackTrace();
		}
		
		
	}
	private static void insertEmp() {
		
		try {
			System.out.println("Enter UR Emp Id");
			int eId=sc.nextInt();
			System.out.println("Enter your name");
			String enm=sc.next();
			float esl=0;
			if(empService.validateEmpName(enm)) {
				System.out.println("Enter salary");
				esl=sc.nextFloat();
				Employee e1=new Employee(eId,enm,esl);
				int dataInserted=empService.addEmp(e1);
				if(dataInserted==1) {
					dispAllEmp();
				}
				else {
					System.out.println("Sorry data is not inserted");
				}
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
