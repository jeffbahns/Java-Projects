import java.util.Scanner;

public class PhoneNumber{
    
    // Country code
    private int countryCode = 43;
    
    // Area code
    private int areaCode = 800;
    
    // 7 digit phone number
    private int number = 8675309;
    
    // Type of phone, whether it is 'H'ome, 'C'ell, or 'B'usiness line
    private char type = 'H';
    
    // The year 
    private int year = 1981;

	// - - - Constructors - - - //
	// default constructor:
	// handles objects initialized with no arguments
    public PhoneNumber(){}
	
	// 2nd consctructor - handles objects initalized with maximum arguments
    public PhoneNumber(int ccode, int acode, int num, char type, int year){
        this.countryCode = ccode;
        this.areaCode = acode;
        this.number = num;
        this.type = type;
        this.year = year;
    }

    // 3rd constructor:
    // handles objects initalized with number and type arguments
    public PhoneNumber(int num, char type){
    	this.countryCode = 43;
        this.areaCode = 800;
        this.number  = num;
        this.type = type;
        this.year = 1981;
    }

    // 4th constructor:
    // handles objects initialized with area code, number, and type arguments
    public PhoneNumber(int acode, int num, char type){
		this.countryCode = 43;
        this.areaCode = acode;
        this.number  = num;
        this.type = type;
        this.year = 1981;
    }

    // - - - Setter methods - - - // 
    // sets the country code
    public void setCountry(int ccode)   {this.countryCode = ccode;}

    // sets the sets the area code
    public void setArea(int acode)      {this.areaCode = acode;}

    // sets the phone number
    public void setNumber(int number)   {this.number = number;}

    // sets the type of phone line
    public void setType(char type)      {this.type = type;}

    // sets the year of the phone
    public void setYear(int yr)         {this.year = yr;}
	////////////////////


    // - - - Getter methods - - - //
	// returns the country code
    public int getCountry()             {return this.countryCode;}

    // returns the area code
    public int getArea()                {return this.areaCode;}

    // returns the phone number
    public int getNumber()              {return this.number;}

    // returns the type of phone line it is
    public char getType()               {return this.type;}

	// returns the year of the phone
    public int getYear()                {return this.year;}
	////////////////////


    // returns true if duplicate digits
    public boolean doubleDigits(){
		String strnum = String.valueOf(number);
		boolean decision = false;
		for (int i = 0; i < 7; i++){
			for (int j = i+1; j < 7; j++){
				if (strnum.charAt(i) == strnum.charAt(j)){
					decision = true;
				}
			}
		}
		if (decision){
			System.out.println("HELL YEAH");
		}
		else{
			System.out.println("HELL NO");
		}
		return decision;
    }

    // prints just number and area code itself, returns nothing
    public void printNumber(){
    	String strnum="";
    	strnum += "(" + String.valueOf(areaCode) + ")";
    	strnum += String.valueOf(number).substring(0,3) + "-" + String.valueOf(number).substring(3,7);
    	System.out.println(strnum);
    }
    // prints all number stats about the phonenumber, returns nothing
    public void printPhoneNumberStats(){
    	System.out.println("__________________________________");
    	System.out.println("Phone Number Stats");
    	System.out.println("__________________________________");
    	System.out.println("\nCountry Code:");
    	System.out.println(countryCode);
    	System.out.println("\nArea Code:");
    	System.out.println(areaCode);
    	System.out.println("\nNumber:");
    	System.out.println(number);
    	System.out.println("\nPhone Type:");
    	System.out.println(type);
    	System.out.println("\nYear:");
    	System.out.println(year);
    	System.out.println("__________________________________");
    }

    public static void main(String[]args){
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter Country Code:");
    	int cc = s.nextInt();
		System.out.println("Enter Area Code:");
		int ac = s.nextInt();
		System.out.println("Enter Phone Number:");
		int pnum = s.nextInt();
		System.out.println("Enter Type (H, C, or B):");
		String typ = s.next();
		char type = typ.charAt(0);
		System.out.println("Enter Year:");
		int yr = s.nextInt();

		PhoneNumber jeff = new PhoneNumber(cc, ac, pnum, type, yr);
		jeff.printNumber();
		jeff.printPhoneNumberStats();
		jeff.doubleDigits();
		
    }
}
