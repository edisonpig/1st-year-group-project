
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 * This class invalidates a session when the user clicks the logout button.
 * NOTE: This can also be achieved using JAVA code in the actual JSP file.
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Invalidate the session if exists
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        request.setAttribute("logout", "You have logged out."); 		// This will be available as ${message}
        request.getRequestDispatcher("home.jsp").include(request, response); 
    }

	
}