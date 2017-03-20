package ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.model.ErsReimbursement;
import ers.model.ErsUsers;
import ers.model.ReimbursementStatus;
import ers.model.ReimbursementType;
import ers.utilities.RFacade;

public class InsertServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RFacade rf = new RFacade();
		ErsReimbursement reim = new ErsReimbursement();
		ReimbursementStatus status = new ReimbursementStatus();
		ErsUsers user = new ErsUsers();
		ReimbursementType type = new ReimbursementType();

		reim.setReimbId(3);

		System.out.println("nooo wayy:" + request.getAttribute("amount"));
		// double amt = Double.parseDouble(request.getParameter("amount"));
		double amount = Double.parseDouble((String) request.getAttribute("amount"));
		reim.setReimbAmount(amount);

		String description = request.getParameter("rdescription");
		reim.setDescription(description);

		int rtype = Integer.parseInt(request.getParameter("rtype"));
		type.setReimbTypeId(rtype);
		reim.setReimbType(type);

		request.getSession().getAttribute("UserId");
		// int UserId=((Integer)request.getSession().getAttribute("UserId"));
		int UserId = 1;
		user.setErsUserId(UserId);
		reim.setReimbAuthor(user);

		boolean isSuccess = false;

		isSuccess = rf.insert(reim);

		if (isSuccess) {
			System.out.println("success");
			request.getSession().setAttribute("message", "Reimbursement successful");
			request.getSession().setAttribute("messageClass", "alert-success");
			request.getRequestDispatcher("empactivities.jsp").forward(request, response);
		} else {
			System.out.println("nadaaa");

			request.getSession().setAttribute("message", "There was a problem adding the reimbursement");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}

	}

}
