package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO-mysql")
public class MYSQLEmployeeDAOImpl implements IEmployeeDAO {

	// mysql query
	private static final String INSERT_EMPLOYEE_QUERY = "INSERT into EMPLOYEE_INFO(ENAME,DESG,SALARY,GROSS_SALARY,NET_SALARY)values(?,?,?,?,?)";

	@Autowired
	private DataSource ds;

	@Override
	public int insert(Employee emp) throws Exception {

		int count = 0;
		try {
			// get the pooled jdbc con object
			Connection con = ds.getConnection();
			// create the PreparedStatement obj having pre-compiled SQL query
			PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE_QUERY);

			// set the value to query params
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getGrossSalary());
			ps.setDouble(5, emp.getNetSalary());

			// execute query
			count = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se; // exception reThorwing
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // exception reThorwing
		}
		return count;
	}

}
