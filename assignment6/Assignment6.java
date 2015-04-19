import java.util.Scanner;
class Assignment6 {

	public static void main(String[]args) {
		PriorityQueue j = new PriorityQueue();
		j.insert(5, "Jeff", 3);
		j.insert(2, "Jeff", 2);
		
		jobScheduler(j);
	}

	public static void jobScheduler(PriorityQueue pqueue) {
		Scanner s = new Scanner(System.in);
		Node currentJob = null;
		String input = "";
		int cycles = 1;
		while (!input.equals("done")){
			
			if (currentJob == null){
				currentJob = pqueue.removeMin();
			}
			
			if (currentJob.length == 0){
				currentJob = null;
			}

			else if (currentJob.length > 0){

				System.out.println(currentJob.length);
				currentJob.length--;
			}
			else {
				System.out.println("DOING NOTHING");
			}
			
			System.out.println("CYCLE " + cycles);
			input = s.nextLine();
			cycles++;
		}
	}


}