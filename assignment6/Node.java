/*
* PRIORITY Node implementation
*
* parent			contains the node parent of the node
* data				contains the char data element of the node
* childL			contains node child left
* childR			contains node child right
*
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