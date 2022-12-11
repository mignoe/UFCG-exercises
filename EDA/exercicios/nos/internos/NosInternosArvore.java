package nos.internos;

import java.util.Scanner;

class NosInternosArvore {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 Tree tree = new Tree();
		 
		 for (String num : sc.nextLine().split(" ")) {
			tree.insert(Integer.parseInt(num));
		}
		 
		 System.out.println(tree.internNodes());
	}

}

class Tree {
	Node root;
	
	public void insert(int value) {
		if (root == null) {
			root = new Node();
			root.value = value;
		} else {
			insert(root, value);
		}
	}
	
	private void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node();
				node.left.value = value;
			} else {
				insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new Node();
				node.right.value = value;
			} else {
				insert(node.right, value);
			}
		}
	}
	
	public int internNodes() {
		int result = 0;
		
		if (root != null) {
			result += internNodes(root);
		}
		
		return result;
	}
	
	private int internNodes(Node node) {
		int result = 0;
		
		if (!node.isLeaf()) {
			result += 1;
		}
		if (node.left != null) {
			result += internNodes(node.left);
		}
		if (node.right != null) {
			result += internNodes(node.right);
		}
		
		return result;
		
	}
}

class Node {
	Node right;
	Node left;
	
	int value;
	
	public boolean isLeaf() {
		return this.right == null && this.left == null;
	}
}