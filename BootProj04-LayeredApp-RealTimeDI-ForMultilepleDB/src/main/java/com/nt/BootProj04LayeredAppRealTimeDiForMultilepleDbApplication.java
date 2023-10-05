package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj04LayeredAppRealTimeDiForMultilepleDbApplication {

	public static void main(String[] args) {

		// read inputs from the enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the employee name: ");
		String name = sc.next();
		System.out.println("Enter the employee desg: ");
		String desg = sc.next();
		System.out.println("Enter the Employee basicSalary: ");
		double basicSalary = sc.nextDouble();

		// create the Employee class object
		Employee emp = new Employee();
		emp.setDesg(desg);
		emp.setEname(name);
		emp.setSalary(basicSalary);

		/// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj04LayeredAppRealTimeDiForMultilepleDbApplication.class,
				args);
		// get Controller class object
		PayrollOperationsController controller = ctx.getBean("payrollController", PayrollOperationsController.class);

		try {
			String result = controller.processEmployee(emp);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("internal problem--try again " + e.getMessage());
		}
		// close the ioc container
		((ConfigurableApplicationContext) ctx).close();

	}

}
