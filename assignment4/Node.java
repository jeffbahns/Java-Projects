// modified node which contains two elements
class Node{
	
	int price;
	int amount;
	Node prev;
	Node next;

	// stock amount and price are the two elements required for every node
	public Node(int price, int amount){
		this.price = price;
		this.amount = amount;
	}
	
}