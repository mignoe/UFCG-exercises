package filtra.linkedlist;

import java.util.Scanner;

class FiltraLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista = sc.nextLine().split(" ");
		int removed = Integer.parseInt(sc.nextLine());
		
		LinkedList list = new LinkedList();
		for (String num : lista){
			list.addLast(Integer.parseInt(num));
		}
				
		list.removeAll(removed);
		
		System.out.println(list.toString());
	}
}

class LinkedList {
	private Node head;
	private Node tail;
	
	public void addLast(int value) {
		if (this.head == null && this.tail == null) {
			this.head = new Node(value);
			this.tail = head;
		} else {
			this.tail.next = new Node(value);
			this.tail.next.prev = this.tail;
			this.tail = this.tail.next;
		}
	}
	
	public void removeAll(int num) {
		
		Node aux = head;
		while(aux != null) {
			if (aux.value == num) {
				if (aux == head) {
					head = head.next;
					aux = aux.next;
				} else if (aux == tail) {
					tail = tail.prev;
					tail.next = null;
					aux = aux.next;
				} else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					aux = aux.prev.next;
				}
			} else {
				aux = aux.next;
			}
			
		}
	}
	
	public String toString() {
		String representacao = "";
		
		Node aux = head;
		while(aux != null) {
			representacao += aux.value + " ";
			aux = aux.next;
		}
		
		if (representacao == "") {
			return "vazia";
		} else {
			return representacao.trim();
		}
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