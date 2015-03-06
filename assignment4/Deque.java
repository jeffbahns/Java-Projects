class Deque{

	// three member variables
	public Node front;
	public Node back;
	public int length = 0;
	
	// constructor which creates an empty deque
	public Deque(){
		front = null;
		back = null;
	}
	
	public boolean isEmpty(){
		return (front == null);
	}
	public Node peekFront(){
		if (front == null){
			return null;
		}
		return front;
	}

	public Node peekBack(){
		if (back == null){
			return null;
		}
		return back;
	}

	public void enqueueFront(int price, int amount){
		Node newTrade = new Node(price, amount);
		newTrade.next = front;
		if (isEmpty())
			back = newTrade;
		else
			front.prev = newTrade;
		front = newTrade;

	}
	
	public void enqueueBack(int price, int amount){
		Node newTrade = new Node(price, amount);
		newTrade.prev = back;
		if (isEmpty())
			front = newTrade;
		else
			back.next = newTrade;
		back = newTrade;
	}

	public void dequeueFront(){
		if (isEmpty())
			System.out.println("This deque is empty");
		else{
			front = front.next;
			if (front != null)
				front.prev = null;
			else
				back = front;
		}
	}

	public void dequeueBack(){
		if (isEmpty())
			System.out.println("This deque is empty");
		else{
			back = back.prev;
			if (back != null)
				back.next = null;
			else
				front = back;
		}
	}

	public void printDeque(){
		Node current = front;
		while (current != null){
			System.out.println("$" + String.valueOf(current.price) + " " + String.valueOf(current.amount) + " shares.");
			current = current.next;
		}
		System.out.println("-------");
	}
}