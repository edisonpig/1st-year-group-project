
//import java.util.InputMismatchException;
//import java.lang.Math;
import java.util.Scanner;

public class assignment_0 {

	private static Scanner inp;

	public static void main(String[] args) {
		// Declare
		inp = new Scanner(System.in);

		boolean whole = true; // ,age =true;
		// int q=0,m=0,y=0;
		int i = 0, yearday = 0, cal = 0, day = 0;

		// this is an alternative way (better) to do the part 1 with array and split the input
		System.out.println("This is the first part of Assignment 0.\n");

		String date = "";
		int data[] = new int[3]; // HTML DoPost()<-- Servlet
		while (whole) {
			try {
				System.out.println("Please enter the day of the date. (dd/mm/yyyy)");
				date = inp.nextLine();

				String dta[] = date.split("/", 3);

				for (i = 0; i < 3; i++) {
					data[i] = Integer.parseInt(dta[i]);

				}
				if ((data[1] < 1) || (data[1] > 12)) {
					System.out.println("Please enter a valid date!");
					//} else if (( (data[2] > 2100)) {
					//System.out.println("Please enter a valid date!");
				}
				switch (data[1]){
				default:
					System.out.println("Please enter a valid date!");
				case 1:case 3: case 5: case 7: case 8: case 10:case 12:
				{
					if ((data[0] < 1) || (data[0] > 31)) {
						System.out.println("Please enter a valid date!");
					}
					else{
						whole = false;
					}
					break;
				}
				case 4:case 6:case 9:case 11:
				{
					if ((data[0] < 1) || (data[0] > 30)) {
						System.out.println("Please enter a valid date!");
					}
					else{
						whole = false;
					}
					break;
				}	
				case 2:
				{
					if (!(((data[2] % 4 == 0) && !(data[2] % 100 == 0))||(data[2] % 400 == 0)) && (data[0] >= 29)) {
						System.out.println("Please enter a valid date!");

					} else if ((((data[2] % 4 == 0) && !(data[2] % 100 == 0))||(data[2] % 400 == 0)) && (data[0] > 29)) {
						System.out.println("Please enter a valid date!");
					}else {
						whole = false;
					}
					break;
				}
				}//switch end
			} catch (Exception e) {
				System.out.println("Please enter a valid date!");
			}
		}

		/*
		 * if ((bd[0]<1)||(bd[0]>31)){
		 * System.out.println("Please enter a valid date!");
		 * 
		 * } else if ((data[1]<1)||(data[1]>12)) {
		 * System.out.println("Please enter a valid date!"); } else if
		 * ((bd[2]<1900)||(bd[2]>2100)){
		 * System.out.println("Please enter a valid date!");
		 * 
		 * } else if (!((bd[2] % 4 == 0) && !(bd[2] % 100 == 0)) &&(bd[1]==2)
		 * &&(bd[0]==29)) { System.out.println("Please enter a valid date!"); }
		 * else if (!(bd[2] % 400 == 0)&&(bd[1]==2) &&(bd[0]>29)) {
		 * System.out.println("Please enter a valid date!"); }
		 */
		if ((data[1] == 1) || (data[1] == 2)) {
			data[1] = data[1] + 12;
			data[2] = data[2] - 1;
		}

		// calculations
		int k = (int) (data[2]) % 100;
		int j = (int) (data[2]) / 100;
		int a = (int) ((13 * ((data[1]) + 1)) / 5);
		int b = (int) (k / 4);
		int c = (int) (j / 4);

		int h = (int) (data[0] + a + k + b + c + 5 * j) % 7;

		// rewrite Jan and Feb after calculations
		if ((data[1] == 13) || (data[1] == 14)) {
			data[1] -= 12;
			data[2] += 1;
		}

		// System.out.println(h);

		// display output (Sat to Fri)
		switch (h) {
		case 0: {
			System.out.println(date + " is a Saturday!");
			break;
		}
		case 1: {
			System.out.println(date + " is a Sunday!");
			break;
		}
		case 2: {
			System.out.println(date + " is a Monday!");
			break;
		}
		case 3: {
			System.out.println(date + " is a Tuesday!");
			break;
		}
		case 4: {
			System.out.println(date + " is a Wednesday!");
			break;
		}
		case 5: {
			System.out.println(date + " is a Thursday!");
			break;
		}
		case 6: {
			System.out.println(date + " is a Friday!");
			break;
		}
		}

		// This is my first attempt before talking to Mr. Zear Ibrahim asking where to put the try catch
		// Start 1st part
		/*
		 * 
		 * System.out.println("This is the first part of Assignment 0.\n");
		 * 
		 * //input date
		 * 
		 * //day // try{ while (whole){
		 * System.out.println("Please enter the day of the date"); //try{ q =
		 * inp.nextInt(); //} catch (Exception e) { // q=0; }
		 * 
		 * if ((q<1)||(q>31)){ System.out.println("Please enter a valid date!");
		 * 
		 * } else{
		 * 
		 * whole =false; } } whole = true;
		 * 
		 * //month while (whole){
		 * System.out.println("Please enter the month of the date"); m =
		 * inp.nextInt();
		 * 
		 * if ((m<1)||(m>12)) {
		 * System.out.println("Please enter a valid date!"); } else if
		 * ((m==2)&&(q>29)){ System.out.println("Please enter a valid date!"); }
		 * else{ whole = false; } } whole = true;
		 * 
		 * 
		 * //year while (whole){
		 * System.out.println("Please enter the year of the date"); y =
		 * inp.nextInt();
		 * 
		 * if ((y<1900)||(y>2100)){
		 * System.out.println("Please enter a valid date!");
		 * 
		 * } else if (!((y % 4 == 0) && !(y % 100 == 0)) &&(m==2) &&(q==29)) {
		 * System.out.println("Please enter a valid date!"); } else if (!(y %
		 * 400 == 0)&&(m==2) &&(q==29)) {
		 * System.out.println("Please enter a valid date!"); } else{
		 * 
		 * whole =false; } } whole =true;
		 * 
		 * //Jan and Feb if ((m==1)||(m==2)){ m=m+12; y=y-1; }
		 * 
		 * 
		 * //calculations int k = (y%100); int j = y/100; int a =
		 * (int)Math.floor((13*(m+1))/5); int b = (int)Math.floor(k/4); int c =
		 * (int)Math.floor(j/4);
		 * 
		 * int h= (int)(q +a+ k +b+c+5*j)%7;
		 * 
		 * //rewrite Jan and Feb after calculations if ((m==13)||(m==14)){
		 * m=m-12; y=y+1; }
		 * 
		 * //System.out.println(h);
		 * 
		 * //display output (Sat to Fri) switch (h){ case 0:{
		 * System.out.println(q+"/"+m+"/"+y+" is a Saturday!"); break; } case
		 * 1:{ System.out.println(q+"/"+m+"/"+y+" is a Sunday!"); break; } case
		 * 2:{ System.out.println(q+"/"+m+"/"+y+" is a Monday!"); break; } case
		 * 3:{ System.out.println(q+"/"+m+"/"+y+" is a Tuesday!"); break; } case
		 * 4:{ System.out.println(q+"/"+m+"/"+y+" is a Wednesday!"); break; }
		 * case 5:{ System.out.println(q+"/"+m+"/"+y+" is a Thursday!"); break;
		 * } case 6:{ System.out.println(q+"/"+m+"/"+y+" is a Friday!"); break;
		 * }
		 * 
		 * }
		 * 
		 * //End //Start 2nd
		 * System.out.println("\nThis is the second part of Assignment 0. \n");
		 * 
		 * //input birthday System.out.println("Please enter your birthday!\n");
		 * while (age){ while (whole){
		 * System.out.println("Please enter the day of your birthday"); q =
		 * inp.nextInt();
		 * 
		 * if ((q<1)||(q>31)){//wrong
		 * System.out.println("Please enter a valid date!");
		 * 
		 * } else{
		 * 
		 * whole =false; } } whole = true; //month while (whole){
		 * System.out.println("Please enter the month of your birthday"); m =
		 * inp.nextInt();
		 * 
		 * if ((m<1)||(m>12)){ System.out.println("Please enter a valid date!");
		 * } else if ((m==2)&&(q>29)){
		 * System.out.println("Please enter a valid date!"); } else{ whole =
		 * false; } } whole = true;
		 * 
		 * //year while (whole){
		 * System.out.println("Please enter the year of your birthday"); y =
		 * inp.nextInt();
		 * 
		 * if ((y<1900)||(y>2100)){
		 * System.out.println("Please enter a valid date!");
		 * 
		 * } else if (!((y % 4 == 0) && !(y % 100 == 0)) &&(m==2) &&(q==29)) {
		 * System.out.println("Please enter a valid date!"); } else if (!(y %
		 * 400 == 0)&&(m==2) &&(q==29)) {
		 * System.out.println("Please enter a valid date!"); } else{
		 * 
		 * whole =false; } } whole =true;
		 */

		// input today
		/*
		 * System.out.println("Please enter today's date!\n");
		 * 
		 * //day while (whole){
		 * System.out.println("Please enter the day of today's date"); a =
		 * inp.nextInt();
		 * 
		 * if ((a<1)||(a>31)){ System.out.println("Please enter a valid date!");
		 * 
		 * } else{
		 * 
		 * whole =false; } } whole = true; //month while (whole){
		 * System.out.println("Please enter the month of today's date"); b =
		 * inp.nextInt();
		 * 
		 * if ((b<1)||(b>12)){ System.out.println("Please enter a valid date!");
		 * } else if ((b==2)&&(a>29)){
		 * System.out.println("Please enter a valid date!"); } else{ whole =
		 * false; } } whole = true;
		 * 
		 * //year while (whole){
		 * System.out.println("Please enter the year of today's date"); c =
		 * inp.nextInt();
		 * 
		 * if ((c<1900)||(c>2100)){
		 * System.out.println("Please enter a valid date!");
		 * 
		 * } else if (!(((c % 4 == 0) && !(c % 100 == 0))||(c%400==0)) &&(b==2)
		 * &&(a==29)) { System.out.println("Please enter a valid date!"); }
		 * else{
		 * 
		 * whole =false; } } whole =true;
		 */
		// Second attempt of part 2
		// input birthday	
		/*
		 * String date= ""; //HTML DoPost()<-- Servlet while(whole){ try{
		 * System.out.println("Please enter the day of the date");
		 * System.out.println("Please enter it in dd/mm/yyyy style"); date =
		 * inp.nextLine(); whole = false; } catch (Exception e){
		 * System.out.println("Please enter a valid date!"); } }
		 * 
		 * String dta[] = date.split("/"); int data[] = new int[3]; for
		 * (i=0;i<3;i++){ data[i]=Integer.parseInt(dta[i]);
		 */
		System.out.println("\nThis is the second part of Assignment 0. \n");
		whole = true;
		boolean leapyr=false;
		int bd[] = new int[3];
		// day
		String birthday = "0"; // HTML DoPost()<-- Servlet
		while (whole) {
			try {
				System.out.println("Please enter your birthday. (dd/mm/yyyy)");
				birthday = inp.nextLine();

				String bday[] = birthday.split("/", 3);

				for (i = 0; i < 3; i++) {
					bd[i] = Integer.parseInt(bday[i]);
				}
				if ((bd[1] < 1) || (bd[1] > 12)) {
					System.out.println("Please enter a valid date!");
					//} else if ((bd[2] < 1900) || (bd[2] > 2100)) {
					//System.out.println("Please enter a valid date!");
				}
				switch (bd[1]){
				default:
					System.out.println("Please enter a valid date!");
				case 1:case 3: case 5: case 7: case 8: case 10:case 12:
				{
					if ((bd[0] < 1) || (bd[0] > 31)) {
						System.out.println("Please enter a valid date!");
					}
					else{
						whole = false;
					}
					break;
				}
				case 4:case 6:case 9:case 11:
				{
					if ((bd[0] < 1) || (bd[0] > 30)) {
						System.out.println("Please enter a valid date!");
					}
					else{
						whole = false;
					}
					break;
				}	
				case 2:
				{
					if (!(((bd[2] % 4 == 0) && !(bd[2] % 100 == 0))||(bd[2] % 400 == 0)) && (bd[0] >= 29)) {
						System.out.println("Please enter a valid date!");

					} else if ((((bd[2] % 4 == 0) && !(bd[2] % 100 == 0))||(bd[2] % 400 == 0)) && (bd[0] > 29)) {
						System.out.println("Please enter a valid date!");
					}else {
						whole = false;
					}
					break;
				}
				}//switch end
			} catch (Exception e) {
				System.out.println("Please enter a valid date!");
			}
		}

		String today = "";
		whole = true;
		int td[] = new int[3];
		// today
		while (whole) {
			try {
				System.out.println("Please enter the day of today's date. (dd/mm/yyyy)");
				today = inp.nextLine();

				String current[] = today.split("/", 3);

				for (i = 0; i < 3; i++) {
					td[i] = Integer.parseInt(current[i]);
				}

				if ((td[1] < 1) || (td[1] > 12)) {
					System.out.println("Please enter a valid date!");
					//} else if ((td[2] < 1900) || (td[2] > 2100)) {
					//System.out.println("Please enter a valid date!");
				}
				switch (td[1]){
				default:
					System.out.println("Please enter a valid date!");
				case 1:case 3: case 5: case 7: case 8: case 10:case 12:
				{
					if ((td[0] < 1) || (td[0] > 31)) {
						System.out.println("Please enter a valid date!");
					}
					else{
						whole = false;
					}
					break;
				}
				case 4:case 6:case 9:case 11:
				{
					if ((td[0] < 1) || (td[0] > 30)) {
						System.out.println("Please enter a valid date!");
					}
					else{
						whole = false;
					}
					break;
				}	
				case 2:
				{
					if (!(((td[2] % 4 == 0) && !(td[2] % 100 == 0))||(td[2] % 400 == 0)) && (td[0] >= 29)) {
						System.out.println("Please enter a valid date!");

					} else if ((((td[2] % 4 == 0) && !(td[2] % 100 == 0))||(td[2] % 400 == 0)) && (td[0] > 29)) {
						System.out.println("Please enter a valid date!");
					}else {
						whole = false;
					}
					break;
				}
				}//switch end
			} catch (Exception e) {
				System.out.println("Please enter a valid date!");
			}
		}

		// real start of while(age) // what if it is not age?(delete while(age)
		// and use
		/*
		 * if (td[2]>bd[2]){ age=false; } else if
		 * ((td[2]==bd[2])&&(td[1]>bd[1])){ age=false; } else if
		 * ((td[2]==bd[2])&&(td[1]==bd[1])&&(td[0]>bd[0])){ age=false; } else {
		 * System.out.println("You are not even born!");
		 * System.out.println("Try it again!"); }
		 */
		// while(age) end
		// calculations of leap year
		if (((bd[2] % 4 == 0) && (bd[2] % 100 != 0))||(bd[2] % 400 == 0)) {
			leapyr = true;
		}
		for (i = bd[2] + 1; i < td[2]; i++) {
			if (((i % 4 == 0) && !(i % 100 == 0))||(i% 400==0)) {
				yearday = 366;
			} else {
				yearday = 365;
			}
			cal += yearday;
		}
		boolean bug = false;
		if (bd[1] == 12) { // dec bug
			bd[1] -= 1;
			cal -= 31;
			bug = true;
		}
		// calculations of month from birthday
		for (i = bd[1] + 1; i <= 12; i++) { // test dec
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: {
				day = 31;
				cal += day;
				break;
			}
			case 2: {
				if (leapyr = true) {
					day = 29;
				} else {
					day = 28;
				}
				cal += day;
				break;
			}
			case 4:
			case 6:
			case 9:
			case 11: {
				day = 30;
				cal += day;
				break;
			}
			}// end switch
		} 
		if (bug == true){
			bd[1]=12;
		}

		// calculation of month from this year

		for (i = 1; i < td[1]; i++) {
			switch (i) {
			case 1:case 3:case 5:case 7:case 8:case 10:case 12: {
				day = 31;
				cal += day;
				break;
			}
			case 2: {

				if (((td[2] % 4 == 0) && !(td[2] % 100 == 0)) || (td[2] % 400 == 0)) {
					day = 29;
				} else {
					day = 28;
				}
				cal += day;
				break;
			}
			case 4:case 6:case 9:case 11: {
				day = 30;
				cal += day;
				break;
			}
			}// end switch
		} // end for

		//same year bug
		if (bd[2]==td[2]){
			if (leapyr == true){
				cal-=366;
			}
			else {
				cal-=365;
			}
		}

		// calculations of days
		if (bd[1] == 1 || bd[1] == 3 || bd[1] == 5 || bd[1] == 7 || bd[1] == 8 || bd[1] == 10 || bd[1] == 12) {
			cal += (31 - bd[0]) + td[0];
			System.out.println("x");
		} else if ((bd[1] == 2)&&(leapyr == true)){
			cal += (29 - bd[0]) + td[0];	
			System.out.println("y");
		}else if ((bd[1] == 2)&&(leapyr == false)){
			cal += (28 - bd[0]) + td[0];
			System.out.println("z");
		}else{
			cal += (30 - bd[0]) + td[0];
		}
		System.out.println("\nThe day between " + bd[0] + "/" + bd[1] + "/" + bd[2] + " and \n" + td[0] + "/" + td[1]
				+ "/" + td[2] + " is " + cal + "!");
		yearday = td[2] - bd[2];
		System.out.println("You are " + yearday + " years old!");
	}
}
