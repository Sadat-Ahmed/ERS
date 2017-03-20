package ers.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.model.ErsReimbursement;
import ers.model.ErsUsers;
import ers.model.ReimbursementStatus;
import ers.utilities.RFacade;

public class UpdateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		RFacade rf = new RFacade();
		ErsReimbursement r = new ErsReimbursement();
		ErsUsers u = new ErsUsers();
		ReimbursementStatus st = new ReimbursementStatus();
		
		int rid = Integer.parseInt(req.getParameter("rid"));
		r.setReimbId(rid);
		
		//req.getSession().getAttribute("UserId");
		System.out.println("UpdateServlet 1 test: " + req.getSession().getAttribute("UserId"));
		//int UserId=((Integer)req.getSession().getAttribute("UserId"));
		
		int UserId =(Integer)(req.getSession().getAttribute("Userid"));
		//int UserId = 4;
		u.setErsUserId(UserId);
		r.setReimbResolver(u);
		
		
		int statuschangeid = Integer.parseInt(req.getParameter("updatedstat"));
		System.out.println("UpdateServlet 3 test: " + req.getParameter("updatedstat"));
		st.setReimbStatusId(statuschangeid);
		r.setReimbStatusId(st);
		
		
		boolean isSuccess = false;
		isSuccess =rf.update(r);
		
		if(isSuccess){
			
			resp.sendRedirect("ViewTickets");
		}else{
			resp.sendRedirect("activities.jsp");
		}
		try {
			rf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
