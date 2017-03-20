//package ers.servlets;
//
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.mindrot.jbcrypt.BCrypt;
//
//import com.bea.common.security.xacml.IOException;
//
//import ers.model.ErsUsers;
//import ers.utilities.RFacade;
//
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public LoginServlet() {
//
//	}
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
//
//	}
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, java.io.IOException {
//		RFacade df = new RFacade();
//		// check to see if it got the input
//		System.out.println("loginServlet " + req.getParameter("Username"));
//
//		ErsUsers user = df.getbyname(req.getParameter("Username"));
//
//		req.getSession().setAttribute("User", user);
//		System.out.println("user id from login servlet " + user.getErsUserId());
//		// req.getSession().setAttribute("Userid", user.getErsUserId());
//		// check to see if the input name
//		System.out.println("username from loginServlet " + user.getErsUsername());
//		System.out.println("password from loginservlet " + req.getParameter("Password"));
//		// System.out.println("LoginServlet : u role id = :" +
//		// user.getUserRoleId().getUserRoleId());
//		System.out.println(user.getErsUsername() + " this is the namee before if");
//		System.out.println(user.getUserRoleId().getUserRoleId());
//		//String pass=BCrypt.hashpw(req.getParameter("password"),BCrypt.gensalt());
//		System.out.println("HELLLOOOOO!!!!!!!!");
//
//		
//		if (user.getErsUsername() != null) {
//			System.out.println("asjbasbkasb");
//			if (df.checkpw(req.getParameter("Username"), req.getParameter("Password"))) {
//				System.out.println("username is ----test");
//				if (user.getUserRoleId().getUserRoleId() == 1) {
//					// if it is employee, will direct to emp site
//					req.getSession().setAttribute("UserRole", 1);
//					req.getSession().setAttribute("Userid", user.getErsUserId());
//
//					System.out.println("LoginServlet : u role id = :" + user.getUserRoleId().getUserRoleId());
//					resp.sendRedirect("ViewTicketsEmp");
//
//				} else if (user.getUserRoleId().getUserRoleId() == 2) {
//					// if it is manager, will direct to manager site
//					req.getSession().setAttribute("UserRole", 2);
//					req.getSession().setAttribute("Userid", user.getErsUserId());
//
//					resp.sendRedirect("ViewTickets");
//				}
//			} else
//				resp.sendRedirect("login.jsp");
//		} else {
//			resp.sendRedirect("login.jsp");
//		}
//		try {
//			df.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println((df.checkpw(req.getParameter("Username"), req.getParameter("Password"))));
//
//	}
//}