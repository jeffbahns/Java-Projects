import java.util.Scanner;
class Main {

	public static void main(String[]args) {

		Scanner s = new Scanner(System.in);
		String infix = s.next();
		System.out.println(infix);
		
	}

	// takes a infix expression string as input
	// returns a binary tree that corresponds to original expression
	public static BinaryTree binaryInfixTreeBuilder(String infixStr) {

		for (int i = 0; i < infixStr.length(); i++)
			System.out.println(infixStr.charAt(i));
		

		// empty return tree, no purpose
		BinaryTree nullness = new BinaryTree();
		return nullness;
	}

}