import java.util.Scanner;
public class ajmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a binary number: ");
		
		String binary;
		binary = sc.nextLine();
		
		int decimal;
		String octal;
		
		decimal = Integer.parseInt(binary,2);
		
		octal = Integer.toOctalString(decimal);
		
		System.out.println("Decimal: "+decimal+", Octal: "+octal+"");

		}
}
