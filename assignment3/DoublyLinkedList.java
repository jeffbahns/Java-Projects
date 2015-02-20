class DoublyLinkedList{
	public Node head;
	public Node tail;

	public DoublyLinkedList(){
		head = null;
		tail = null;
	}
	
	public boolean isEmpty(){
		return (head == null);
	}

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
	}

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
	}

	public String listString(){
		String str = "LIST : \n  ";
		Node current = head;
		while (current != null){
			str += current.next.toString();
			current = current.next;
		}
		return str;
	}
	
	public void printStr(){
		//System.out.println(head.data);
		Node current = head;
		while (current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}
}