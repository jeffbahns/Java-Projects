import java.util.Scanner;
class MainB {
	
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		String inputExpression = "";
		while (!inputExpression.equals(" ")){
			inputExpression = s.nextLine();
			BinaryTree tree = binaryInfixTreeBuilder(inputExpression);
			tree.inOrder(null);
			System.out.println("DIFFERENTIATION OF " + tree.infixString + ":");
			System.out.println(diff(tree));

		}
	}

	// takes a infix expression string as input
	// returns a binary tree that corresponds to original expression
	public static BinaryTree binaryInfixTreeBuilder(String infixStr) {

		BinaryTree infixTree = new BinaryTree(' ', null, null);
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

	public static String diff(BinaryTree inputTree){

		Node current = inputTree.root;

		if (current.data == ' ')
			current = current.childL;

		if (current.isLeaf() && Character.toLowerCase(current.data) != 'x')
			return "0";

		else if (current.isLeaf() && Character.toLowerCase(current.data) == 'x')
			return "1";
		
		BinaryTree left = new BinaryTree(current.childL.data, current.childL.childL, current.childL.childR);
		BinaryTree right = new BinaryTree(current.childR.data, current.childR.childL, current.childR.childR);
		left.inOrder(null);
		right.inOrder(null);	
		String leftS = left.infixString;
		String rightS = right.infixString;

		if (current.data == '+')
			return "(" + diff(left) + " + " + diff(right) + ")";

		else if (current.data == '-')
			return diff(left) + " - " + diff(right);

		else if (current.data == '*')
			return "((" + leftS + " * " + diff(right) + ") + (" + diff(left) + " * " + rightS + ")"; 

		else if (current.data == '/')
			return "( ( " + rightS + " * " + diff(left) + ") - (" + leftS + " * " + diff(right) + ")) / (" + rightS + " ^ 2)";

		else if (current.data == '^')
			return rightS + " * (" + leftS + " ^ (" + rightS + " - 1)) * " + diff(left);

		return "";
	}

}