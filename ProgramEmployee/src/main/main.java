package main;

import java.nio.file.FileSystemLoopException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcConnection;


import Connection.connection;
import employee.employee;
import repository.employeeRepository;

public class main {
	public  static void  showMenu() {
	System.out.println("=======Welcome to User Management APplication!=======");
	System.out.println("1.View the list of employee ");
	System.out.println("2. Add employee");
	System.out.println("3. delete employee");
	System.out.println("4.Update employee");
	System.out.println("5. Exit");
	System.out.println("Enter choice(1-5): ");
	}
	
	public static void main (String[] args) {
		/*try {
			Connection con = connection.getJDBCConnection();
			Statement statement = con.createStatement();
			String sql = "SELECT * FROM employee";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("employee_ID");
				String name = rs.getString("name");
				System.out.println(id + " " + name);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		int choice = 0;
		int employeeID;
		employee employees;
		employeeRepository empRepo = new employeeRepository();
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();//lõi bộ đệm; Để bắt kí tự emtẻ bị thừa
			//sc.nextInt();
			switch (choice) {
			
			case 1: {
				System.out.println("************List of employeee***********");
				System.out.println("ID\t\tFirstName\tLastName\t\tName\t\tDateOfBirth\t\temail\t\t\tPhone\t\t\tSalary");//"\t" Tạo khoảng cách
				List<employee> employee1 = empRepo.findAll();
				for (employee em : employee1) {
					System.out.println(em);
				}	
				System.out.println("Total employee: " + employee1.size());
				System.out.println("=================**********============");
				break;
				
				
				
			
			}
			case 2: {
				//add employee
				employee emp = new employee();
				emp.input(sc);
				if(empRepo.addEmployee(emp) != 0)
					System.out.println("Add new employee successfully!");
				else
					System.out.println("Cannot add new employee successfully!");
				break;
				
				
			}
			case 3: {
			////Delete employee
				System.out.println("Enter employee id for deleting: ");
				employeeID = sc.nextInt();
				sc.nextLine();
				if(empRepo.deleteEmployee(employeeID) != 0)
					System.out.println("Delete employee successfully!");
				else
					System.out.println("Can not delete employee!!!");
				break;
				
				
			}
			case 4:{
				//update employee
				System.out.println("Enter ID need update");
				employeeID = sc.nextInt();
				sc.nextLine();
				employee emp = empRepo.findById(employeeID);
				if(emp != null) {
					System.out.println("==========Current employee Information=========");
					System.out.println(emp);
					emp.input(sc);
					if(empRepo.updateEmployee(emp) != 0)
						System.out.println("Update employee successfully!");
					else
						System.out.println("Can not update employee!!!");
				}else
					System.out.println("Can not find user id: " + employeeID);
				break;
			}
			case 5: {
				
				System.out.println("Thank you for using my application! Good luck!!!");
				break;
				
			}
			default:
				System.out.println("Please select your choice from 1 to 5. Thank you!");
			}
		} while (choice !=5);
		
	}
}

