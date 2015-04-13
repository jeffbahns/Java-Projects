import java.util.Scanner;
class MainB {

	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		String inputExpression = "";
		while (!inputExpression.equals(" ")){
			inputExpression = s.nextLine();
			BinaryTree tree = binaryInfixTreeBuilder(inputExpression);
			diff(tree);
		}

		

	}

	// takes a infix expression string as input
	// returns a binary tree that corresponds to original expression
	public static BinaryTree binaryInfixTreeBuilder(String infixStr) {
		
		BinaryTree infixTree = new BinaryTree(' ');
		for (int i = 0; i < infixStr.length(); i++){
			char token = infixStr.charAt(i);
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

			else if (token >= '0' && token <= '9'){
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

	public static String diff(BinaryTree inputTree){
		inputTree.inOrder(null);
		System.out.println(inputTree.infixString);
		
		Node current;
		Node node = null;
		if (node == null)
			node = inputTree.root;
		current = node;

		if (current.childL != null)
			inputTree.inOrder(current.childL);

		inputTree.infixString += current.data;	

		if (current.childR != null)
			inputTree.inOrder(current.childR);

		return "";
	}

}