public class assignment2{
	public static class PhoneNumber
	{
		private int countryCode = 43;
		private int areaCode = 800;
		private int number = 8675309;
		private char type = 'H';
		private int year;

		public void PhoneNumber(){}
		public void PhoneNumber(int ccode, int acode, int num, char type, int year){}
		public void PhoneNumber(int num, char type){}
		public void PhoneNumber(int acode, int num, char type){}
		public void setCountry(int ccode){countryCode = ccode;}
		public void setArea(int acode){areaCode = acode;}
		public void setNumber(int number){this.number = number;}
		public void setType(char type){this.type = type;}
		public void setYear(int yr){year = yr;}
		public int getCountry(){return countryCode;}
		public int getArea(){return areaCode;}
		public int getNumber(){return number;}
		public char getType(){return type;}
		public int getYear(){return year;}
		// double digits ?
		public boolean doubleDigits(){return true;}
		// print number 
		public void printNumber(){System.out.println(areaCode); System.out.println(number);}
		// print number stats 
		public void printPhoneNumberStats(){}
	}

	public static void main(String[]args)
	{
		PhoneNumber jeff = new PhoneNumber();
		jeff.setNumber(98);
		System.out.println(jeff.getNumber());
	}
}