// straightforward deque
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
	
	// returns true if deque empty
	public boolean isEmpty(){
		return (front == null);
	}

	// returns front of deque if existent
	public Node peekFront(){
		if (front == null){
			return null;
		}
		return front;
	}

	// returns back of deque if existent
	public Node peekBack(){
		if (back == null){
			return null;
		}
		return back;
	}

	// enqueues new node to the front of deque
	public void enqueueFront(int price, int amount){
		Node newTrade = new Node(price, amount);
		newTrade.next = front;
		if (isEmpty())
			back = newTrade;
		else
			front.prev = newTrade;
		front = newTrade;

	}
	
	// enqueues new node to the back of deque
	public void enqueueBack(int price, int amount){
		Node newTrade = new Node(price, amount);
		newTrade.prev = back;
		if (isEmpty())
			front = newTrade;
		else
			back.next = newTrade;
		back = newTrade;
	}

	// dequeues node from the front of deque
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

	// dequeues node from the back of deque
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

	// prints a formatted version of the deque
	// showing the stocks on the deque 
	// including share amounts and prices
	public void printDeque(){
		Node current = front;
		System.out.println("________________________");
		if (isEmpty()){
			System.out.println("No Stocks remain");
		}
		else{
			System.out.println("--- Remaining stocks ---");

			while (current != null){
				System.out.println("$" + String.valueOf(current.price) + " " + String.valueOf(current.amount) + " shares.");
				current = current.next;
			}
		}
		System.out.println("________________________");
	}
}