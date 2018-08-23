import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestCalculatorDemo {

	public static void main(String[] args) {
		Logger myLogger=Logger.getLogger(TestCalculatorDemo.class);
		PropertyConfigurator.configure("log4j.properties");
		Scanner sc=new Scanner(System.in);
		myLogger.debug("this is debug message");
		myLogger.warn("this is warn message");
		myLogger.fatal("this is fatal message");
		System.out.println("Enter a:");
		int a=sc.nextInt();
		myLogger.info("user entered a:"+a);
		System.out.println("Enter b:");
		int b=sc.nextInt();
		myLogger.info("user entered b:"+b);
		int c=0;
		try {
			c=a/b;
			myLogger.info("c ="+c);
			System.out.println("Division is "+c);
		}
		catch(ArithmeticException ae) {
			ae.printStackTrace();
			myLogger.error("divisor is 0"+ae.getMessage());
		}
	}

}
