package bst;

import java.util.Scanner;

public class BstDemo {

	static Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}

	static Node insertNode(Node root, int data) { //null,50
		if (root == null) {
			root = createNode(data);
			return root;
		}else {
			if(data > root.data) {
				//big - right 
				root.right = insertNode(root.right,data);//null,50
			}else {
				//small - left 
				root.left = insertNode(root.left,data);
			}
		}
		return root;
	}

	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
		Node root = null;

		root = insertNode(root, 30);
		insertNode(root, 50);//[(30),50]
		insertNode(root,10); 
		insertNode(root,100);
		insertNode(root,45);
		insertNode(root,15);
		
		
		// while (true) {
//			System.out.println("\n0 for exit");
//			System.out.println("1 for add node");
//			System.out.println("Enter Choice");
//			int choice = scr.nextInt();
//
//			switch (choice) {
//			case 1:
//				System.out.println("Enter data");
//				int data = scr.nextInt(); 
//				break;
//			case 0:
//				System.exit(0);
//			}
//		}
	}
}

class Node {
	int data;
	Node left, right;

}