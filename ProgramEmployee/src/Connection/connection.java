package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.main;
public class connection {
	


		public static Connection getJDBCConnection() {
			final String url ="jdbc:mysql://localhost:6634/employee_opps";///
			final String user ="root";//User
			final String password= "0868393278aA";//password
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					return DriverManager.getConnection(url, user, password);//
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		///test connection
		public static void main(String[] args) {
			Connection connection = getJDBCConnection();
			if(connection != null) {
				System.out.println("thanh cong");
			} else {
				System.out.println("that bai");
			}
		}
}