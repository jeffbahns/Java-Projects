import java.util.Scanner;
class MainB {
	
   /*
    * method main controls program flow
    *
    * s				scanner input variable
    * inputExpr.	carries the input expression from keyboard input
    * exprTree		carries the binaryTree resulted from keyboard input
    */
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		String inputExpression = " ";
		System.out.println();
		while (!inputExpression.equals("")){
			inputExpression = s.nextLine();
			if (!inputExpression.equals("")){
				BinaryTree expressionTree = expressionTreeBuilder(inputExpression);
				expressionTree.inOrder(null);
				System.out.println("DIFFERENTIATION OF " + expressionTree.infixString + ":");
				System.out.println(diff(expressionTree));
			}
		}
	}

   /*
    * method expressionTreeBuilder creates an inorder tree from string expression
    *
    * token			each char of the string broken off and added to the tree
    */
	public static BinaryTree expressionTreeBuilder(String inputStr) {

		BinaryTree infixTree = new BinaryTree(' ', null, null);
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
    * method diff differentiated a correctly parenthesized expression 
    * 
    * current		the root of the current tree
    * left			the subtree comprised of the left child and its' children
    * right			the subtree comprised of the right child and its' children
    * leftS			the left subtree in string format
    * rightS		the right subtree in string format
    */
	public static String diff(BinaryTree inputTree){
		
		// the root node is what decides any action
		Node current = inputTree.root;

		if (current.data == ' ')
			current = current.childL;

		// the two base cases, return '0' and '1'
		if (current.isLeaf() && Character.toLowerCase(current.data) != 'x')
			return "0";

		else if (current.isLeaf() && Character.toLowerCase(current.data) == 'x')
			return "1";
		
		// splits the tree into left and right, so they can be differentiated seperately
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