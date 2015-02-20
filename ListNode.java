public class ListNode{

	private static class Node {
		private int element;
		private Node next;
		public Node(int e, Node n) {
			element = e;
			next = n;
		}
		public int getElement(){
			return element;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node n){
			next = n;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int size = 0;
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int first(){
		if (isEmpty())
			return 0;
		return head.getElement();
	}
	public int last(){
		if (isEmpty())
			return 0;
		return tail.getElement();
	}
	public void addFirst(int e){
		head = new Node(e, head);
		if (size == 0)
			tail = head;
		size++;
	}
	public void addLast(int e){
		Node newest = new Node(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}


}