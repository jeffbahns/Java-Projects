import java.util.Scanner;
class Assignment6 {

	public static void main(String[]args) {
		PriorityQueue j = new PriorityQueue();
		
		jobScheduler(j);
	}

	public static void jobScheduler(PriorityQueue pqueue) {
		Scanner s = new Scanner(System.in);
		Node currentJob = null;
		String input = " ";
		while (!input.equals("done")){
			System.out.println("* - - - - - - - - - - - - - *");
			if (currentJob == null){
				currentJob = pqueue.removeMin();
			}
			if (currentJob != null){
				if (currentJob.length > 0){
					System.out.println("| RUNNING JOB: " + currentJob.job);
					currentJob.length--;
				}
				if (currentJob.length == 0){
					currentJob = null;
				}
			}
			System.out.print("| ");
			input = s.nextLine();
			if (!input.equals("")){
				String[] tokens = input.split(" ");
				int priority = Integer.parseInt(tokens[8]);
				String jobName = tokens[2];
				int length = Integer.parseInt(tokens[5]);
				pqueue.insert(priority, jobName, length);
			}
			if (currentJob == null && pqueue.isEmpty())
				System.out.println("| Awaiting jobs...");
			System.out.println("* - - - - - - - - - - - - - *");
		}
	}


}