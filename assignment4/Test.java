class Test {
	
	public static void main(String[]args){

		Deque d = new Deque();

		d.enqueueFront(2, 100);
		d.enqueueFront(3, 108);
		d.enqueueFront(4, 100);
		d.printDeque();
		d.dequeueFront();
		d.dequeueFront();
		d.printDeque();
		//System.out.println(d.peekFront());
		//System.out.println(d.peekBack());
		//System.out.println(d.peekFront().next);
		//System.out.println(d.peekBack().next);
		//System.out.println(d.peekFront().prev);
		//System.out.println(d.peekBack().prev);
	}
}