
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CAL
 */
@WebServlet("/CAL")
public class CAL extends HttpServlet {
	public static ArrayList<String> mem = new ArrayList<String>();
	public static ArrayList<String> mem1 = new ArrayList<String>();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CAL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		read();
		System.out.println("mem1 includes:");
		for (int i = mem1.size() - 1; i >= 0; i--) {
			System.out.println(mem1.get(i));
			System.out.println();
		}
		System.out.println();
		System.out.println("mem includes:");
		for (int i = mem.size() - 1; i >= 0; i--) {
			System.out.println(mem.get(i));
			System.out.println();
		}
		int count = 1;
		String loop = "1";
		String bin = "bin";
		String dec = "dec";
		String hex = "hex";
		int y = 5;
		if (mem.size() >=3) {
			for (int i = mem.size() - 1; i >= 0; i--) {
				if (y == 0) {
					break;
				} else {
					String inp[] = mem.get(i).split("!");
					request.setAttribute(bin, String.valueOf(count) + ".Requested Number: " + inp[0]);
					request.setAttribute(dec, "  Requested Answer 1: " + inp[1]);
					request.setAttribute(hex, "  Requested Answer 2: " + inp[2]);
					request.getRequestDispatcher("HIST.jsp").include(request, response);
					System.out.println(inp);
					bin += loop;
					dec += loop;
					hex += loop;
					y--;
					count++;
				}

			}
		} else {
			for (int i = mem1.size() - 1; i >= 0; i--) {
				if (y == 0) {
					break;
				} else {
					String inp[] = mem1.get(i).split("!");
					request.setAttribute(bin, String.valueOf(count) + ".Requested Number: " + inp[0]);
					request.setAttribute(dec, "  Requested Answer 1: " + inp[1]);
					request.setAttribute(hex, "  Requested Answer 2: " + inp[2]);
					request.getRequestDispatcher("HIST.jsp").include(request, response);
					System.out.println(inp);
					bin += loop;
					dec += loop;
					hex += loop;
					y--;
					count++;
				}

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String x = request.getParameter("bin1");
		hex h = new hex();
		binarytest b = new binarytest();
		String resultd = b.getdecimal(x);
		String resulth = h.hexa(x);
		String over = "The binary number you entered is over the limit of 8 digits.Please try again.";
		String error = "The binary number you entered is incorrect, please check again.";
		System.out.println(resultd);
		System.out.println(resulth);

		if (((resultd == over) && (resulth == over)) || ((resultd == error) && (resulth == error))) {
			request.setAttribute("outpute", resultd);
		} else {
			mem.add(x + "!" + resultd + "!" + resulth);
			write(x + "!" + resultd + "!" + resulth);
			request.setAttribute("output1", resultd);
			request.setAttribute("output2", resulth);
		}
		request.setAttribute("that", x);
		// This will be available as
		// ${message}
		request.getRequestDispatcher("BIN_DECHEX.jsp").include(request, response);

	}

	public static void write(String x) {
		try {
			FileWriter writehandle = new FileWriter("C:\\Users/Pig Chu ^(00)^/Desktop/GP.txt", true);
			BufferedWriter bw = new BufferedWriter(writehandle);
			bw.newLine();
			bw.write(x);
			System.out.println("saved to txt");

			bw.close();
			writehandle.close();
		} catch (IOException ioe) {
			System.out.println("error.");

		}

	}

	public void read() {
		try {
			FileReader readhandle = new FileReader("C:\\Users/Pig Chu ^(00)^/Desktop/GP.txt");
			BufferedReader br = new BufferedReader(readhandle);
			String next = "";
			String line = "";

			while ((line = br.readLine()) != null) {
				next = line;
				System.out.println(next);
				mem1.add(next);
			}

			br.close();
			readhandle.close();
		} catch (IOException ioe) {
			System.out.println("error");

		}

	}

}
