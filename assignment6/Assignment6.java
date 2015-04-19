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
			System.out.print("| ");
			userInput = s.nextLine();
			if (!userInput.equals("")){
				String[] tokens = userInput.split(" ");
				int priority = Integer.parseInt(tokens[8]);
				String jobName = tokens[2];
				int length = Integer.parseInt(tokens[5]);
				pqueue.insert(priority, jobName, length);
			}
		}
	}

}