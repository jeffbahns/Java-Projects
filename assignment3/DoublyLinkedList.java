// standard doubly linked list with some bells and whistles
public class DoublyLinkedList{
	
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