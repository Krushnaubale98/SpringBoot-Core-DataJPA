package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {
	@Bean(name = "id")
	public LocalDate createDate() {
		return LocalDate.now();
	}

	public static void main(String[] args) {

		// get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		// get target spring bean class obj
		SeasonFinder finder = ctx.getBean("sf", SeasonFinder.class);
		// invoke the business method
		String SeasonName = finder.findSeson();
		System.out.println("Season name: " + SeasonName);
		// close the IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
