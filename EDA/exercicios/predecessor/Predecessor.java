package predecessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Predecessor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tree tree = new Tree();
		
		for (String num : sc.nextLine().split(" ")) {
			tree.insert(Integer.parseInt(num));
		}
		
		System.out.println( Arrays.toString(
								tree.predecessor(Integer.parseInt(sc.nextLine()))
							)
				);
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
				node.left.parent = node;
			} else {
				insert (node.left, value);
			}
		} else {
			if(node.right == null) {
				node.right = new Node();
				node.right.value = value;
				node.right.parent = node;
			} else {
				insert(node.right, value);
			}
		}
	}
	
	private Node search(Node node, int value) {
		Node result;
		
		if (node.value == value) {
			result = node;
		} else if (node.value > value) {
			result = search(node.left, value);
		} else {
			result = search(node.right, value);
		}
		
		return result;
	}
	
	public Integer[] predecessor(int value) {
		ArrayList<Integer> lista = new ArrayList<>();
		Node elementNode = search(root, value);
		
		
		if (elementNode.left != null) {
			lista.add(elementNode.value);
			maximum(elementNode.left, lista);
		} else {
			maximumParent(elementNode, value, lista);
		}
		
		return (Integer[]) lista.toArray(new Integer[lista.size()]);
	}
	
	private void maximum(Node node, ArrayList<Integer> lista) {		
		if (node.right != null) {
			lista.add(node.value);
			maximum(node.right, lista);
		} else {
			lista.add(node.value);
		}
	}
	
	private void maximumParent(Node node, int value, ArrayList<Integer> lista) {
		if(node.value < value) {
			lista.add(node.value);
		} else {
			lista.add(node.value);
			if (node.parent != null) {
				maximumParent(node.parent, value, lista);
			}
		}
	}
}

class Node {
	Node right;
	Node left;
	Node parent;
	
	int value;
}