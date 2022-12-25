package AVL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Rotaciona {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AVL tree = new AVL();
		
		String line = sc.nextLine();
		
		for (String num : line.split(" ")) {
			tree.insert(Integer.parseInt(num));
		}
		
		System.out.println(Arrays.toString(tree.preOrder()));
	}
}

class AVL {
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
		if (node.value > value) {
			if (node.left == null) {
				node.left = new Node();
				node.left.value = value;
				node.left.parent = node;
			} else {
				insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new Node();
				node.right.value = value;
				node.right.parent = node;
			} else {
				insert(node.right, value);
			}			
		}
		
		rebalanceUp(node);
	}
	
	private void rebalance(Node node) {
		int balance = balance(node);
		
		if (balance > 1) {
			if (node.left != null &&
					balance(node.left) < 0) {
				rotateLeft(node.left);
			}
			
			rotateRight(node);
		}

		if (balance < 1) {
			if (node.right != null &&
					balance(node.right) > 0) {
				rotateRight(node.right);
			}
			
			rotateLeft(node);
		}
		
	}
	
	private void rebalanceUp(Node node) {
		if (node != null) {
			rebalance(node);
			rebalanceUp(node.parent);
		}
	}
	
	private int balance(Node node) {
		return height(node.left) - height(node.right);
	}
	
	private int height(Node node) {
		if (node == null) return -1;
		
		else return 1 + Math.max(height(node.left), height(node.right)); 
	}
	
	private void rotateLeft(Node node) {
		if (node == root) {
			root = node.right;
			node.right = root.left;
			root.left = node;
			
			root.left.parent = root;
			
			if (root.right != null) {
				root.right.parent = root;
			}
		} else {
			Node parent = node.parent;
			Node right = node.right;
			node.right = right.left;
			right.left = node;
			
			if (right.value < parent.value) {
				parent.left = right;
			} else {
				parent.right = right;
			}
			
			right.left.parent = right;
			
			if (right.right != null) {
				right.right.parent = right;				
			}
		}
	}
	private void rotateRight(Node node) {
		if (node == root) {
			root = node.left;
			node.left = root.right;
			root.right = node;
			
			root.right.parent = root;
			if (root.left != null) {
				root.left.parent = root;
			}
		} else {
			Node parent = node.parent;
			Node left = node.left;
			node.left = left.right;
			left.right = node;
			
			if (left.value < parent.value) {
				parent.left = left;
			} else {
				parent.right = left;
			}
			
			if (left.left != null) {
				left.left.parent = left;
			}
			
			left.right.parent = left;
		}
	}
	
	public Integer[] preOrder() {
		ArrayList<Integer> list = new ArrayList<>();
		
		preOrder(root, list);
		
		return list.toArray(new Integer[list.size()]);
	}
	
	private void preOrder(Node node, List<Integer> list) {
		if (node != null) {
			list.add(node.value);
			preOrder(node.left, list);
			preOrder(node.right, list);
		}
	}
}




class Node {
	Node left;
	Node right;
	Node parent;
	
	int value;
}
