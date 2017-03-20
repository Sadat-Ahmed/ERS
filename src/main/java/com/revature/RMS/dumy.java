package com.revature.RMS;

import org.mindrot.jbcrypt.BCrypt;

public class dumy {
	public static void main(String[] args) {
		String pw_hashed = BCrypt.hashpw("sadat123" , BCrypt.gensalt());
		System.out.println(pw_hashed);
		// username RobDownie
		String hashed = BCrypt.hashpw("johnster" , BCrypt.gensalt());
		System.out.println(hashed);
		// username MaxMiller
		String pw = BCrypt.hashpw("maxster" , BCrypt.gensalt());
		System.out.println(pw);
		// username JohnSmith
		String p = BCrypt.hashpw("herbster" , BCrypt.gensalt());
		System.out.println(p);
		// username AnnaNicole
		String d = BCrypt.hashpw("davester" , BCrypt.gensalt());
		System.out.println(d);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////\
	
	
//	
//	
//	package com.revature.ExpenseReimbursementSystem.Servlets;
//
//	import java.io.IOException;
//	import java.util.ArrayList;
//	import java.util.List;
//
//	import javax.servlet.ServletException;
//	import javax.servlet.http.HttpServlet;
//	import javax.servlet.http.HttpServletRequest;
//	import javax.servlet.http.HttpServletResponse;
//
//	import org.mindrot.jbcrypt.BCrypt;
//
//	import com.revature.ExpenseReimbursementSystem.DAO.EmployeeDAO;
//	import com.revature.ExpenseReimbursementSystem.DAO.FinanceManagerDAO;
//	import com.revature.ExpenseReimbursementSystem.DAO.UserDAO;
//	import com.revature.ExpenseReimbursementSystem.Utilities.DAOUtilities;
//	import com.revature.ExpenseReimbursementSystem.model.ErsReimbursement;
//	import com.revature.ExpenseReimbursementSystem.model.ErsUsers;
//
//	public class FrontControllerServlet extends HttpServlet {
//
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			/*
//			 * // get the userinfo from database UserDAO dao =
//			 * DAOUtilities.getUserDAO(); ErsUsers user =
//			 * dao.getUserByUsername(req.getParameter("username"));// returns //
//			 * Ers_users // object // matching // username
//			 * req.getSession().setAttribute("User", user);
//			 * 
//			 * 
//			 * String role_id = String.valueOf(user.getUser_role_id()); if
//			 * (role_id.startsWith("1")) {
//			 * 
//			 * req.getSession().setAttribute("employeeUser", user); //
//			 * resp.sendRedirect("employeeHome.jsp");
//			 * req.getRequestDispatcher("employeeHome.jsp").forward(req, resp); }
//			 * else if (role_id.startsWith("2")) {
//			 * 
//			 * req.getSession().setAttribute("financeManagerUser", user); //
//			 * resp.sendRedirect("financeManagerHome.jsp");
//			 * req.getRequestDispatcher("employeeHome.jsp").forward(req, resp); }
//			 */
//		}
//
//		@Override
//		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			// get the userinfo from database
//			UserDAO dao = DAOUtilities.getUserDAO();
//			String username = req.getParameter("username");
//			ErsUsers user = dao.getUserByUsername(username);// returns
//															// Ers_users object
//			//hash incoming password to be checked with one from database
//			String pass=BCrypt.hashpw(req.getParameter("password"),BCrypt.gensalt());
//			if(BCrypt.checkpw(user.getErs_password(),pass))
//			//if (user.getErs_password().equals(req.getParameter("password")))
//
//			{
//
//				req.getSession().setAttribute("User", user);
//				// get the userrole id so frontControllerServlet can determine which
//				// Home page to send to
//				String role_id = String.valueOf(user.getUser_role_id());
//				// here we determine if the user's roleid starts with '1' or '2'
//				// starting with '1'will be a employee.
//				// starting with '2' will be a finance manager
//				// Ex: roleid: 1225(employee) or roleid: 23(financemanager)
//				if (role_id.startsWith("1")) {
//					EmployeeDAO database = DAOUtilities.getEmployeeDAO();
//					List<ErsReimbursement> reimbursementsList = new ArrayList<ErsReimbursement>();
//					// here we get reimbursements for the employee by their userid
//					reimbursementsList = database.getAllReimbursements(user.getErs_usersid());
//					req.getSession().setAttribute("reimbursements", reimbursementsList);
//					req.getSession().setAttribute("employeeUser", user);
//					resp.sendRedirect("employeeHome.jsp");
//				} else if (role_id.startsWith("2")) {
//					FinanceManagerDAO database = DAOUtilities.getFinanceManagerDAO();
//					// here we get all reimbursements from all employee request
//					List<ErsReimbursement> reimbursementsList = new ArrayList<ErsReimbursement>();
//					reimbursementsList = database.getAllReimbursements();
//					req.getSession().setAttribute("allreimbursements", reimbursementsList);
//					req.getSession().setAttribute("financeManagerUser", user);
//					resp.sendRedirect("financeManagerHome.jsp");
//				} else {
//					resp.sendRedirect("UserLogin.jsp");
//				}
//			}
//			if (!user.getErs_password().equals(req.getParameter("password"))) {
//				resp.sendRedirect("UserLogin.jsp");
//			}
//		}

	}

	
	
	


