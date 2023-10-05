package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Hotel;

@SpringBootApplication
public class BootProject05DataInjectionUsingValueAnnotationSpel2Application {

	public static void main(String[] args) {

		// get the ioc container
		ApplicationContext ctx = SpringApplication
				.run(BootProject05DataInjectionUsingValueAnnotationSpel2Application.class, args);

		// get the hotel class object reference

		Hotel hotel = ctx.getBean("hotel", Hotel.class);
		System.out.println(hotel);

		// close the ioc container
		((ConfigurableApplicationContext) ctx).close();
	}

}
