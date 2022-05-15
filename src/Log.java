
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/Log")
public class Log extends HttpServlet {
	public String user;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Log() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		s.setAttribute("Welcome", "Back! " + user);
		Registerdb check = new Registerdb();
		int count = check.count;
		s.setAttribute("count", "You have visited this page " + String.valueOf(count) + " times");

		request.getRequestDispatcher("user-welcome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		Registerdb rig = new Registerdb();
		String result = null;
		try {
			result = rig.check(uname, pwd);
			System.out.println("got login result");
			String see[] = result.split("!");
			int count = rig.count;
			int seen = rig.newu;
			System.out.println("count in log is " + count);
			if (see.length != 1) {

				HttpSession s = request.getSession();
				if (seen == 1)
					s.setAttribute("Welcome", " Back! " + see[1] + " " + see[2]);
				else if (seen == 0)
					s.setAttribute("Welcome", " New User! " + see[1] + " " + see[2]);
				s.setAttribute("count", "You have visited this page " + String.valueOf(count) + " times");
				s.setAttribute("Welcome1", see[1] + " " + see[2]);
				user = see[1] + " " + see[2];

				request.getRequestDispatcher("user-welcome.jsp").forward(request, response);
				System.out.println("good " + uname + " " + pwd);
				System.out.println("newu in log is " + seen);
			} else {
				request.setAttribute("wrong", "Invalid username or password!");
				request.getRequestDispatcher("home.jsp").include(request, response);
				System.out.println("bad " + uname + " " + pwd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
