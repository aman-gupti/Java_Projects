package com.excelr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.excelr.bean.Employee;
import com.excelr.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee emp) {
		String sql = "insert into employees values(?,?,?,?)";
		PreparedStatement pst;

		try {
			pst = DBUtil.getConnetion().prepareStatement(sql);

			pst.setInt(1, emp.getId());
			pst.setString(2, emp.getName());
			pst.setString(3, emp.getDepartment());
			pst.setDouble(4, emp.getSalary());

			int count = pst.executeUpdate();

			if (count == 0)
			System.out.println(count + " row(s) were inserted in the table.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
		 public void updateEmployee(Employee emp) {
		 Connection con = DBUtil.getConnetion();
		 String updateSQL = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
		 try {
			PreparedStatement pst = con.prepareStatement(updateSQL);
			 pst.setString(1, emp.getName());
             pst.setString(2, emp.getDepartment());
             pst.setDouble(3, emp.getSalary());
             pst.setInt(4, emp.getId());
             pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		Connection con = DBUtil.getConnetion();
		String deleteSQL = "DELETE FROM employees WHERE id = ?";

            try (PreparedStatement pst = con.prepareStatement(deleteSQL)) {
                pst.setInt(1, id);
                pst.executeUpdate();
            }
         catch (SQLException e) {
            e.printStackTrace();
            }
	}

	@Override
	public List<Employee> getAllEmployee() {
		 
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection con = DBUtil.getConnetion();
		String sql = "select * from employees";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				empList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;	
	}
}
