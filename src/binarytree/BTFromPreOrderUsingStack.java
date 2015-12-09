package binarytree;

import java.util.Stack;

import tree.Node;

/*Example: int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };

First element in the preorder[] will definitely be the root, which is 20 here.
Create a node with data 20 and push it in Stack.
Now take the next element (say data) from the preorder sequence.
If data is greater than the top item in the stack then keep popping out the nodes 
from the stack, keep storing it in temp node till the top node in stack is less than the data.
create a node with data and add it to the right of temp node and push the temp node to stack.
If data is less than the top item in the stack then create a node with data and 
add it to the left of top node in stack and push it in the stack.
Repeat the above two steps till all the elements in preorder[] is over.
return the root
Time Complexity: O(n)*/
public class BTFromPreOrderUsingStack {

	public static void main(String[] args) {
		int[] preOrder = { 10, 5, 2, 7, 15, 12, 20 };
		Node root = constructTree(preOrder);
		displayTree(root);
	}

	public static Node constructTree(int[] preorder) {
		Stack<Node> s = new Stack<Node>();
		Node root = new Node(preorder[0]);
		s.push(root);
		for (int i = 1; i < preorder.length; i++) {
			Node temp = null;
			while (!s.isEmpty() && preorder[i] > s.peek().data) {
				temp = s.pop();
			}
			if (temp != null) {
				temp.right = new Node(preorder[i]);
				s.push(temp.right);
			} else {
				s.peek().left = new Node(preorder[i]);
				s.push(s.peek().left);
			}
		}
		return root;
	}
	public static void displayTree(Node root) {
		if (root != null) {
			displayTree(root.left);
			System.out.print(" " + root.data);
			displayTree(root.right);
		}
	}

}
