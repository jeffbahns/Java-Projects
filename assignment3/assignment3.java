import java.util.Scanner;

public class assignment3 {
	
	// standard node class
	public static class Node {
		// three member variables: data, prev, next
		int data;
		Node prev;
		Node next;
		
		// constructor takes one input, data for the node
		public Node(int d){
			data = d;
			
		}
	}

	// standard doubly linked list with some bells and whistles
	public static class DoublyLinkedList{
		
		// three member variables: head, tail, length
		public Node head;
		public Node tail;
		public int length = 0;
		
		// single constructor initializes list as completely null
		public DoublyLinkedList(){
			head = null;
			tail = null;
		}
		
		// checks if linked list is empty or not
		public boolean isEmpty(){
			return (head == null);
		}
		
		// increments length variable by 1
		public void increment(){
			length++;
		}

		// decrements length variable by 1
		public void decrement(){
			length--;
		}

		// inserts head node onto list and increases length of list
		public void insertHead(int d){
			Node newHead = new Node(d);
			if (isEmpty()){
				tail = newHead;
			}
			else{
				head.prev = newHead;
			}
			newHead.next = head;
			head = newHead;
			increment();
		}

		// inserts tail node onto list and increases length of list
		public void insertTail(int d){
			Node newTail = new Node(d);
			if (isEmpty()){
				head = newTail;
			}
			else{
				tail.next = newTail;
				newTail.prev = tail;
			}
			tail = newTail;
			increment();
		}

		// deletes tail node onto list and decreases length of list
		public void deleteTail(){
			tail = tail.prev;
			decrement();
		}
		
		// prints out the entirety of the linked list
		public void printStr(){
			Node current = head;
			while (current != null){
				System.out.println(current.data);
				current = current.next;
			}
		}
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

			else {
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
			else {
				carry = 0;
			}

			result.insertHead(sum);
		}

		result.printStr();
		return a;
	}
}
