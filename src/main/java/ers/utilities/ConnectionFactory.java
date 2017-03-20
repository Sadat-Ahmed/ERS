package ers.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ers.dao.ReimbursementDAO;
import ers.dao.ReimbursementDAOImpl;
import ers.dao.UsersDAO;
import ers.dao.UsersDAOImpl;


public class ConnectionFactory {

	
	private static final String  url = "jdbc:oracle:thin:@localhost:1521:xe";  //where is db located, what driver to use.
	private static final String  user = "RMS";
	private static final String  password = "rms";
	private static Connection connection;

	
	public static Connection getConnection() throws SQLException{
		
		// 1. Load the driver
			// reflection api, looks at its self, its own members.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not register driver!");
			e.printStackTrace();
		}
		// 2. Open a connection
		connection = DriverManager.getConnection(url, user, password);

		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
		
	}
	public static ReimbursementDAO getReimbursementDAO() {
		return new ReimbursementDAOImpl(connection);
	}
	
	public static UsersDAO getUsersDAO() {
		return new UsersDAOImpl(connection);
	}
	
}
