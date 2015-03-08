class Test {c
	
	public static void main(String[]args){

		Deque d = new Deque();

		d.enqueueBack(10, 10);
		d.back.amount -= 11;
		System.out.println(d.back.amount);
	}
}