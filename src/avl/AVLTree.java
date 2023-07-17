package avl;

public class AVLTree {
	Node root;

	int calculateHeight(Node node) {
		int lh = 0;
		int rh = 0;

		if (node.left != null)
			lh = node.left.height;
		if (node.right != null)
			rh = node.right.height;

		return lh > rh ? lh : rh;// condition ? true : false
	}

	int calculateBF(Node node) {
		int lh = 0;
		int rh = 0;

		if (node.left != null)
			lh = node.left.height;
		if (node.right != null)
			rh = node.right.height;

		return lh - rh;
	}

	Node leftRotate(Node node) {
		return null;
	}

	Node rightRotate(Node node) { // 30
		return null;
	}

	Node insert(Node node, int data) { // insert(50 , 60) -->
		if (node == null) {
			node = new Node(data);
			return node;
		}
		if (node.data < data) {
			// right
			node.right = insert(node.right, data);
		} else {
			// left
			node.left = insert(node.left, data);
		}

		node.height = 1 + calculateHeight(node);

		int bf = calculateBF(node);

		if (bf < -1) {
			// right
			if (node.right.data < data) {
				// right RR
				System.out.println("RR for " + node.data);

				// return leftRotate(node);
			} else {
				// left RL
				System.out.println("RL for " + node.data);
				// node.right = rightRotate(node.right);
//				return leftRotate(node); 
			}
		}

		if (bf > 1) {
			// left

			if (node.left.data > data) {
				// left LL
				System.out.println("LL for " + node.data);
//				return rightRotate(node);
			} else {
				// right LR
				System.out.println("LR for " + node.data);
//				node.left = leftRotate(node.left);
//				return rightRotate(node);
			}
		}
		return node;
	}

	void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	public static void main(String[] args) {
		AVLTree avl = new AVLTree();

		avl.root = avl.insert(avl.root, 50);

		avl.root = avl.insert(avl.root, 30);

		avl.root = avl.insert(avl.root, 40);

	}
}

class Node {
	int data;
	Node left, right;
	int height;

	Node(int data) {
		this.data = data;
		this.height = 1;
		this.left = null;
		this.right = null;
	}
}
