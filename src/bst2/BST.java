package bst2;

//BST 
public class BST {
	Node root = null;

	Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}

	Node insertNode(Node currentRoot, int data) { // 100,300 => 200,300
		if (currentRoot == null) {
			currentRoot = createNode(data);// 300
			return currentRoot;
		} else if (currentRoot.data < data) {
			// right
			currentRoot.right = insertNode(currentRoot.right, data);// 100

		} else if (currentRoot.data > data) {
			// left
			currentRoot.left = insertNode(currentRoot.left, data);// 100->left = (50);
		}

		return currentRoot;// 100
	}

	void inOrder(Node root) {// 100
		if (root == null)
			return;
		// left
		inOrder(root.left);
		// root
		System.out.println(root.data);// 50 100 120 200 250 300 350
		// right
		inOrder(root.right);//
	}

	void preOrder(Node root) {// 100
		if (root == null)
			return;

		// root
		System.out.println(root.data);// 50 100 120 200 250 300 350

		// left
		preOrder(root.left);
		// right
		preOrder(root.right);//
	}

	void postOrder(Node root) {// 100
		if (root == null)
			return;

		// left
		postOrder(root.left);
		// right
		postOrder(root.right);//

		// root
		System.out.println(root.data);// 50 100 120 200 250 300 350

	}

	public static void main(String[] args) {
		BST bst = new BST();// root -> null

		bst.root = bst.insertNode(bst.root, 200);// 100
		bst.insertNode(bst.root, 100);// 100->right => 200
		bst.insertNode(bst.root, 300);// 100->left => 50

		bst.insertNode(bst.root, 50);// 100->right->right => 300
		bst.insertNode(bst.root, 120);// 100->right->right => 300
		bst.insertNode(bst.root, 250);// 100->right->right => 300
		bst.insertNode(bst.root, 350);// 100->right->right => 300

		bst.inOrder(bst.root);
		bst.preOrder(bst.root);

	}
}

//container 
class Node {
	int data;
	Node left;
	Node right;
}