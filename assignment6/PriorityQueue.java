
class PriorityQueue {
	
	public Node min;
	public Node max;
	public int length = 0;

	public PriorityQueue(){
		min = null;
		max = null;
	}

	public void insert(int key, String job, int length){
		Node newNode = new Node(key, job, length);
		if (isEmpty()){
			min = newNode;
			max = min;
		}

		else{
			Node current = min;
			
			if (current.key >= key){
				newNode.next = current;
				min = newNode;
			}
			else{
				while (current.next != null && current.next.key <= key){
					current = current.next;
				}
				newNode.next = current.next;
				current.next = newNode;
			}		
		}
		increment();
	}

	public Node removeMin(){
		if (isEmpty()){
			return null;
		}
		else{
			Node temp = min;
			min = min.next;
			decrement();
			return temp;
		}
	}

	public boolean isEmpty(){
		return (min == null);
	}

	public void increment(){
		length++;
	}

	public void decrement(){
		length--;
	}

	
	// prints out the entirety of the linked list
	public void printStr(){
		String output = "";
		Node current = min;
		while (current != null){
			output += current.job;
			current = current.next;
		}
		System.out.println(output);
	}

}