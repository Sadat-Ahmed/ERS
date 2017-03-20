package ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import ers.utilities.*;

import ers.model.ErsReimbursement;
import ers.model.ErsUserRoles;
import ers.model.ErsUsers;

public class UsersDAOImpl implements UsersDAO {

	Connection connection = null; // Our connection to the database
	PreparedStatement stmt = null;

	

	public UsersDAOImpl(Connection connection2) {
		this.connection = connection;
	}

	@Override
	public ErsUsers getManager(int id) {
		ErsUsers user = new ErsUsers();
		try {
			try {
				connection = ConnectionFactory.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "SELECT ERS_USERS_ID, ERS_USERAME FROM RMS.ERS_USERS WHERE USER_ROLE_ID = 2";
			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) { // 1.points to next row, 2. returns true of
								// false if
				// there is a row.
				// object - relational mapping

				user.setErsUserId(rs.getInt("ERS_USERS_ID"));
				user.setErsUsername(rs.getString("ERS_USERNAME"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeResources();
		}

		return user;
	}

	@Override
	public ErsUsers getEmployee(int id) {
		ErsUsers user = new ErsUsers();
		try {
			try {
				connection = ConnectionFactory.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "SELECT ERS_USERS_ID, ERS_USERAME FROM RMS.ERS_USERS WHERE USER_ROLE_ID = 1";
			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) { // 1.points to next row, 2. returns true of
								// false if
				// there is a row.
				// object - relational mapping

				user.setErsUserId(rs.getInt("ERS_USERS_ID"));
				user.setErsUsername(rs.getString("ERS_USERNAME"));

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeResources();
		}

		return user;
	}
	
	@Override
	public ErsUsers getUserbyUsername(String username) throws Exception {

		String sql = "SELECT * FROM ERS_USERS LEFT JOIN ERS_USER_ROLES"
				+ " ON ERS_USERS.USER_ROLE_ID=ERS_USER_ROLES.ERS_USER_ROLE_ID WHERE ERS_USERNAME = ?";
		
		connection = ConnectionFactory.getConnection();

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		ErsUsers u = new ErsUsers();
		while (rs.next()) {
			u.setErsUsername(rs.getString("ERS_USERNAME"));
			u.setErsUserId(rs.getInt("ERS_USER_ID"));
			u.setUserEmail(rs.getString("USER_EMAIL"));
			u.setUserFirstName(rs.getString("USER_FIRST_NAME"));
			u.setUserLastName(rs.getString("USER_LAST_NAME"));
			u.setUserRoleId(new ErsUserRoles(rs.getInt("USER_ROLE_ID"), rs.getString("USER_ROLE")));
			
		}
		return u;

		}
	
	@Override
	public ErsUsers getPassByUserName(String username) throws SQLException {
		String sql = "select ERS_PASSWORD from ERS_USERS where ERS_USERNAME =?";
		connection = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		ErsUsers pass = new ErsUsers();
		while (rs.next()) {
			pass.setErsPassword(rs.getString("ERS_PASSWORD"));
			//pass=rs.getString("ERS_PASSWORD");

		}
		return pass;
	}
	
	public boolean checkpw(String username, String password) throws SQLException {
		connection = ConnectionFactory.getConnection();

		String sql = "select ERS_PASSWORD from ERS_USERS where ERS_USERNAME = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		String pw = null;
		while (rs.next()) {
			pw = rs.getString("ERS_PASSWORD");
		}System.out.println("from checkpw :      "+pw);
		
		return (BCrypt.checkpw(password, pw ));
	}
	
	
	
	@Override
	public void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}

	

}
