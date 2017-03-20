package ers.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.python.core.SysPackageManager;

import ers.utilities.ConnectionFactory;
import monfox.toolkit.snmp.agent.modules.SnmpV2Mib.SysOREntry;
import ers.model.ErsReimbursement;
import ers.model.ErsUserRoles;
import ers.model.ErsUsers;
import ers.model.ReimbursementStatus;
import ers.model.ReimbursementType;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	Connection connection = null; // Our connection to the database
	PreparedStatement stmt = null;

	public ReimbursementDAOImpl(Connection connection) {

		this.connection = connection;
	}

	@Override
	public boolean submitRequest(ErsReimbursement r) throws SQLException {
		
				connection = ConnectionFactory.getConnection();
			
			String sql = "INSERT INTO RMS.ERS_REIMBURSEMENT"
					+ "(REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,"
					+ "REIMB_DESCRIPTION,REIMB_AUTHOR,"
					+ "REIMB_STATUS_ID,REIMB_TYPE_ID)"
					+ "VALUES(?,?,SYSDATE,?,?,1,?)";
			
			
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, r.getReimbId());
			stmt.setDouble(2, r.getReimbAmount());
			stmt.setString(3, r.getDescription());
			stmt.setInt(4, r.getReimbAuthor().getErsUserId());
			stmt.setInt(5, r.getReimbType().getReimbTypeId());

			
			
//			ResultSet rs = stmt.getGeneratedKeys();
//			if(rs.next()){
//				System.out.println(rs.getString(1));
//			}
			
			if(stmt.executeUpdate() !=0){
				return true;
			}else
			return false;
		
	}

	@Override
	public boolean updateRequest(ErsReimbursement r) throws SQLException {
		connection= ConnectionFactory.getConnection();

		String sql = "UPDATE RMS.ERS_REIMBURSEMENT SET REIMB_STATUS_ID=?,REIMB_RESOLVED=?,REIMB_RESOLVER=? WHERE REIMB_ID=?";
		stmt = connection.prepareStatement(sql);
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());

		stmt.setInt(1, r.getReimbStatusId().getReimbStatusId());
		stmt.setTimestamp(2, sqlDate);
		stmt.setInt(3, r.getReimbResolver().getErsUserId());
		stmt.setInt(4, r.getReimbId());
//		System.out.println("ReimbDao 5 test " + reimb.getReimbStatusId().getStatusId());
//		System.out.println("ReimbDao 6 test " + reimb.getReimbResolver().getUsersId());
//		System.out.println("ReimbDao 7 test " + reimb.getReimbId());
//		

		if (stmt.executeUpdate() != 0) {

			return true;
		} else
			return false;
	}
	

	@Override
	public List<ErsReimbursement> viewTicketsById(int id) throws SQLException {
		List<ErsReimbursement> result = new ArrayList<ErsReimbursement>();

		connection = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM RMS.REIMBURSEMENT_VIEW WHERE AUTH_ID=?";

		stmt = connection.prepareStatement(sql);

		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			ErsReimbursement ri = new ErsReimbursement();
			ErsUsers us = new ErsUsers();
			ErsUserRoles ur = new ErsUserRoles();
			ReimbursementStatus st = new ReimbursementStatus();
			ReimbursementType rt = new ReimbursementType();
			
			// ri.getReimbAuthor().getErsUserId();

			ri.setReimbId(rs.getInt("RID"));
			//System.out.println(ri.getReimbId());
			ri.setReimbAmount(rs.getInt("AMOUNT"));
			ri.setReimbSubmitted(rs.getDate("SBMT"));
			ri.setReimbResolved(rs.getDate("RESLVD"));
			ri.setDescription(rs.getString("DESCRIP"));
			ri.setReimbAuthor(new ErsUsers(rs.getInt("AUTH_ID"), rs.getString("AUTH_USERNAME"),
					rs.getString("AUTH_FNAME"), rs.getString("AUTH_LNAME"), rs.getString("AUTH_EMAIL"),
					new ErsUserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			ri.setReimbResolver(new ErsUsers(rs.getInt("RESLVR_ID"), rs.getString("RESLVR_USERNAME"),
					rs.getString("RESLVR_FNAME"), rs.getString("AUTH_LNAME"), rs.getString("AUTH_EMAIL"),
					new ErsUserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			ri.setReimbStatusId(new ReimbursementStatus(rs.getInt("STATUSID"), rs.getString("STATUS")));
			ri.setReimbType(new ReimbursementType(rs.getInt("TYPEID"), rs.getString("RTYPE")));
//			us.setErsUserId(rs.getInt("AUTH_ID"));
//			us.setErsUserId(rs.getInt("RESLVR_ID"));
//			st.setReimbStatusId(rs.getInt("STATUSID"));
//			rt.setReimbTypeId(rs.getInt("TYPEID"));
//			
//			result.add(ri);
//			result.add(us); 
			result.add(ri);
			//System.out.println(ri);
		}
		return result;
	}

	@Override
	public List<ErsReimbursement> viewAllTickets() throws Exception {

		List<ErsReimbursement> result = new ArrayList<ErsReimbursement>();

		connection = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM RMS.REIMBURSEMENT_VIEW";

		stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			ErsReimbursement ri = new ErsReimbursement();
			ErsUsers us = new ErsUsers();
			ErsUserRoles ur = new ErsUserRoles();
			ReimbursementStatus st = new ReimbursementStatus();
			ReimbursementType rt = new ReimbursementType();
			
			// ri.getReimbAuthor().getErsUserId();

			ri.setReimbId(rs.getInt("RID"));
			//System.out.println(ri.getReimbId());
			ri.setReimbAmount(rs.getDouble("AMOUNT"));
			ri.setReimbSubmitted(rs.getDate("SBMT"));
			ri.setReimbResolved(rs.getDate("RESLVD"));
			ri.setDescription(rs.getString("DESCRIP"));
			ri.setReimbAuthor(new ErsUsers(rs.getInt("AUTH_ID"), rs.getString("AUTH_USERNAME"),
					rs.getString("AUTH_FNAME"), rs.getString("AUTH_LNAME"), rs.getString("AUTH_EMAIL"),
					new ErsUserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			ri.setReimbResolver(new ErsUsers(rs.getInt("RESLVR_ID"), rs.getString("RESLVR_USERNAME"),
					rs.getString("RESLVR_FNAME"), rs.getString("AUTH_LNAME"), rs.getString("AUTH_EMAIL"),
					new ErsUserRoles(rs.getInt("AUTH_ROLE_ID"), rs.getString("AUTH_ROLE"))));
			ri.setReimbStatusId(new ReimbursementStatus(rs.getInt("STATUSID"), rs.getString("STATUS")));
			ri.setReimbType(new ReimbursementType(rs.getInt("TYPEID"), rs.getString("RTYPE")));
//			us.setErsUserId(rs.getInt("AUTH_ID"));
//			us.setErsUserId(rs.getInt("RESLVR_ID"));
//			st.setReimbStatusId(rs.getInt("STATUSID"));
//			rt.setReimbTypeId(rs.getInt("TYPEID"));
//			
//			result.add(ri);
//			result.add(us);
			result.add(ri);
			//System.out.println(ri);
		}
		return result;
	}

	@Override
	public List<ErsReimbursement> viewTicketsByStatusId(int id) {
		List<ErsReimbursement> result = new ArrayList<ErsReimbursement>();

		try {
			try {
				connection = ConnectionFactory.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "SELECT * FROM RMS.ERS_REIMBURSEMENT WHERE RIEMB_STATUS_ID = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				result.add(new ErsReimbursement());

			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			closeResources();
		}

		return result;
	}

	private void closeResources() {
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
