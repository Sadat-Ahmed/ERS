package ers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.dao.ReimbursementDAO;
import ers.model.ErsReimbursement;
import ers.utilities.ConnectionFactory;
import ers.utilities.RFacade;

/**
 * Servlet implementation class ViewTicketsMgtServlet
 */
@WebServlet("/ViewTicketsMgtServlet")
public class ViewTicketsMgtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	ReimbursementDAO dao = new ConnectionFactory().getReimbursementDAO();
		RFacade df = new RFacade();
		List<ErsReimbursement> rList;
		try {
			rList = df.viewAllTickets();
			
			//rList = df.viewPastTickets(	(Integer)(request.getSession().getAttribute("Userid")));

			request.getSession().setAttribute("reimbs", rList);
			request.getRequestDispatcher("activities.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	
	}


}
