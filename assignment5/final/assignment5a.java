// jeff bahns
// danny thompson
import java.util.Scanner;
class assignment5a
{
   /*
    * method main controls program flow
    *
    * s				scanner input variable
    * inputExpr.	carries the input expression from keyboard input
    * exprTree		carries the binaryTree resulted from keyboard input
    */
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		String inputExpression = "";
		while (!inputExpression.equals(" ")){
			inputExpression = s.nextLine();
			BinaryTree expressionTree = expressionTreeBuilder(inputExpression);
			expressionTree.inOrder(null);
			System.out.println(expressionTree.infixString);
		}
	}

   /*
    * method expressionTreeBuilder creates an inorder tree from string expression
    *
    * token			each char of the string broken off and added to the tree
    */
	public static BinaryTree expressionTreeBuilder(String inputStr) {
		
		BinaryTree infixTree = new BinaryTree(' ', null, null);

		// loops through each char of the input string
		// all actions are pre-made methods of BinaryTree
		// they just have to be called in precise order
		for (int i = 0; i < inputStr.length(); i++){
			char token = inputStr.charAt(i);
			if (infixTree.focusNode == null)
				infixTree.focusNode = infixTree.root;

			if (token == '(')
				infixTree.descendLeft();

			else if (token == '+' || token == '-' || token == '*' || token == '/' || token == '^'){
				if (!(infixTree.focusNode.data == ' ')){
					infixTree.ascendParent();
				}
					infixTree.setFocus(token);
					infixTree.descendRight();
			}

			else if (token >= '0' && token <= '9' || Character.isLetter(token)){
				infixTree.setFocus(token);
				infixTree.ascendParent();
			}

			else if (token == ')'){
				infixTree.ascendParent();
			}

			else if (token == ' '){
			}
		}
		return infixTree;
	}

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
	static class BinaryTree {
		
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
	static class Node {
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
}