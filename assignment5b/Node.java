class Node {
	Node parent;
	char data;
	Node childL;
	Node childR;

	public Node(Node p, char d, Node cL, Node cR){
		parent = p;
		data = d;
		childL = cL;
		childR = cR;
	}

	public boolean isLeaf(){
		return (data >= '0' && data <= '9');
	}

	
}