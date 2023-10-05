package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, Integer> {

	// ======================Projection Query=================

	// @Query(fields = "{eno:0,eadd:1,salary:1}", value = "{}eadd:?0")
	@Query(fields = "{ename:1,eadd:1,salary:1}", value = "{eadd:?0}")
	public List<Object[]> getEmplyeeDataByAddrs(String addrs);

	// =======================Entity Queries=====================
	// @Query(value="{eadd:?0}", fields = "{}")
	@Query(value = "{eadd:?0}") // where eadd=?
	public List<Employee> getEmpAllDataByAddrs(String addrs);

	@Query(value = "{eadd:?0,ename:?1}")
	public List<Employee> getEmpAllDataByAddrsAndName(String addrs, String name);

	// @Query(value="{salary:{$gte:?0,$lte:?1}}")
	@Query(value = "{salary:{$gte:?0},salary:{$lte:?1}}") // where salary>=? and salary<=?
	public List<Employee> getEmpAllDataBySalaryRange(double start, double end);

	@Query(value = "{$or:[{eadd:?0},{eadd:?1}]}") // where eadd=? or eadd=?
	public List<Employee> getEmpAllDataByAddresses(String addrs1, String addrs2);

	// @Query(value = "{ename:{'$regex':?0,'$options':'i'}}") // 'i' for
	// case-insensivity is applied
	@Query(value = "{ename:{'$regex':?0}}") // where ename like(%_% is applided and this case sensitive
	public List<Employee> getEmpAllDataByEnameInitialChars(String initialChars);

	@Query(value = "{salary:{$gte:?0,$lte:?1}}", count = true)
	public int getEmpsCountBySalaryRange(double startSalary, double endSalary);

	@Query(value = "{}", sort = "{ename:1}")
	public List<Employee> getAllEmpsByEnameSorted();

	@Query(value = "{email:null}", delete = true)
	public int removeEmpsWithNoEmailIds();

	@Query(value = "{salary:null}", exists = true)
	public Boolean doesEmpsAreWorkingWithOutSalary();
}
