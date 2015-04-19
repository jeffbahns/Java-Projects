/*
* class PriorityQueue (sorted version)
*
* min				minimum node, AKA highest priority
* length			length of priority queue
*
* PriorityQueue		sole constructor, sets queue to empty/null
* insert			inserts node in correct order in queue
* removeMin			removes and returns highest priority node
* isEmpty			checks if queue is empty
* increment			increases length by 1
* decrement			decreases length by 0
* printStr			prints all the job names on the queue		
*/
class PriorityQueue {
	
	public Node min;
	public int length = 0;

	public PriorityQueue(){
		min = null;
	}

	public void insert(int key, String job, int length){
		Node newNode = new Node(key, job, length);
		if (isEmpty()){
			min = newNode;
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