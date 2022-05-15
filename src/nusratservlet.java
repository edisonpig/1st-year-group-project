

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class invalidates a session when the user clicks the logout button.
 * NOTE: This can also be achieved using JAVA code in the actual JSP file.
 */
@WebServlet("/nusrat")
public class nusratservlet extends HttpServlet {
	String myhex;
	char ch;
	int n;
	int num = 0; 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String Hexadecimal = request.getParameter("Hexadecimal");


		System.out.println(" Decimal Value "
				+HEXtoDECi(Hexadecimal));

		System.out.println( " octal Value = "+ hex_to_oct(Hexadecimal)); 
		


	}

	//Hexadecimal to Octal 

	String hex_to_oct(String hexa)
	{
		int dec = 0;
		// taking 1AC as an example of hexadecimal Number.
		//String hexa = "1AC";
		int c = hexa.length() - 1;
		// finding the decimal equivalent of the
		// hexa decimal number
		for(int i = 0; i < hexa.length() ; i ++ )
		{
			//extracting each character from the string.
			char ch = hexa.charAt(i);
			switch (ch)

			{
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				dec = dec + Integer.parseInt(Character.toString(ch))*
				(int)Math.pow(16,c);
				c--;
				break;
			case 'a':
			case 'A':
				dec = dec + 10 * (int)Math.pow(16, c);
				c--;
				break;
			case 'b':
			case 'B':
				dec = dec + 11 * (int)Math.pow(16, c);
				c--;
				break;
			case 'c':
			case 'C':
				dec = dec + 12 * (int)Math.pow(16, c);
				c--;
				break;
			case 'd':
			case 'D':
				dec = dec + 13 * (int)Math.pow(16, c);
				c--;
				break;
			case 'e':
			case 'E':
				dec = dec + 14 * (int)Math.pow(16, c);
				c--;
				break;
			case 'f':
			case 'F':
				dec = dec + 15 * (int)Math.pow(16, c);
				c--;
				break;
			default:

				break;
			}
		}
		// String oct to store the octal equivalent of a hexadecimal number.
		String oct ="";
		//converting decimal to octal number.
		while(dec > 0)
		{
			oct = dec % 8 + oct;
			dec = dec / 8;
		}
		// Printing the final output.
		//System.out.println("Equivalent Octal Value = "+oct);
		return oct;
	}

	//  Hexadecimal to Decimal

	String HEXtoDECi(String hexnum)
	{
		String hstring="0123456789ABCDEF";

		hexnum = hexnum.toUpperCase(); 
		for (int i = 0; i < hexnum.length(); i++) 
		{ 
			ch = hexnum.charAt(i); 
			n = hstring.indexOf(ch); 
			num = 16*num + n; 
		}
		//convert number into integer : to display int value
		myhex=String.valueOf(num);
		return myhex; 
	} 


}

