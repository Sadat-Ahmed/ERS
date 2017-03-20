package ers.dao;

import java.sql.SQLException;
import java.util.List;

import ers.model.ErsReimbursement;

public interface ReimbursementDAO {
	
	public boolean submitRequest(ErsReimbursement r) throws SQLException;
	public boolean updateRequest(ErsReimbursement r) throws SQLException;
	public List<ErsReimbursement> viewTicketsById(int id) throws SQLException;
	public List<ErsReimbursement> viewAllTickets() throws Exception;
	public List<ErsReimbursement> viewTicketsByStatusId(int id);
	

}
