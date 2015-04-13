/*
* Binary Tree
*
* root				node that is root, highest point of tree
* focusNode			node that is currently in focusNode
* infixString		string that contains result of inOrder print routine
* 
* BinaryTree		2 constructors, handle 2 different cases
* descendLeft		descends to left child
* descendRight		descends to right child
* ascendParent		ascends to parent, creates parent if doesn't exist
* setFocus			sets the data element of the node in focusNode
* isChildL			returns true if node is a left child
* isChildR			returns true if node is a right child
* inOrder			recursively traverses the tree inOrder
*/
class BinaryTree {
	
	Node root = new Node(null, ' ', null, null);
	Node focusNode;
	String infixString = "";
	
	public BinaryTree() {
		root = null;
	}

	public BinaryTree(char rootItem, Node childL, Node childR) {
		root = new Node(null, rootItem, childL, childR);
	}

	public void descendLeft() {
		if (focusNode.childL == null){
			Node newNode = new Node(focusNode, ' ', null, null);
			focusNode.childL = newNode;
		}
		focusNode = focusNode.childL;
	}

	public void descendRight() {
		if (focusNode.childR == null){
			Node newNode = new Node(focusNode, ' ', null, null);
			focusNode.childR = newNode;
		}
		focusNode = focusNode.childR;
	}

	public void ascendParent() {
		if (focusNode.parent == null){
			Node newNode = new Node(null, ' ', focusNode, null);
			focusNode.parent = newNode;
			root = focusNode.parent;
		}
		focusNode = focusNode.parent;
	}

	public void setFocus(char token) {
		focusNode.data = token;
	}

	public boolean isChildL(Node node){
		if (node.parent != null)
			return (node == node.parent.childL);
		return false;
	}

	public boolean isChildR(Node node){
		if (node.parent != null)
			return (node == node.parent.childR);
		return false;
	}

	public void inOrder(Node node) {
		Node current;
		if (node == null)
			node = root;
		current = node;
		if (current.childL != null)
			inOrder(current.childL);
		if (current.isLeaf() && isChildL(current) && current.parent.childR != null){
				if (current.parent.childR.isLeaf())
					infixString += "(";
		}
		infixString += current.data;
		if (current.isLeaf() && isChildR(current) && current.parent.childL != null){
				if (current.parent.childL.isLeaf())
					infixString += ")";
		}
		if (current.childR != null)
			inOrder(current.childR);
	}

}