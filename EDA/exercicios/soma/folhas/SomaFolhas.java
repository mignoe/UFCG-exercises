package soma.folhas;

import java.util.Scanner;

class SomaFolhas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Tree tree = new Tree();
		
		for (String num : sc.nextLine().split(" ")) {
			tree.insert(Integer.parseInt(num));
		}
		
		System.out.println(tree.sumLeafs());
	}
}

class Node {
	Node right;
	Node left;
	
	int value;
	
	boolean isLeaf() {
		return right == null && left == null;
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
	
	public int sumLeafs() {
		int result = 0;
		if (root != null) {
			result += sumLeafs(root);
		}
		
		return result;
	}
	
	private int sumLeafs(Node node) {
		if (node.isLeaf()) {
			return node.value;
		} else {
			int result = 0;
			
			if (node.left != null) {
				result += sumLeafs(node.left);
			}
			if (node.right != null) {
				result += sumLeafs(node.right);
			}
			
			return result;
			
		}
	}
}

