package com.cg.ems.exception;


public class EmployeeException extends Exception{
	
	String msg;
	static Error code;
    public EmployeeException(String msg) {
    	super(msg);
	} 
    public EmployeeException(String msg,Throwable cause,Error code) {
    	super(msg,cause);
    	this.code=code;
    }
		

}
