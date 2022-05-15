

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();

    }
/*con = DriverManager.getConnection("jdbc:sqlite:convertor.db");
*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String newuname = request.getParameter("newuname");
		String newpwd = request.getParameter("newpwd");
		System.out.println(fname+" -- servlet (Register)");
		Member member = new Member(fname,lname,newuname,newpwd);
		Registerdb rig = new Registerdb();
		String result = null;
		try {

			result = rig.insert(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print(result );
		

	}

}
