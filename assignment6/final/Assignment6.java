/* Assignment 6, implement CPU Job Scheduler using priority queue
 *	Jeff Bahns
 *	Danny Thompson
 */

import java.util.Scanner;

class Assignment6 {

	public static void main(String[]args) {
		PriorityQueue test = new PriorityQueue();	
		jobScheduler(test);
	}
	
   /*
    * method jobScheduler
    *
    * pqueue		priority queue, delivered from method argument
    * s				scanner object, takes input
    * currentJob	current job (node) being handled
    * userInput		string var receiving input
    * tokens		string array that carries the split input
    */
	public static void jobScheduler(PriorityQueue pqueue) {
		Scanner s = new Scanner(System.in);
		Node currentJob = null;
		String userInput = " ";
		System.out.println("\n\nWELCOME TO CPU JOB SCHEDULER");
		System.out.print("ENTER COMMANDS IN THE FORM OF:\n>>  ");
		System.out.println("\"add job name with length n and priority p\", OR,");
		System.out.println(">>  \"no new jobs this slice\"");

		// runs the task handler until keyword: "done" is typed
		while (!userInput.equals("done")){
			System.out.println("* - - - - - - - - - - - - - *");
			if (currentJob == null){
				currentJob = pqueue.removeMin();
			}
			if (currentJob != null){
				if (currentJob.length > 0){
					System.out.println("| RUNNING JOB: " + currentJob.job);
					currentJob.length--;
					if (currentJob.length == 0){
					currentJob = null;
					}
				}
			}

			// this code block parses input and inserts
			// it into the priority queue 
			// sends error if any of the fiels out of project bounds
			System.out.print("| ");
			userInput = s.nextLine();
			if (!userInput.equals("")){
				if (userInput.equals("no new jobs this slice"))
					System.out.print("");
				else if (userInput.equals("done"))
					System.out.print("");
				else{
					String[] tokens = userInput.split(" ");
					int priority = Integer.parseInt(tokens[8]);
					String jobName = tokens[2];
					int length = Integer.parseInt(tokens[5]);

					if (priority > 19 || priority < -20 || length > 100 || length < 0)
						System.out.println("| One of the job fields was out of bound");
					else
						pqueue.insert(priority, jobName, length);
				}
			}
		}
	}

   /*
	* class PriorityQueue (sorted version)
	*	hybrid singly linked lsit, also
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
	static class PriorityQueue {
		
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

   /*
	* class Node
	* 	PRIORITY Node implementation
	*
	* key				integer that carries the key (priority number)
	* job				string that carries name of the job
	* length			integer that carries length of job
	* next				points to next node in chain
	*
	* Node				sole constructor, requires all vars besides "next"
	*/
	static class Node {
		int key;
		String job;
		int length;
		Node next;

		public Node(int key, String job, int length){
			this.key = key;
			this.job = job;
			this.length = length;
		}
	}
}