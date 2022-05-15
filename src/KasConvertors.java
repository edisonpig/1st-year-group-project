import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Convertors
 */
@WebServlet("/KasConvertors")
public class KasConvertors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KasConvertors() {
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

		int  dec = Integer.parseInt(request.getParameter("decimal"));
		int save =dec;
		if(dec<1000)
		{
			int dec1=dec;
			int[] octalNum = new int[100];
			int i =0;
			String Octal=" ";

			while (dec != 0) {
				// storing remainder in octal array
				octalNum[i] = dec % 8;
				dec = dec / 8;
				i++;
			}
			for (int j = i - 1; j >= 0; j--)
			{
				Octal=String.valueOf(octalNum[j])+Octal;
			}
			int rem;
			String str2="";

			char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			while(dec1>0)
			{
				rem=dec1%16; 
				str2=hex[rem]+str2; 
				dec1=dec1/16;
			}
			request.setAttribute("octal",Octal);
			request.setAttribute("Hex",str2);
			request.getRequestDispatcher("Kasinos.jsp").forward(request, response);
			CAL cal = new CAL();
			cal.mem.add(save+"!"+Octal+"!"+str2);
			cal.write(save+"!"+Octal+"!"+str2);
		}
		else
		{
			request.setAttribute("text","Input a 3 digit decimal");
			request.getRequestDispatcher("Kasinos.jsp").forward(request, response);
		}

	}

}