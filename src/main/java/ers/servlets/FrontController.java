package ers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import ers.model.ErsUsers;
import ers.utilities.RFacade;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {

		RFacade rf = new RFacade();
		ErsUsers user = rf.getbyname(req.getParameter("username"));

//	String pass = BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt());
		if (rf.checkpw(req.getParameter("username"), req.getParameter("password"))) {
			
			req.getSession().setAttribute("User", user);

			int roleid = user.getUserRoleId().getUserRoleId();
			System.out.println("the role  id for" + user + "is" + roleid);

			if (roleid == 1) {

				req.getSession().setAttribute("UserRole", 1);
				req.getSession().setAttribute("Userid", user.getErsUserId());
				resp.sendRedirect("ViewTicketsEmp");


			} else if (roleid == 2) {
				req.getSession().setAttribute("UserRole", 2);
				req.getSession().setAttribute("Userid", user.getErsUserId());
				resp.sendRedirect("ViewTickets");

			} else
				resp.sendRedirect("login.jsp");
		} else
			resp.sendRedirect("login.jsp");

	}

}
