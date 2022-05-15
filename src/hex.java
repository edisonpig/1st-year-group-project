import java.util.ArrayList;

public class hex {

	public static void main(String[] args) {
		System.out.println(hexa("1011101111"));
		// TODO Auto-generated method stub
	}

	public static String hexa(String x) {
		String hexanum = "";
		String over = "The binary number you entered is over the limit of 8 digits.Please try again.";
		String error = "The binary number you entered is incorrect, please check again.";

		String hold[] = new String[2];

		String bi[] = x.split("");
		ArrayList<Integer> chain = new ArrayList<Integer>();
		try{
		for (int i = 0; i < bi.length; i++) {
			chain.add(Integer.parseInt(bi[i]));

		} //0001  1111
		int a = chain.size();
		if (a > 8) {
			return over;
		} else {
			while (a<8) {
				chain.add(0, 0);
				a = chain.size();
			}
			System.out.println(chain);
			System.out.println(a);
			int b = 0;
			for (int i = 0; i<=a; i += 4) {

				hold[b] = String.valueOf(chain.get(i)) + String.valueOf(chain.get(i + 1))
						+ String.valueOf(chain.get(i + 2)) + String.valueOf(chain.get(i + 3));
				b++;
				a-=4;
			}
			System.out.println(hold[0]);
			System.out.println(hold[1]);
			for (int i=0;i<hold.length;i++){
				String check=hold[i];
				switch(check){
				default:{
					return error;
				}
				case("0000"):{
					hexanum+="0";
					break;
				}
				case("0001"):{
					hexanum+="1";
					break;
				}			
				case("0010"):{
					hexanum+="2";
					break;
				}
				case("0011"):{
					hexanum+="3";
					break;
				}
				case("0100"):{
					hexanum+="4";
					break;
				}
				case("0101"):{
					hexanum+="5";
					break;
				}
				case("0110"):{
					hexanum+="6";
					break;
				}
				case("0111"):{
					hexanum+="7";
					break;
				}
				case("1000"):{
					hexanum+="8";
					break;
				}
				case("1001"):{
					hexanum+="9";
					break;
				}
				case("1010"):{
					hexanum+="A";
					break;
				}
				case("1011"):{
					hexanum+="B";
					break;
				}
				case("1100"):{
					hexanum+="C";
					break;
				}
				case("1101"):{
					hexanum+="D";
					break;
				}
				case("1110"):{
					hexanum+="E";
					break;
				}
				case("1111"):{
					hexanum+="F";
					break;
				}
				
				}
			}
			
			return hexanum;

		}//else
		}catch(Exception e){
			return error;
		}
	}
}
