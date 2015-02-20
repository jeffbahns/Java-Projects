import java.util.Scanner;
public class LLDriver{

	public static DoublyLinkedList convertToList(String n){
		DoublyLinkedList intlist = new DoublyLinkedList();
		for (int i = n.length()-1; i >= 0; i--){
			int digit = n.charAt(i)-48;
			intlist.insertHead(digit);
		}
		return intlist;
	}
	
	public static DoublyLinkedList listSum(DoublyLinkedList a, DoublyLinkedList b){
		
		DoublyLinkedList result = new DoublyLinkedList();
		int carry_over = 0;
		while (a.tail != null || b.tail != null){
			if (a.tail != null && b.tail != null){
				int sum = a.tail.data + b.tail.data + carry_over;
				if (sum >= 10){
					sum += carry_over;
					carry_over = sum / 10;
					sum -= 10;
					result.insertHead(sum);
				}
				else{
					result.insertHead(sum + carry_over);
				}
				a.tail = a.tail.prev;
				b.tail = b.tail.prev;
			}
			else if (a.tail != null && b.tail == null){
				result.insertHead(a.tail.data);
				a.tail = a.tail.prev;
			}
			else if (a.tail == null && b.tail != null){
				result.insertHead(b.tail.data);
				b.tail = b.tail.prev;
			}
		}

		result.printStr();

		return a;
	}

	public static void main(String[]args){
		DoublyLinkedList j = new DoublyLinkedList();
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