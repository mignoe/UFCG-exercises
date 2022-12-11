package bst.direita;

import java.util.Scanner;

public class BSTDireita {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Tree tree = new Tree();
		
		String[] line = sc.nextLine().split(" ");
		
		for (String num : line) {
			tree.insert(Integer.parseInt(num));
		}
		
		Queue fila = new Queue(line.length);
		fila.push(tree.root);
		
		String result = "";
		
		while (!fila.isEmpty()) {
			Node n = fila.dequeue();
			
			if (n.right != null) {
				fila.push(n.right);
			}
			
			if (n.left != null) {
				fila.push(n.left);
			}
			
			result += n.value + " ";
		}
		
		
		System.out.println(result.trim());
	}
	
	

}

class Node {
	Node left;
	Node right;
	
	int value;
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
}

class Queue {
	
	int tamanho;
	int head;
	int topo;
	Node[] array;
	
	public Queue(int tamanho) {
		this.array = new Node[tamanho];
		this.tamanho = tamanho;
		head = -1;
		topo = -1;		
	}
	
	public void push(Node num) {
		
		if (head == -1) {
			head = 0;
		}
		array[++topo] = num;
	}
	
	public Node dequeue() {
		return array[head++];
	}
	
	public boolean isEmpty() {
		return head > topo;
	}
}
