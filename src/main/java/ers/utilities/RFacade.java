package ers.utilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.revature.RMS.ErsReimbursementDAO;

import ers.dao.ReimbursementDAO;
import ers.dao.ReimbursementDAOImpl;
import ers.dao.UsersDAOImpl;
import ers.model.ErsReimbursement;
import ers.model.ErsUsers;
import ers.dao.UsersDAO;

public class RFacade implements AutoCloseable {

	private UsersDAOImpl uDao;
	private ReimbursementDAOImpl rDao;
	private java.sql.Connection conn;

	public RFacade() {
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			uDao = new UsersDAOImpl(conn);
			rDao = new ReimbursementDAOImpl(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ErsReimbursement> viewAllTickets() {
		List<ErsReimbursement> all = new ArrayList<ErsReimbursement>();
		try {
			all = rDao.viewAllTickets();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return all;
	}

	public List<ErsReimbursement> viewPastTickets(int id) {
		List<ErsReimbursement> past = new ArrayList<ErsReimbursement>();
		try {
			past = rDao.viewTicketsById(id);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return past;
	}

	public boolean checkpw(String name, String password) {
		boolean checkpass = false;
		try {
			checkpass = uDao.checkpw(name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkpass;
	}

	public ErsUsers getbyname(String name) {

		ErsUsers getByName = new ErsUsers();
		try {
			getByName = uDao.getUserbyUsername(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getByName;
	}

	public boolean insert(ErsReimbursement reimb) {
		boolean adder = false;
		try {
			adder = rDao.submitRequest(reimb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adder;
	}

	public boolean update(ErsReimbursement r) {

		boolean a = false;
		try {
			a = rDao.updateRequest(r);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return a;

	}

	@Override
	public void close() throws Exception {
		if (conn != null)
			conn.close();
	}

}