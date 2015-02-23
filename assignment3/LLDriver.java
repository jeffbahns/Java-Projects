import java.util.Scanner;

// driver class
public class LLDriver{

	// method that converts a [string] number into a linked list of ints
	public static DoublyLinkedList convertToList(String n){
		DoublyLinkedList intlist = new DoublyLinkedList();
		
		// this loop takes every index of the number [stored as a list],
		// and converts it into an integer. then it throws it on the list
		for (int i = n.length()-1; i >= 0; i--){
			int digit = n.charAt(i)-48;
			intlist.insertHead(digit);
		}
		return intlist;
	}
	
	// takes two double linked lists as input
	// and adds their integer contents
	// returns result as double linked list
	public static DoublyLinkedList listSum(DoublyLinkedList a, DoublyLinkedList b){
		
		DoublyLinkedList result = new DoublyLinkedList();
		
		// the sum is the variable added to the list every loop cycle
		// carry is carried over every cycle to determine next link
		int carry = 0;
		int sum = 0;

		// while loop runs until both linked lists are null,
		// and there is nothing left to carry over
		while (a.tail != null || b.tail != null || carry != 0){

			// each if block determines what is being added to sum,
			// depending on what lists are null, and if there is still
			// something to carry over
			if (a.tail != null && b.tail != null){
				sum = carry + a.tail.data + b.tail.data;
				a.deleteTail();
				b.deleteTail();
			}

			else if (a.tail != null && b.tail == null){
				sum = carry + a.tail.data;
				a.deleteTail();
			}

			else if (a.tail == null && b.tail != null){
				sum = carry + b.tail.data;
				b.deleteTail();
			}

			else{
				sum = carry;
			}
			//////////////////////////////////////////////////

			// if sum >= 10, then the carry over is established
			// and the sum is extracted
			if (sum >= 10){
				carry = sum / 10;
				sum %= 10;
			}
			
			// else, carry is 0
			else{
				carry = 0;
			}

			result.insertHead(sum);
		}

		result.printStr();
		return a;
	}

	// main, which runs the program and executes all methods
	public static void main(String[]args){
		
		// scanner takes both inputs and stores them as strings
		// indexing is much easier for splitting digits into nodes
		Scanner s = new Scanner(System.in);
		System.out.println("Input first number");
		String in1 = s.next();
		System.out.println("Input second number");
		String in2 = s.next();

		DoublyLinkedList num1 = convertToList(in1);
		DoublyLinkedList num2 = convertToList(in2);
		System.out.println("___________");
		listSum(num1,num2);
	}
}