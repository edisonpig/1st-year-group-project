

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(String result,String result1,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(result+"%"+result1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String x = request.getParameter("date_part1");
		String y = request.getParameter("date_part2");
		String z = request.getParameter("date_part3");
		//System.out.println(z);
		
		zeller cal= new zeller();
		String result= cal.cday(x);
		String result1 = cal.part2(y,z);
		//String result2 = result +"Result in part 2: "+result1;
		//String test = "result is here";
		System.out.println(result);
		System.out.println(result1);
		doGet(result,result1, response);
	}

	
	
}
