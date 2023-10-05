package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.PatientInfo;

@SpringBootApplication
public class BootProject05DataInjectionUsingValueAnnotationSpelApplication {

	public static void main(String[] args) {
		// get the IOC container
		ApplicationContext ctx = SpringApplication
				.run(BootProject05DataInjectionUsingValueAnnotationSpelApplication.class, args);

		// get the PatientInfo Spring bean class object

		PatientInfo info = ctx.getBean("pInfo", PatientInfo.class);
		System.out.println(info);

		// close the ioc container
		((ConfigurableApplicationContext) ctx).close();

	}

}
