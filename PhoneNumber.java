/**
 * Created by jeffbahns on 1/31/15.
 */
// Jeff Bahns

// The "PhoneNumber" class takes telephone number info
//  it stores all this info and formats/prints on screen.


public class PhoneNumber
{
    // Country code
    private int countryCode = 43;
    // Area code
    private int areaCode = 800;
    // 7 digit phone number
    private int number = 8675309;
    // Type of phone, whether it is 'H'ome, 'C'ell, or 'B'usiness line
    private char type = 'H';
    private int year = 1981;

    public void PhoneNumber(){}
    public void PhoneNumber(int ccode, int acode, int num, char type, int year)
    {

    }
    public void PhoneNumber(int num, char type){}
    public void PhoneNumber(int acode, int num, char type){}


    // Setter methods
    public void setCountry(int ccode)   {this.countryCode = ccode;}
    public void setArea(int acode)      {this.areaCode = acode;}
    public void setNumber(int number)   {this.number = number;}
    public void setType(char type)      {this.type = type;}
    public void setYear(int yr)         {this.year = yr;}

    // Getter methods
    public int getCountry()             {return this.countryCode;}
    public int getArea()                {return this.areaCode;}
    public int getNumber()              {return this.number;}
    public char getType()               {return this.type;}
    public int getYear()                {return this.year;}

    // double digits ?
    public boolean doubleDigits(){return true;}

    // print number
    public void printNumber(){System.out.println(areaCode); System.out.println(number);}

    // print number stats
    public void printPhoneNumberStats(){}
}
