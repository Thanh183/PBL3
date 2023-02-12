package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
	public static Connection getConnection() {
		Connection connect = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/pbl3_database";
			String username = "root";
			String password = "1832003";
			 	
			connect  = DriverManager.getConnection(url,username,password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connect;
	}

	public static void closeConnection(Connection connect) {
		try {
			if( connect != null) connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//tomcat tai windown->pre->server->runtime enviroment->>de chay server
//them thu vien server runtime vao library (build path->library->add library->tomcat
//them thu vien de ket noi jdbc

