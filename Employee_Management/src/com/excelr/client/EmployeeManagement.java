package com.excelr.client;

import java.util.List;
import java.util.Scanner;

import com.excelr.bean.Employee;
import com.excelr.dao.EmployeeDAO;
import com.excelr.dao.EmployeeDAOImpl;

public class EmployeeManagement {
	public static void main(String[] args) {
		 EmployeeDAO empDao = new EmployeeDAOImpl();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nEmployee Management System");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Update Employee");
	            System.out.println("3. Delete Employee");
	            System.out.println("4. Display All Employees");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                    addEmployee(empDao, sc);
	                    break;
	                case 2:
	                    updateEmployee(empDao, sc);
	                    break;
	                case 3:
	                    deleteEmployee(empDao, sc);
	                    break;
	                case 4:
	                    displayAllEmployees(empDao, sc);
	                    break;
	                case 5:
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void addEmployee(EmployeeDAO empDao, Scanner sc) {
	        
	        Employee employee = new Employee();
	        System.out.print("Enter Employee ID: ");
	        employee.setId(sc.nextInt());
	        sc.nextLine(); 
	        System.out.print("Enter Employee Name: ");
	        employee.setName(sc.nextLine());
	        System.out.print("Enter Employee Department: ");
	        employee.setDepartment(sc.nextLine());
	        System.out.print("Enter Employee Salary: ");
	        employee.setSalary(sc.nextDouble());
	        sc.nextLine(); 

	       
	        empDao.addEmployee(employee);
	        System.out.println("Employee added successfully.");
	    }

	    private static void updateEmployee(EmployeeDAO empDao, Scanner sc) {
	        System.out.print("Enter Employee ID to update: ");
	        int id = sc.nextInt();
	        sc.nextLine(); 

	        Employee employee = new Employee();
	        employee.setId(id);

	        
	        System.out.print("Enter new Employee Name: ");
	        employee.setName(sc.nextLine());
	        System.out.print("Enter new Employee Department: ");
	        employee.setDepartment(sc.nextLine());
	        System.out.print("Enter new Employee Salary: ");
	        employee.setSalary(sc.nextDouble());
	        sc.nextLine(); 

	   
	        empDao.updateEmployee(employee);
	        System.out.println("Employee updated successfully.");
	    }

	    private static void deleteEmployee(EmployeeDAO empDao, Scanner sc) {
	        System.out.print("Enter Employee ID to delete: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	       
	        empDao.deleteEmployee(id);
	        System.out.println("Employee deleted successfully.");
	    }

	    private static void displayAllEmployees(EmployeeDAO empDao, Scanner sc) {
	        List<Employee> emp = empDao.getAllEmployee();
	        if (emp.isEmpty()) {
	            System.out.println("No employees found.");
	        } else {
	            for (Employee employee : emp) {
	                System.out.println("Employee ID: " + employee.getId());
	                System.out.println("Name: " + employee.getName());
	                System.out.println("Department: " + employee.getDepartment());
	                System.out.println("Salary: " + employee.getSalary());
	                System.out.println("------------------------");
	            }
	        }
	}

}
