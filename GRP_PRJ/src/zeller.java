
public class zeller {
	
//create a function and to execute
	//method in java but function in c++
	//execute in servlet
	public String cday(String first){
		
		// int q=0,m=0,y=0;
		int i = 0,wrong =0;

		// this is an alternative way (better) to do the part 1 with array and split the input
//part 1
		String error = "The date you have entered is not correct. Please try again.";
		String date = "";
		int data[] = new int[3]; // HTML DoPost()<-- Servlet
		
			try {

				date = first;

				String dta[] = date.split("/", 3);

				for (i = 0; i < 3; i++) {
					data[i] = Integer.parseInt(dta[i]);

				}
				if ((data[2]<1500)||(data[2]>2500)){
					wrong=1;
				}
				if ((data[1] < 1) || (data[1] > 12)) {
					wrong=1;
					//} else if (( (data[2] > 2100)) {
					//System.out.println("Please enter a valid date!");
				}
				switch (data[1]){
				default:
					wrong=1;
				case 1:case 3: case 5: case 7: case 8: case 10:case 12:
				{
					if ((data[0] < 1) || (data[0] > 31)) {
						wrong=1;
					}
					break;
				}
				case 4:case 6:case 9:case 11:
				{
					if ((data[0] < 1) || (data[0] > 30)) {
						wrong=1;
					}
			
					break;
				}	
				case 2:
				{
					if (!(((data[2] % 4 == 0) && !(data[2] % 100 == 0))||(data[2] % 400 == 0)) && ((data[0] < 1) ||(data[0] >= 29))) {
						wrong=1;

					} else if ((((data[2] % 4 == 0) && !(data[2] % 100 == 0))||(data[2] % 400 == 0)) && ((data[0] < 1) ||(data[0] > 29))) {
						wrong=1;
					}
					break;
				}
				}//switch end
			} catch (Exception e) {
				wrong=1;
			}
		
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
		String result= "";
		switch (h) {
		case 0: {
			result = (date + " is a Saturday!");
			break;
		}
		case 1: {
			result = (date + " is a Sunday!");
			break;
		}
		case 2: {
			result = (date + " is a Monday!");
			break;
		}
		case 3: {
			result = (date + " is a Tuesday!");
			break;
		}
		case 4: {
			result = (date + " is a Wednesday!");
			break;
		}
		case 5: {
			result = (date + " is a Thursday!");
			break;
		}
		case 6: {
			result = (date + " is a Friday!");
			break;
		}
		}
		if (wrong==1){
			return error;
		}
		else{
			return result;
		}
		// return result to servlet
		// string can be declared with braclet ()
	}

	
	
//part 2
	public String part2(String second,String third){
		String error = "The date you have entered is not correct. Please try again.";
		int i = 0, yearday = 0, cal = 0, day = 0,wrong =0;

	    
		int bd[] = new int[3];
		// day
		String birthday = "0"; // HTML DoPost()<-- Servlet
		
			try {
				birthday = second;

				String bday[] = birthday.split("/", 3);

				for (i = 0; i < 3; i++) {
					bd[i] = Integer.parseInt(bday[i]);
				}
				if ((bd[2]<1500)||(bd[2]>2500)){
					wrong=1;
				}
				if ((bd[1] < 1) || (bd[1] > 12)) {
					wrong=1;
					//} else if ((bd[2] < 1900) || (bd[2] > 2100)) {
					//System.out.println("Please enter a valid date!");
				}
				switch (bd[1]){
				default:
					wrong=1;
				case 1:case 3: case 5: case 7: case 8: case 10:case 12:
				{
					if ((bd[0] < 1) || (bd[0] > 31)) {
						wrong=1;
					}
			
					break;
				}
				case 4:case 6:case 9:case 11:
				{
					if ((bd[0] < 1) || (bd[0] > 30)) {
						wrong=1;
					}
				
					break;
				}	
				case 2:
				{
					if (!(((bd[2] % 4 == 0) && !(bd[2] % 100 == 0))||(bd[2] % 400 == 0)) && ((bd[0] < 1) ||(bd[0] >= 29))) {
						wrong=1;

					} else if ((((bd[2] % 4 == 0) && !(bd[2] % 100 == 0))||(bd[2] % 400 == 0)) && ((bd[0] < 1) ||(bd[0] > 29))) {
						wrong=1;
					}
					break;
				}
				}//switch end
			} catch (Exception e) {
				wrong=1;
			}
		

		String today = "";
		
		int td[] = new int[3];
		// today
		
			try {
				today = third;

				String current[] = today.split("/", 3);

				for (i = 0; i < 3; i++) {
					td[i] = Integer.parseInt(current[i]);
				}
				if ((td[2]<1500)||(td[2]>2500)){
					wrong=1;
				}

				if ((td[1] < 1) || (td[1] > 12)) {
					wrong=1;
					//} else if ((td[2] < 1900) || (td[2] > 2100)) {
					//wrong=1;
				}
				switch (td[1]){
				default:
					wrong=1;
				case 1:case 3: case 5: case 7: case 8: case 10:case 12:
				{
					if ((td[0] < 1) || (td[0] > 31)) {
						wrong=1;
					}
					
					break;
				}
				case 4:case 6:case 9:case 11:
				{
					if ((td[0] < 1) || (td[0] > 30)) {
						wrong=1;
					}
					
					break;
				}	
				case 2:
				{
					if (!(((td[2] % 4 == 0) && !(td[2] % 100 == 0))||(td[2] % 400 == 0)) && ((td[0] < 1) ||(td[0] >= 29))) {
						wrong=1;

					} else if ((((td[2] % 4 == 0) && !(td[2] % 100 == 0))||(td[2] % 400 == 0)) && ((td[0] < 1) ||(td[0] > 29))) {
						wrong=1;
					}
					break;
				}
				}//switch end
			} catch (Exception e) {
				wrong=1;
			}
		boolean leapyr = false;

		// real start of while(age) // what if it is not age?(delete while(age)
		// and use
		/*
		 * if (td[2]>bd[2]){ age=false; } else if
		 * ((td[2]==bd[2])&&(td[1]>bd[1])){ age=false; } else if
		 * ((td[2]==bd[2])&&(td[1]==bd[1])&&(td[0]>bd[0])){ age=false; } else {

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
			
		} else if ((bd[1] == 2)&&(leapyr == true)){
			cal += (29 - bd[0]) + td[0];	
			
		}else if ((bd[1] == 2)&&(leapyr == false)){
			cal += (28 - bd[0]) + td[0];
			
		}else{
			cal += (30 - bd[0]) + td[0];
		}
		String result1 = ("\nThe day between " + bd[0] + "/" + bd[1] + "/" + bd[2] + " and \n" + td[0] + "/" + td[1]
				+ "/" + td[2] + " is " + cal + "!");
		if (wrong==1){
			return error;
		}
		else{
			return result1;
		}
	}
	
}
