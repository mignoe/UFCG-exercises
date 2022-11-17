package trim.linkedlist;

import java.util.Scanner;

class TrimLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista = sc.nextLine().split(" ");
		int trim = Integer.parseInt(sc.nextLine());
		
		LinkedList list = new LinkedList();
		for (String num : lista){
			list.addLast(Integer.parseInt(num));
		}
		
		for (int i = 1; i <= trim; i++) {
			list.removeFirst();
			list.removeLast();
		}
		
		System.out.println(list.toString());
	}
}

class LinkedList {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public void addLast(int value) {
		if (head == null && tail == null) {
			head = new Node(value);
			tail = head;
		} else {
			tail.next = new Node(value);
			tail.next.prev = tail;
			tail = tail.next;
		}
		
		size++;
	}
	
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
				this.head.prev = null;
			}
		}
		size--;
	}

	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.head == this.tail) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			size--;
		}
	}
	
	public boolean isEmpty() {
		return tail == null && head == null;
	}
	
	public String toString() {
		if (this.isEmpty())
			return "vazia";
		
		String representacao = "";
		
		Node aux = head;
		for (int i = 0; i < size; i++) {
			representacao += aux.value + " ";
			aux = aux.next;
		}
		
		return representacao.trim();
	}
}

class Node {
	public int value;
	public Node next;
	public Node prev;
	
	public Node(int value) {
		this.value = value;
	}
	
}
