package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
	public List<Object[]> showDataByAddrs(String addrs);

	public List<Employee> showEmpAllDataByAddrs(String addrs);

	public List<Employee> showEmpAllDataByAddrsAndName(String addrs, String name);

	public List<Employee> showEmpAllDataBySalaryRange(double start, double salary);

	public List<Employee> showEmpAllDataByAddresses(String addrs1, String addrs2);

	public List<Employee> showEmpAllDataByEnameInitialChars(String initialChars);

	public int showEmpsCountBYSalaryRange(double startSalary, double endSalary);

	public List<Employee> showAllEmpsByEnameSorted();

	public int removeEmpsWithNoEmailIds();

	public Boolean doesEmpsWoringWithoutSalary();
}
