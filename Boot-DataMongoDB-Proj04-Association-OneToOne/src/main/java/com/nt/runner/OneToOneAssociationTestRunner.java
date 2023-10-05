package com.nt.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRTOMgmtService;

@Component
public class OneToOneAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IRTOMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		// parent to child operation
		try {

			Person per = new Person();

			// set data by setter method
			per.setPid(new Random().nextInt(100));
			per.setPname("saja");
			per.setPaddrs("pune");

			DrivingLicense license = new DrivingLicense();

			license.setLicenseNo(new Random().nextLong(1000000000000000L));
			license.setType("LMV");
			license.setExpiryTime(LocalDate.of(2044, 10, 12));

			// perform association child to parent
			per.setLicenseDetails(license);
			// use service
			// System.out.println(service.registerPersonWithDrivingLicense(per));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------------------------");

		// child to parent
		try {

			// parent object
			Person per = new Person(new Random().nextInt(1000), "raju", "nashik");
			// child object
			DrivingLicense license = new DrivingLicense(new Random().nextLong(), "2-wheeler", LocalDate.now());

			// perform association parent to child
			license.setPersonDetails(per);

			// System.out.println(service.registerLicenseWithPerson(license));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------parent to child FindAll()-------------------");
		service.fetchAllPersonDetails().forEach(per -> {
			System.out.println("parent:: " + per);

			DrivingLicense license = per.getLicenseDetails();
			System.out.println("Child::" + license);
		});

		System.out.println("------------child to parent-------------");
		service.fetchAllLicenseDetails().forEach(license -> {
			System.out.println(license);

			Person per = license.getPersonDetails();
			System.out.println(per);
		});
	}

}
