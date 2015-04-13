/*
* Node
*
* parent			contains the node parent of the node
* data				contains the char data element of the node
* childL			contains node child left
* childR			contains node child right
*
* Node				lone constructor which requires all element to be filled
* isLeaf			checks if the node is a leaf (not an operator)
*/
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
		return (data >= '0' && data <= '9' || Character.isLetter(data));
	}
	
}