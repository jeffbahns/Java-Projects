public class Main{
	public static void main(String[]args){
		ListNode v1 = new ListNode();
		ListNode v2 = new ListNode();
		ListNode v3 = new ListNode();

		v1.element = 7;
		v2.element = 0;
		v3.element = 6;

		v1.next = v2;
		v2.next = v3;
		v3.next = null;
	}
}