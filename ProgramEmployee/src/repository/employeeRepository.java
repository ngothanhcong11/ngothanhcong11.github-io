package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import Connection.connection;
import employee.employee;



public class employeeRepository {
 public List<employee> findAll(){
	 List<employee> employees = new ArrayList<employee>();
	 Connection con = connection.getJDBCConnection();
	 String sql = "SELECT * FROM employee";
	 if(con==null) {
		 System.out.println("Can't not connection mySQL");
	 }else {
		 try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				employees.add(new employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
				//con.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		 
	 }
	 return employees;
 }
 ////Add employee
 public int addEmployee(employee emp) {
	 String sql = "insert into employee(employee_ID,first_name,last_name,name,date_of_birth,email,phone,salary) values(?,?,?,?,?,?,?,?)";
	 int result = 0;
	 Connection con = connection.getJDBCConnection();
	try {
		PreparedStatement psta = con.prepareStatement(sql);
		psta.setInt(1, emp.getEmployeeID());
		psta.setString(2, emp.getFirstName());
		 psta.setString(3, emp.getLastName());
		 psta.setString(4, emp.getName());
		 psta.setString(5, emp.getDateofBirth());
		 psta.setString(6, emp.getEmail());
		 psta.setInt(7, emp.getPhone());
		 psta.setInt(8, emp.getSalary());
		 
		 result = psta.executeUpdate();
		 psta.close();
		 con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return result;
 }
 
//Delete employeee
 public int deleteEmployee(int employeeID) {
	 String sql = "delete from employee where employee_ID = ? ";
	 int result = 0;
	 Connection con = connection.getJDBCConnection();
	 try {
		PreparedStatement psta = con.prepareStatement(sql);
		psta.setInt(1, employeeID);
		result = psta.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
			 
	 return result ;
 }
 public int updateEmployee(employee emp ) {
	 int result = 0;
	 String sql = "update employee set first_name=?,last_name=?,name=?,date_of_birth=?,email =?,phone =?,salary =? where employee_ID=?";
	 Connection con = connection.getJDBCConnection();
	 try {
		PreparedStatement psta = con.prepareStatement(sql);
		
		psta.setString(1, emp.getFirstName());
		psta.setString(2, emp.getLastName());
		psta.setString(3, emp.getName());
		psta.setString(4, emp.getDateofBirth());
		psta.setString(5, emp.getEmail());
		psta.setInt(6, emp.getPhone());
		psta.setInt(7, emp.getSalary());
		psta.setInt(8, emp.getEmployeeID());
		result = psta.executeUpdate();
		psta.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return result;
 }
 public employee findById(int employeeID){
		employee emp = null;
		Connection con = connection.getJDBCConnection();
		if (con == null) {
			System.out.println("Cannot connect to the MySQL Database Server!");
		} else {
			try {
				Statement stmt = con.createStatement();
				String sql = "select  * from   employee where employee_ID = ? ";
				PreparedStatement psta = con.prepareStatement(sql);
				psta.setInt(1, employeeID);
				ResultSet rs = psta.executeQuery();
				if(rs.next())
					emp = new employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
				rs.close();
				psta.close();
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return emp;
	}
}
