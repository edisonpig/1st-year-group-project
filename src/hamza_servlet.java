import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HextoOctDec
 */
@WebServlet("/hamzaconverter")
public class hamza_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hamza_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // TODO Auto-generated method stub
        String x= request.getParameter("hex1");
        hamza h = new hamza();
        String result = h.input(x);
        String res[]=result.split("!");
        CAL cal = new CAL();
        cal.mem.add(x+"!"+res[0]+"!"+res[1]);
        cal.write(x+"!"+res[0]+"!"+res[1]);
        System.out.println(res[0]);
        request.setAttribute("output1", res[0]);
        request.setAttribute("output2", res[1]);
        request.setAttribute("that", x);
        request.getRequestDispatcher("hamzaconverter.jsp").include(request,response);
	}

}