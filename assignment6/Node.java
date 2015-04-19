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
class Node {
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