class BinaryTree {
	
	Node root = new Node(null, ' ', null, null);
	Node focusNode;
	String infixString = "";

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(char rootItem) {
		root = new Node(null, rootItem, null, null);
	}
	
	// descends into left child of focusNode
	// creates empty node if there isn't one initalized
	public void descendLeft() {
		if (focusNode.childL == null){
			Node newNode = new Node(focusNode, ' ', null, null);
			focusNode.childL = newNode;
		}
		focusNode = focusNode.childL;
	}

	// descends into right child of focusNode
	// creates empty node if there isn't one initalized
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

	// sets the current focusNode's data element
	public void setFocus(char token) {
		focusNode.data = token;
	}

	// token is what is stored within the BinaryTree
	// destination decides where node is going
	public void addNode(char token) {

		if (focusNode == null)
			focusNode = root;
	}

	public void inOrder(Node node) {
		Node current;
		if (node == null)
			node = root;
		current = node;

		if (current.childL != null)
			inOrder(current.childL);
		infixString += current.data;

		if (current.childR != null)
			inOrder(current.childR);
	}

}