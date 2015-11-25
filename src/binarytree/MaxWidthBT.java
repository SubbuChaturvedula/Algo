package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import tree.Node;

public class MaxWidthBT {
	public static int maxWidth = 0;

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		maxWidthBT(root);
		System.err.println();
		System.err.println("Max Width of Binary Tree is :"+maxWidth);
	}

	public static void maxWidthBT(Node root){
		if(root==null){
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int levelNodes=0;
		while(!q.isEmpty()){
			levelNodes=q.size();
			if(maxWidth<levelNodes){
				maxWidth=levelNodes;
			}
			while(levelNodes>0){
				Node n=q.remove();
				System.err.print(n.data+" ");
				if(n.left!=null){
					q.add(n.left);
				}
				if(n.right!=null){
					q.add(n.right);
				}
				levelNodes--;
				
			}
			System.err.println();
		}
	}
}
