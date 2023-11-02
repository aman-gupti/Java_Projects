package com.excelr.dao;

import java.util.List;

import com.excelr.bean.Employee;

public interface EmployeeDAO {
	
	void addEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(int id);
	List<Employee> getAllEmployee();
}
