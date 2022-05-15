
public class hamza {
		
	    public static void main(String args[]){
	    	
	        System.out.println(input(""));
	        
	    	}
	    
	    public static String input(String x) {
	    	
	        String hexdec_num;
	        int dec_num, i = 1, j;
	        int octal_num[] = new int[10];
	        String result="";
	        hexdec_num=x ;

	        dec_num = hex_to_decimal(hexdec_num);
	   
	        String ans_for_dec = ("Decimal: " +dec_num);

	        while (dec_num != 0) {
	            octal_num[i++] = dec_num % 8;
	            dec_num = dec_num / 8;
	            
	        }

	        
	        for (j = i - 1; j > 0; j--) {
	            System.out.print(octal_num[j]);
	            result =result + String.valueOf(octal_num[j]);
	            
	        }
	        

	        String ans_for_oct = ("Octal: " + result);

	        return ans_for_dec +"!"+ ans_for_oct;

	    	}
	    

	    public static int hex_to_decimal(String s) {
	    	
	        String digits = "0123456789ABCDEF";
	        s = s.toUpperCase();
	        int val = 0;
	        for (int i = 0; i < s.length(); i++) {
	        	
	            char c = s.charAt(i);
	            int d = digits.indexOf(c);
	            val = 16 * val + d;
	            
	        }
	        
	        return val;
	        
	    }
	
}
