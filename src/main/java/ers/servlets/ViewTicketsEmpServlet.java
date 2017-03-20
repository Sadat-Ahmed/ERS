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
@WebServlet("/ViewTicketsEmpServlet")
public class ViewTicketsEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RFacade df = new RFacade();
		List<ErsReimbursement> rList;
		try {
			//Integer id = (Integer)(request.getAttribute("uid"));
			//String id = request.getParameter("uid");
			//request.getSession().setAttribute("uid", id);
			//rList = dao.viewTicketsById(Integer.parseInt(id));
			//int UserId=((Integer)request.getSession().getAttribute("UserId"));

			System.out.println((request.getSession().getAttribute("Userid")));
			rList = df.viewPastTickets(	(Integer)(request.getSession().getAttribute("Userid")));
			request.getSession().setAttribute("reimbs", rList);
			//request.getRequestDispatcher("empactivities.jsp").forward(request, response);
			response.sendRedirect("empactivities.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

