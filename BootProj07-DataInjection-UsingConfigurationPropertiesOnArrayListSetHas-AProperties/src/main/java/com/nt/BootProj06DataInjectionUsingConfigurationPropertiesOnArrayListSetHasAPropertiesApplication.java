package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.Employee;

@SpringBootApplication
public class BootProj06DataInjectionUsingConfigurationPropertiesOnArrayListSetHasAPropertiesApplication {

	public static void main(String[] args) {
		// get the IOC container

		ApplicationContext ctx = SpringApplication.run(
				BootProj06DataInjectionUsingConfigurationPropertiesOnArrayListSetHasAPropertiesApplication.class, args);
		// get the Employee class object
		Employee emp = ctx.getBean("emp", Employee.class);
		System.out.println(emp);

		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();

	}

}
