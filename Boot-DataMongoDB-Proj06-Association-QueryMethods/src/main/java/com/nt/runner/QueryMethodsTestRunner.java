package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		/*service.showDataByAddrs("pune").forEach(row -> {
			for (Object val : row) {
				System.out.print(val + " ");
			}
		});*/

		System.out.println("--------------------Entity Queries---------------------------");
		service.showEmpAllDataByAddrs("pune").forEach(System.out::println);

		System.out.println("===========Emp by name and addrs===================================");
		service.showEmpAllDataByAddrsAndName("pune", "komal").forEach(System.out::println);

		System.out.println("============Emp by salary range==============");
		service.showEmpAllDataBySalaryRange(0, 50000).forEach(System.out::println);

		System.out.println("=========Emp by address =================");
		service.showEmpAllDataByAddresses("pune", "hyd").forEach(System.out::println);

		System.out.println("=======Emp by Ename initialChars================");
		service.showEmpAllDataByEnameInitialChars("r").forEach(System.out::println);

		System.out.println("=============Emp count by salary range============");
		System.out.println("Emps count having salary in range(10k to 100k) ::"
				+ service.showEmpsCountBYSalaryRange(10000, 100000));

		System.out.println("=========Emp by ename and sorted============");
		service.showAllEmpsByEnameSorted().forEach(System.out::println);

		System.out.println("===========Remove emp by NoEmailId=========");
		System.out.println(service.removeEmpsWithNoEmailIds() + " docs are deleted becoz of no email id");

		System.out.println("=========emp is exist by salary===========");
		System.out.println("emp is available: " + service.doesEmpsWoringWithoutSalary());
	}

}
