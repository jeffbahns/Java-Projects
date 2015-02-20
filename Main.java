import java.util.Scanner;

class Main{

	// main drives the program, asks the user for input, and creates the object
	public static void main(String[]args){

    	// creates scanner object, to take input
    	Scanner s = new Scanner(System.in);

    	// these are a series of print statements asking for input,
    	// and scanner reads that store the user input
    	System.out.println("READY for a Phone Number entry? Enter 0 at any time for no entry");
    	System.out.println("Enter Country Code:");
    	int cc = s.nextInt();
		System.out.println("Enter Area Code:");
		int ac = s.nextInt();
		System.out.println("Enter 7 Digit Phone Number:");
		int pnum = s.nextInt();
		System.out.println("Enter Type (H, C, or B)");
		String typ = s.next();
		char type = typ.charAt(0);
		System.out.println("Enter Year:");
		int yr = s.nextInt();
		
		// once all necessary input is collected, it creates an object with given traits
		// using one of the 4 constructors that fits its' needs
		// and preforms different methods of that object
		if (cc != 0 && ac != 0 && pnum != 0 && type != '0' && yr != 0){
			PhoneNumber newPhone = new PhoneNumber(cc, ac, pnum, type, yr);
			newPhone.printNumber();
			newPhone.printPhoneNumberStats();
			newPhone.doubleDigits();
		}
		else if (cc == 0 && ac != 0 && pnum != 0 && type != '0' && yr == 0){
			PhoneNumber newPhone = new PhoneNumber(ac, pnum, type);
			newPhone.printNumber();
			newPhone.printPhoneNumberStats();
			newPhone.doubleDigits();
		}
		else if (cc == 0 && ac == 0 && pnum != 0 && type != '0' && yr == 0){
			PhoneNumber newPhone = new PhoneNumber(pnum, type);
			newPhone.printNumber();
			newPhone.printPhoneNumberStats();
			newPhone.doubleDigits();
		}
		else{
			PhoneNumber newPhone = new PhoneNumber();
			newPhone.printNumber();
			newPhone.printPhoneNumberStats();
			newPhone.doubleDigits();
		}
    }
}