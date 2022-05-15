import java.util.ArrayList;
public class binarytest {

	public static String getdecimal(String b) {
		int decimalnumber = 0;
		String error = "The binary number you entered is incorrect, please check again.";
		String over = "The binary number you entered is over the limit of 8 digits.Please try again.";
		String bi[] = b.split("");
		ArrayList<Integer> bin = new ArrayList<Integer>();
		try{
		for (int i = 0; i < bi.length; i++) {
			bin.add(Integer.parseInt(bi[i]));

		}

		int power = bin.size();
		for(int i = 0;i<bin.size();i++){
				Integer one = bin.get(i);
				if(one >1){
					return error;
				}else{
				power--;
				decimalnumber += one* Math.pow(2, power);
				
		}
		}
		if (bin.size()>8){
			return over;
		}else{
		String ans = String.valueOf(decimalnumber);
		return ans;
		}
	}catch(Exception e){
	return error;
	}
	}

	public static void main(String args[]) {
System.out.println(getdecimal("10111001") );
System.out.println(getdecimal("11111111"));
System.out.println(getdecimal("10111111"));


		}
	}
