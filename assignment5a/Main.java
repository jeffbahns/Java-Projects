import java.util.Scanner;
class Main {

	public static void main(String[]args) {

		Scanner s = new Scanner(System.in);
		String infix = s.next();
		System.out.println(infix);

		for (int i = 0; i < infix.length(); i++)
			System.out.println(infix.charAt(i));

		
		
	}
}