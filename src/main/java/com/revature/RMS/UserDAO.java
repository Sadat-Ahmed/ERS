package com.revature.RMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ers.model.ErsReimbursement;
import ers.model.ErsUsers;
import weblogic.xml.security.specs.User;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		this.conn = conn;

	}

	public ErsUsers getManager(int id) throws Exception {
		String sql = "SELECT ERS_USERS_ID, ERS_USERAME FROM RMS.ERS_USERS WHERE USER_ROLE_ID = 2";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery(); // rows returned by database are
											// stored in resultset object.
		// iterate over ResultSet and snatch those values

		ErsUsers user = new ErsUsers();
		while (rs.next()) { // 1.points to next row, 2. returns true of false if
							// there is a row.
			// object - relational mapping

			user.setErsUserId(rs.getInt("ERS_USERS_ID"));
			user.setErsUsername(rs.getString("ERS_USERNAME"));

		}
		return user;

	}

	public ErsUsers getEmployee(int id) throws Exception {
		String sql = "SELECT ERS_USERS_ID, ERS_USERAME FROM RMS.ERS_USERS WHERE USER_ROLE_ID = 1";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery(); // rows returned by database are
											// stored in resultset object.
		// iterate over ResultSet and snatch those values

		ErsUsers user = new ErsUsers();
		while (rs.next()) { // 1.points to next row, 2. returns true of false if
							// there is a row.
			// object - relational mapping

			user.setErsUserId(rs.getInt("ERS_USERS_ID"));
			user.setErsUsername(rs.getString("ERS_USERNAME"));

		}
		return user;

	}

	public List <ErsUsers> findRole(int id) throws Exception {
		String sql = "SELECT * FROM RMS.ERS_USERS A INNER JOIN RMS.ERS_USER_ROLES B ON A.USER_ROLE_ID=B.ERS_USER_ROLE_ID WHERE A.USER_ROLE_ID=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		List <ErsUsers> userList = new ArrayList<ErsUsers>();
		while (rs.next()) {
			
			//userList.add(new ErsUsers(rs.getInt("ERS_USER_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID")));


		}

		return userList;

	}
	
	
	//MANAGER MUST APPROVE OR DENY STATUS OF REIMBURSEMENT.
	public ErsReimbursement updateStatus(ErsReimbursement r) throws Exception {
		String sql = "UPDATE RMS.ERS_REIMBURSEMENT SET RIEMB_RESOLVED = ?, REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
	//	stmt.set
		
		
		return r;
		
		
		
	}
	
	

}
