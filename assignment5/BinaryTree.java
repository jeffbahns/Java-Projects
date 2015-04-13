class BinaryTree {
	
	Node root = new Node(null, ' ', null, null);
	Node focusNode;
	String infixString = "";
	String infixStringalt = "";
	
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
	
	// ascends to the parent of the focusNode
	// if it has no parent (it is root), the tree
	// structure is modified
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

	// checks if a specified node is a left child
	public boolean isChildL(Node node){
		if (node.parent != null)
			return (node == node.parent.childL);
		return false;
	}

	// checks if a specified node is a right child
	public boolean isChildR(Node node){
		if (node.parent != null)
			return (node == node.parent.childR);
		return false;
	}

	// prints the contents of the tree inorder, 
	// correctly parenthesized
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