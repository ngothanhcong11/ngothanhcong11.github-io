package employee;

import java.util.Scanner;

public class employee {
	private int employeeID,phone,salary;
	public employee() {
		super();
	}
	private String firstName,lastName,name,email,dateofBirth;
	public int getEmployeeID() {
		return employeeID;
	}
	public employee(int employeeID , String firstName, String lastName, String name, String email,
			String dateofBirth,int phone,int salary) {
		super();
		this.phone = phone;
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.email = email;
		this.dateofBirth = dateofBirth;
		this.employeeID = employeeID;
	}
	
	public employee( String firstName, String lastName, String name, String email,String dateofBirth,int phone,int salary) {
		super();
		
		this.phone = phone;
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.email = email;
		this.dateofBirth = dateofBirth;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public void input(Scanner sc) {
		System.out.println("Nhap ID:");
		this.employeeID = sc.nextInt();
		System.out.println("Nhap ho: ");
		//Lỗi bộ đệm khi dùng nextInt : thêm .nextLine() trước khi nhập chuỗi để bắt Enter
		sc.nextLine();
		this.firstName = sc.nextLine();
		System.out.println("Nhap ten lot: ");
		this.lastName = sc.nextLine();
		System.out.println("Nhap ten:");
		this.name = sc.nextLine();
		System.out.println("Nhap email: ");
		this.email  = sc.nextLine();
		System.out.println("Nhap ngay sinh: ");
		this.dateofBirth = sc.nextLine();
		System.out.println("Nhap phone: ");
		this.phone = sc.nextInt();
		System.out.println("Nhap luong");
		this.salary = sc.nextInt();
		
	}
	public String toString() {
		return  this.employeeID + "\t\t" +this.firstName + "\t\t" +this.lastName + "\t\t" +this.name + "\t\t" +this.email + "\t\t" +this.dateofBirth + "\t\t" + this.phone + "\t\t" +this.salary;
	}
	
	
}
