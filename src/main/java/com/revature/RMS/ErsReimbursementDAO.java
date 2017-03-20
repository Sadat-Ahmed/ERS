package com.revature.RMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ers.model.ErsReimbursement;

public class ErsReimbursementDAO {

	private Connection conn;

	public ErsReimbursementDAO(Connection conn) {
		this.conn = conn;

	}

	// employee submits request

	public void submitRequest(ErsReimbursement reim) throws Exception {

		String sql = "INSERT INTO RMS.ERS_REIMBURSEMENT VALUES (?,?,SYSDATE,NULL,?,NULL,?,NULL,1,?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, reim.getReimbId());
		stmt.setDouble(2, reim.getReimbAmount());
		//stmt.setDate(3, reim.getReimbSubmitted());
		//stmt.setDate(4, reim.getReimbResolved());
		stmt.setString(3, reim.getDescription());
		//stmt.setByte(6, reim.getReimbReceipt());
		stmt.setInt(4, reim.getReimbAuthor().getErsUserId());
		//stmt.setInt(8, reim.getReimbResolver());
		//stmt.setInt(5, reim.getReimbStatusId());
		stmt.setInt(5, reim.getReimbType().getReimbTypeId());

		stmt.executeUpdate();

	}

	// employee views own past tickets
	
	public List<ErsReimbursement> viewPastTickets(int id) throws Exception {

		String sql = "SELECT * FROM RMS.ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		List<ErsReimbursement> result = new ArrayList<ErsReimbursement>();

		while (rs.next()) {
			result.add(new ErsReimbursement());

		}
		return result;

	}
	//manager can view all tickets of all users.
	
	public List<ErsReimbursement> viewAllTickets() throws Exception {

		String sql = "SELECT * FROM RMS.ERS_REIMBURSEMENT";

		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<ErsReimbursement> result = new ArrayList<ErsReimbursement>();

		while (rs.next()) {
			result.add(new ErsReimbursement());

		}
		return result;

	}

	//MANAGER CAN VIEW TICKETS BY STATUS ID
	public List<ErsReimbursement> viewTicketsByStatus(int id) throws Exception {

		String sql = "SELECT * FROM RMS.ERS_REIMBURSEMENT WHERE RIEMB_STATUS_ID = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		List<ErsReimbursement> result = new ArrayList<ErsReimbursement>();

		while (rs.next()) {
			result.add(new ErsReimbursement());

		}
		return result;

	}

}
