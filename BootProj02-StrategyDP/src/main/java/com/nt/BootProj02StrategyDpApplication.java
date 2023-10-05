package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj02StrategyDpApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj02StrategyDpApplication.class, args);
		// get the target spring bean class object
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);
		// invoke the business method
		vehicle.move("pune", "mumbai");

		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
